import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lexical.Token;

public class Parser {
	static Queue<Token>queue=new LinkedList<Token>();
	private static Scanner in;
	public static boolean isType(String name) {
		if(name.equals("INT") || name.equals("STRING") || name.equals("FLOAT") || name.equals("CHARACTER")|| name.equals("BOOLEAN")) {
			return true;
		}
		return false;
	}
	public static void readTokens() throws FileNotFoundException {
		String fileAddress="output.txt";
		in = new Scanner(new File(fileAddress));
		while(in.hasNext()){
			String x=in.nextLine();
			if(x.charAt(0)!='<')
				continue;
			String tmp="",tmp1="";
			int i=2;
			for( ; ;i++) {
				if(x.charAt(i)=='>' || x.charAt(i)==' ')
					break;
				tmp+=x.charAt(i);
			}
			while(i<x.length() && x.charAt(i)==' ')
				i++;
			if(tmp.equals("M_COMMENTS") || tmp.equals("EOL"))
				continue;
			
			i+=5;
			while(i<x.length() && x.charAt(i)!='-') {
				tmp1+=x.charAt(i++);
			}
//			System.out.println(tmp+" -- "+tmp1);
			queue.add(new Token(tmp,tmp1,""));
		}
	}
	public static void parse() throws FileNotFoundException {
		readTokens();
	}
	
	
	
	public static ClassDeclaration classDeclaration() {
		Token top=queue.peek();
		if(top.name.equals("class")) {
			queue.poll();
			System.out.println("From ClassDeclaration Call Identifer");
			Identifier id=identifier();
			Identifier id2=null;
			top=queue.peek();
			
			if(top.name.equals("EXTENDS")) {
				queue.poll();
				System.out.println("From ClassDeclaration Call Identifer");
				id2=identifier();
			}
			top=queue.peek();
			if(top.name.equals("LEFT_CURLY_B")) {
				queue.poll();
				System.out.println("From ClassDeclaration Call VarD");
				VarD vd= varD();
				System.out.println("From ClassDeclaration Call ConstructorD");
				ConstructorD cd=constructorD();
				System.out.println("From ClassDeclaration Call MethodD");
				MethodD md=methodD(); 
				if(id2==null)
					return new ClassDeclaration1(id,vd,cd,md);
				else	return new ClassDeclaration1(id,id2,vd,cd,md);
			}
			else {
				return null;
			}
		}
		return null;
	}
	public static boolean isPrivacyType(String x) {
		if(x.equals("public")||x.equals("private")||x.equals("protected"))
			return true;
		return false;
	}
	public static MethodD methodD() {
		Token top=queue.peek();
		if(isPrivacyType(top.value)) {
			System.out.println("From MethodD Call MethodDeclaration");
			MethodDeclaration mdic=methodDeclaration(); 
			System.out.println("From MethodD Call MethodD");
			MethodD md=methodD(); 
			return new MethodD1(mdic,md);
		}
		else	return new MethodD2();
	}
	public static MethodDeclaration methodDeclaration() {
		Token top=queue.peek();
		String privacyType="";
		if(isPrivacyType(top.value)) {
			privacyType=top.value;
			queue.poll();
			System.out.println("From MethodDeclaration Call Type");
			Type t1=type();
			System.out.println("From MethodDeclaration Call Identifier");
			Identifier id1=identifier();
			
			top=queue.peek();
			if(top.value.equals("("))
				queue.poll();
			else return null;
			
			top=queue.peek();
			Type t2=null;
			Identifier id2=null;
			CommaVar cv=null;
			if(isType(top.name)) {
				System.out.println("From MethodDeclaration Call Type");
				t2=type();
				System.out.println("From MethodDeclaration Call Identifier");
				id2=identifier();
				System.out.println("From MethodDeclaration Call CommaVar");
				cv=commaVar();
			}
			top=queue.peek();
			if(top.value.equals(")"))
				queue.poll();
			else	return null;
			top=queue.peek();
			if(top.value.equals("{"))
				queue.poll();
			else	return null;
			System.out.println("From MethodDeclaration Call VarD");
			VarD vd=varD();
			System.out.println("From MethodDeclaration Call Stat");
			Stat st =stat();
			top=queue.peek();
			if(top.value.equals("return")) 
				queue.poll();
			else return null;
			System.out.println("From MethodDeclaration Call Expression");
			Expression ex=expression();
			if(top.value.equals(";")) 
				queue.poll();
			else return null;
			if(top.value.equals("}")) 
				queue.poll();
			else return null;
			if(id2!=null)
				return new MethodDeclaration1(privacyType,t1,t2,id1,id2,cv,vd,st,ex);
			else	return new MethodDeclaration1(privacyType,t1,id1,vd,st,ex);
		}
		else return null;
	}
	public static Stat stat() {
		Token top=queue.peek();
		if(top.value.equals("{")||top.value.equals("if")||top.value.equals("while")||
				top.value.equals("System.out.println")||top.name.equals("ID")) {
			System.out.println("From Stat Call Statement");
			Statement statement=statement();
			System.out.println("From Stat Call Stat");
			Stat stat =stat();
			return  new Stat1(statement,stat);
		}
		return  new Stat2();
	}
	public static Statement statement() {
		Token top=queue.peek();
		if(top.value.equals("{")) {
			
			queue.poll();
			System.out.println("From Statement Call Stat");
			Stat stat =stat();
			top=queue.peek();
			if(top.value.equals("}"))
				queue.poll();
			return new Statement1(stat);
		}
		else if(top.value.equals("if")) {
			queue.poll();
			top=queue.peek();
			if(top.value.equals("("))
				queue.poll();
			else	return null;
			System.out.println("From Statement Call Expression");
			Expression ex=expression();
			if(top.value.equals(")"))
				queue.poll();
			else	return null;
			System.out.println("From Statement Call Statement");
			Statement st=statement();
			System.out.println("From Statement Call IfStar");
			IfStar f=ifStar();
			return new Statement2(ex,st,f);
		}
		else if(top.value.equals("while")) {
			queue.poll();
			top=queue.peek();
			if(top.value.equals("("))
				queue.poll();
			else	return null;
			System.out.println("From Statement Call Expression");
			Expression ex=expression();
			if(top.value.equals(")"))
				queue.poll();
			else	return null;
			System.out.println("From Statement Call Statement");
			Statement st=statement();
			return new Statement3(ex,st);
		}
		else if(top.value.equals("System.out.println")) {
			queue.poll();
			top=queue.peek();
			if(top.value.equals("("))
				queue.poll();
			else	return null;
			System.out.println("From Statement Call Expression");
			Expression ex=expression();
			if(top.value.equals(")"))
				queue.poll();
			else	return null;
			return new Statement4(ex);
		}
		else if(isType(top.name)) {
			queue.poll();
			System.out.println("From Statement Call Identifier");
			Identifier id=identifier();
			System.out.println("From Statement Call IdStar");
			IdStar ids=idStar();
			return new Statement5(id,ids);
		}
		else{
			return null;
		}
	}
	public static IfStar ifStar() {
		Token top=queue.peek();
		if(top.value.equals("else")) {
			queue.poll();
			System.out.println("From IfStar Call Statement");
			Statement st=statement();
			return new IfStar1(st);
		}
		return new IfStar2();
	}
	public static IdStar idStar() { // ***************
		System.out.println("hello from idStar");
		Token top=queue.peek();
		if(top.value.equals("=")) {
			queue.poll();
			System.out.println("From IdStar Call Expression");
			Expression ex=expression();
			top=queue.peek();
			if(top.value.equals(";")) 
				queue.poll();
			else return null;
			
			return new IdStar1(ex);
		}
		else if(top.value.equals("[")) {
			queue.poll();
			System.out.println("From IdStar Call Expression");
			Expression ex1=expression();
			top=queue.peek();
			if(top.value.equals("]")) 
				queue.poll();
			else return null;
			System.out.println("From IdStar Call Expression");
			Expression ex2=expression();
			if(top.value.equals("]")) 
				queue.poll();
			else return null;
			return new IdStar2(ex1,ex2);
		}
		return null;
	}
	public static Expression expression() {
		Token top=queue.peek();
		
		if(top.name.equals("INTEGER_LITERAL")) {
			String INT=top.name;
			queue.poll();
			System.out.println("expr "+queue.peek().name);
			System.out.println("From Expression Call Expression");
			ExprStar exs=exprStar();
			return new Expression1(INT,exs);
		}
		else if(top.name.equals("FLOAT_LITERAL")) {
			String FLOAT=top.name;
			queue.poll();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression2(FLOAT,exs);
		}
		else if(top.value.equals("true")) {
			queue.poll();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression3(exs);
		}
		else if(top.value.equals("true")) {
			queue.poll();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression4(exs);
		}
		else if(top.name.equals("ID")) {
			queue.poll();
			System.out.println("From Expression Call Identifier");
			Identifier id=identifier();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression5(exs,id);
		}
		else if(top.value.equals("this")) {
			queue.poll();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression6(exs);
		}
		else if(top.value.equals("new")) {
			queue.poll();
			System.out.println("From Expression Call NewStar");
			NewStar ns= newStar();
			return new Expression7(ns);
		}
		else if(top.value.equals("!")) {
			queue.poll();
			System.out.println("From Expression Call Expression");
			Expression ex= expression();
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression8(ex,exs);
		}
		else if(top.value.equals("(")) {
			queue.poll();
			System.out.println("From Expression Call Expression");
			Expression ex= expression();
			top=queue.peek();
			if(!top.value.equals(")"))	return null;
			System.out.println("From Expression Call ExprStar");
			ExprStar exs=exprStar();
			return new Expression9(ex,exs);
		}
		return null;
	}
	public static NewStar newStar() {
		Token top=queue.peek();
		String t=top.name;
		if(isType(t)) {
			queue.poll();
			top=queue.peek();
			if(!top.value.equals("["))	return null;
			queue.poll();
			System.out.println("From NewStar Call Expression");
			Expression ex= expression();
			top=queue.peek();
			if(!top.value.equals("]"))	return null;
			queue.poll();
			System.out.println("From NewStar Call ExprStar");
			ExprStar exs=exprStar();
			return new NewStar1(t,ex,exs);
		}
		else if(t.equals("ID")) {
			queue.poll();
			System.out.println("From NewStar Call Identifier");
			Identifier id=identifier();
			top=queue.peek();
			if(!top.value.equals("("))	return null;
			queue.poll();
			top=queue.peek();
			Expression ex=null;
			CommaExpr ce=null;
			if(!top.value.equals(")")) {
				System.out.println("From NewStar Call Expression");
				ex=expression();
				System.out.println("From NewStar Call CommaExpr");
				ce=commaExpr();
			}
			if(!top.value.equals(")"))	return null;
			queue.poll();
			System.out.println("From NewStar Call ExprStar");
			ExprStar es=exprStar();
			if(ex==null)
				return new NewStar2(id,es); 
			return new NewStar2(id,ex,es,ce);
		}
		else return null;

	}
	public static CommaExpr commaExpr() {
		Token top=queue.peek();
		if(top.name.equals("COMMA")) {
			queue.poll();
			System.out.println("From CommaExpr Call Expression");
			Expression e=expression();
			System.out.println("From CommaExpr Call CommaExpr");
			CommaExpr cv=commaExpr();
			return new CommaExpr1(e,cv) ;
		}
		return new CommaExpr2() ;
	}
	public static ExprStar exprStar() {
		////
		Token top=queue.peek();
		String t=top.value;
		System.out.println("t = "+ t);
		if(t.equals("==")||t.equals("&&")||t.equals("||")||t.equals("!=")||
				t.equals("+")||t.equals("*")||t.equals("/")||t.equals("-")) {
		}
		else if(t.charAt(0)=='>'|| t.charAt(0)=='<') {
			if(top.name.equals(">=")) {
				t=">";
			}
			if(top.name.equals("<=")) {
				t="<";
			}
			queue.poll();
			System.out.println("From ExprStar Call Equal");
			Equal e=equal();
			System.out.println("From ExprStar Call Expression");
			Expression ex= expression();
			System.out.println("From ExprStar Call ExprStar");
			ExprStar exs=exprStar();
			return new ExprStar1(t,ex,exs,e);
		}
		else if(t.equals("[")) {
			queue.poll();
			System.out.println("From ExprStar Call Expression");
			Expression ex= expression();
			top=queue.peek();
			if(!top.value.equals("]"))	return null;
			queue.poll();
			System.out.println("From ExprStar Call ExprStar");
			ExprStar exs=exprStar();
			return new ExprStar2(ex,exs);
		}
		else if(t.equals(".")) {
			queue.poll();
			System.out.println("From ExprStar Call Dot");
			Dot d=dot();
			return new ExprStar3(d);
		}
		return new ExprStar4();
	}
	public static Goal goal() {
		System.out.println("From Goal Call MainClass");
		MainClass mc=mainClass();
		System.out.println("From Goal Call ClassD");
		ClassD c=classD();
		return new Goal1(mc,c);
	}
	public static MainClass mainClass() {		
		Token top=queue.peek();
		if(!top.value.equals("class"))	return null;
		queue.poll();
		System.out.println("From MainClass Call Identifier");
		Identifier id=identifier();
		top=queue.peek();
		if(!top.value.equals("{")) return null;
		queue.poll();
		
		top=queue.peek();
		if(!top.value.equals("public")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("static")) return null;
		queue.poll();
		top=queue.peek();
		//
		if(!top.value.equals("void")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("main")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("(")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("String")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("[")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("]")) return null;
		queue.poll();
		System.out.println("From MainClass Call Identifier");
		Identifier id2=identifier();
		top=queue.peek();
		if(!top.value.equals(")")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("{")) return null;
		queue.poll();
		System.out.println("From MainClass Call Statement");
		Statement st=statement();
		top=queue.peek();
		if(!top.value.equals("}")) return null;
		queue.poll();
		top=queue.peek();
		if(!top.value.equals("}")) return null;
		queue.poll();
		return new MainClass1(id,id2,st);
	}
	public static ClassD classD() {
		Token top=queue.peek();
		if(top.value.equals("class")) {
//			queue.poll();
			System.out.println("From ClassD Call ClassDeclaration");
			ClassDeclaration cd=classDeclaration();
			System.out.println("From ClassD Call ClassD");
			ClassD c=classD();
			return new ClassD1(cd,c);
		}
		return new ClassD2();
	}
	public static Dot dot() {
		Token top=queue.peek();
		if(top.value.equals(".")) {
			queue.poll();
			top=queue.peek();
			if(!top.value.equals("length"))	return null;
			queue.poll();
			System.out.println("From Dot Call ExprStar");
			ExprStar es=exprStar();
			return new Dot1(es);
		}
		else if(top.name.equals("ID")) {
			queue.poll();
			System.out.println("From Dot Call Identifier");
			Identifier id=identifier();
			top=queue.peek();
			if(!top.value.equals("("))	return null;
			queue.poll();
			top=queue.peek();
			Expression ex=null;
			CommaExpr ce=null;
			/// top.value now = 10
			if(!top.value.equals(")")) {
				System.out.println("From Dot Call Expression");
				ex=expression();
				System.out.println("From Dot Call CommaExpr");
				ce=commaExpr();
				//
				queue.poll();
			}
			//
			top = queue.peek();
			if(!top.value.equals(")"))	return null;
			queue.poll();
			System.out.println("From Dot Call ExprStar");
			ExprStar es=exprStar();
			if(ex==null)
				return new Dot2(id,es); 
			return new Dot2(id,ex,es,ce);
		}
		return null;
	}
	public static Equal equal() {
		Token top=queue.peek();
		if(top.value.equals("=")) {
			return new Equal1();
		}
		return new Equal2();
	}
	public static ConstructorD constructorD() {
		Token top=queue.peek();
		if(top.name.equals("")) {
			System.out.println("From ConstructorD Call ConstructorDeclaration");
			ConstructorDeclaration cd=constructorDeclaration();
			System.out.println("From ConstructorD Call ConstructorD");
			ConstructorD c=constructorD();
			return new ConstructorD1(cd,c);
		}
		return new ConstructorD2();
	}
	public static ConstructorDeclaration constructorDeclaration() {
		System.out.println("From ConstructorDeclaration Call Identifier");
		Identifier id=identifier();
		Token top=queue.peek();
		Type t=null;
		Identifier id1=null;
		CommaVar cv=null;
		if(top.name.equals("LEFT_ROUND_B")) {
			queue.poll();
			top=queue.peek();
			if(isType(top.name)) {
				System.out.println("From ConstructorDeclaration Call Type");
				t=type();
				System.out.println("From ConstructorDeclaration Call Identifier");
				id1=identifier();
				System.out.println("From ConstructorDeclaration Call CommaVar");
				cv=commaVar();
			}
			if(top.name.equals("RIGHT_ROUND_B")) {
				queue.poll();
				top=queue.peek();
				if(top.name.equals("LEFT_CURLY_B")) {
					queue.poll();
					System.out.println("From ConstructorDeclaration Call VarD");
					VarD vd=varD();
					System.out.println("From ConstructorDeclaration Call Stat");
					Stat st=stat();	
					top=queue.peek();
					if(top.value.equals("}")) {
						queue.poll();
					}
					else	return null;
					if(t==null) {
						return new ConstructorDeclaration1(id1,vd, st);
					}
					return new ConstructorDeclaration1(id,t,id1,cv,vd,st);
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
			
		}
		return null;
	}
	public static CommaVar commaVar() {
		Token top=queue.peek();
		if(top.name.equals("COMMA")) {
			queue.poll();
			System.out.println("From CommaVar Call Type");
			Type t=type();
			System.out.println("From CommaVar Call Identifier");
			Identifier id=identifier();
			System.out.println("From CommaVar Call CommaVar");
			CommaVar cv=commaVar();
			return new CommaVar1(t,id,cv) ;
		}
		return new CommaVar2() ;
	}
	public static VarD varD() {
		Token top=queue.peek();
		if(isType(top.name)) {
			System.out.println("From VarD Call VarDeclaration");
			VarDeclaration vr = varDeclaration();
			System.out.println("From VarD Call VarD");
			VarD vd=varD();
			return new VarD1(vr,vd);
		}
		return new VarD2();
	}
	public static VarDeclaration varDeclaration() {
		System.out.println("From VarDeclaration Call Type");
		Type t=type();
		System.out.println("From VarDeclaration Call Identifier");
		Identifier id=identifier();
		return new VarDeclaration1(t,id);
	}
	public static Identifier identifier() {
		Token top=queue.peek();
		if(top.name.equals("ID")) {
			queue.poll();
			return new Identifier(top.value);
		}
		return null;
	}
	public static Type type() {
		Token top=queue.peek();
		if(isType(top.name)) {
			queue.poll();
			System.out.println("From Type Call SquareBrackets");
			SquareBrackets sq=squareBrackets();
			return new Type1(top.value,sq);
		}
		return null;
	}
	public static SquareBrackets squareBrackets() {
		Token top=queue.peek();
		if(top.name.equals("LEFT_SQUARE_B")) {
			queue.poll();
			top=queue.peek();
			if(top.name.equals("RIGHT_SQUARE_B")) {
				queue.poll();
				return new SquareBrackets2();
			}
			else	return null;
		}
		return new SquareBrackets2();
	}
}

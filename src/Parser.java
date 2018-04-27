import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lexical.Token;

public class Parser {
	static Queue<Token>queue=new LinkedList<Token>();
	public static boolean isType(String name) {
		if(name.equals("INT") || name.equals("STRING") || name.equals("FLOAT") || name.equals("CHARACTER")|| name.equals("BOOLEAN")) {
			return true;
		}
		return false;
	}
	public static void readTokens() throws FileNotFoundException {
		String fileAddress="output.txt";
		Scanner in = new Scanner(new File(fileAddress));
		while(in.hasNext()){
			//System.out.println(in.nextLine());
			String x=in.nextLine();
			if(x.charAt(0)!='<')
				continue;
			//System.out.println(x);
			String tmp="",tmp1="";
			int i=2;
			for( ; ;i++) {
				if(x.charAt(i)=='>')
					break;
				tmp+=x.charAt(i);
			}
			if(tmp.equals("M_COMMENTS") || tmp.equals("EOL"))
				continue;
			i+=5;
			while(i<x.length() && x.charAt(i)!='-') {
				tmp1+=x.charAt(i++);
			}
			queue.add(new Token(tmp,tmp1,""));
		}
		while(queue.size()>0) {
			Token t=queue.poll();
			System.out.println(t.name+" "+t.value);
		}
	}
	public static void parse() throws FileNotFoundException {
		readTokens();
		ClassDeclaration rule1=Class();
	}
	public static ClassDeclaration Class() {
		Token top=queue.peek();
		if(top.name.equals("class")) {
			queue.poll();
			Identifier id=identifier();
			Identifier id2=null;
			top=queue.peek();
			
			if(top.name.equals("EXTENDS")) {
				queue.poll();
				id2=identifier();
			}
			if(top.name.equals("LEFT_CURLY_B")) {
				queue.poll();
				Type t=type();
				VarD vd= varD();
				ConstructorD cd=constructorD();
				//MethodD md=methodD(); 
				// return new ClassDeclaration1(t,vd,cd,md);
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
			MethodDeclaration mdic=methodDeclaration(); 
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
			Type t1=type();
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
				t2=type();
				id2=identifier();
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
			VarD vd=varD();
			Stat st =stat();
			top=queue.peek();
			if(top.value.equals("return")) 
				queue.poll();
			else return null;
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
			Statement statement=statement();
			Stat stat =stat();
			return  new Stat1(statement,stat);
		}
		return  new Stat2();
	}
	public static Expression expression() {
		return null;
	}
	public static Statement statement() {
		return null;
	}
	public static ConstructorD constructorD() {
		Token top=queue.peek();
		if(top.name.equals("")) {
			ConstructorDeclaration cd=constructorDeclaration();
			ConstructorD c=constructorD();
			return new ConstructorD1(cd,c);
		}
		return new ConstructorD2();
	}
	public static ConstructorDeclaration constructorDeclaration() {
		Identifier id=identifier();
		Token top=queue.peek();
		if(top.name.equals("LEFT_ROUND_B")) {
			queue.poll();
			top=queue.peek();
			if(isType(top.name)) {
				Type t=type();
				Identifier id1=identifier();
				CommaVar cv=commaVar();
			}
			if(top.name.equals("RIGHT_ROUND_B")) {
				queue.poll();
				top=queue.peek();
				if(top.name.equals("LEFT_CURLY_B")) {
					queue.poll();
					VarD v=varD();
					//Stat st=stat();
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
			Type t=type();
			Identifier id=identifier();
			CommaVar cv=commaVar();
			return new CommaVar1(t,id,cv) ;
		}
		return new CommaVar2() ;
	}
	public static VarD varD() {
		Token top=queue.peek();
		if(isType(top.name)) {
			VarDeclaration vr = varDeclaration();
			VarD vd=varD();
			return new VarD1(vr,vd);
		}
		return new VarD2();
	}
	public static VarDeclaration varDeclaration() {
		Type t=type();
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
		}
		return new SquareBrackets2();
	}
	
}

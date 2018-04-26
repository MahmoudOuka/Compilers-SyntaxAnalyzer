import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lexical.LexicalAnalyzer;
import Lexical.Token;

public class Main {

	public static void main(String[] args) throws IOException {
		LexicalAnalyzer.getTokens();
		Expression e2= new Expression1 (3,new ExprStar4());
		ExprStar ex2 = new ExprStar1("+",e2,new ExprStar4());
		Expression e1= new Expression1 (5,ex2);
		System.out.println(e1.getValue());
		
		IdStar id1= new IdStar1(e1);
		Statement s= new Statement5(new Identifier("a"),id1);
		System.out.println(s.getValue());
		Parser.parse();
		
		
//		Expression e3= new Exp3 (e1,'+',e2);
//		Statement s= new Stm3("a",e3);
//        Expression e4= new Exp2 (10);
//        Expression e5= new Exp2 (2);
//        Expression e6= new Exp3 (e4,'*',e5);
//        Statement s2= new Stm3("b",e6);
//        Statement s3=new Stm1(s,s2);
//        Expression e7= new Exp1 ("a");
//        Statement s4=new Stm2(e7);
//        Expression e8= new Exp1 ("b");
//        Statement s5=new Stm2(e8);
//        Statement s6=new Stm1(s4,s5);
//        Statement s7=new Stm1(s3,s6);
        

	}

}

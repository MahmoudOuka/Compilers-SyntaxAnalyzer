import java.io.IOException;

import Lexical.LexicalAnalyzer;

public class Main {

	public static void main(String[] args) throws IOException {
		
//		Expression e2= new Expression1 ("3",new ExprStar4());
//		ExprStar ex2 = new ExprStar1("+",e2,new ExprStar4());
//		Expression e1= new Expression1 ("5",ex2);
//		System.out.println(e1.getValue());
//		
//		IdStar id1= new IdStar1(e1);
//		Statement s= new Statement5(new Identifier("a"),id1);
//		System.out.println(s.getValue());
		
		LexicalAnalyzer.getTokens();
		Parser.parse();
		System.out.println(Parser.goal().getValue());
	}
}
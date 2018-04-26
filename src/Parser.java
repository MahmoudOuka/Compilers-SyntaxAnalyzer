import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Lexical.Token;

public class Parser {
	static Queue<Token>queue=new LinkedList<Token>();
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
			top=queue.peek();
			if(top.name.equals("EXTENDS")) {
				queue.poll();
				Identifier id2=identifier();
			}
			if(top.name.equals("LEFT_CURLY_B")) {
				queue.poll();
				Type t=type();
				// var decleration
			}
			else {
				return null;
			}
		}
		return null;
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
		if(top.name.equals("INT") || top.name.equals("STRING") || top.name.equals("FLOAT") || top.name.equals("CHARACTER")|| top.name.equals("BOOLEAN")) {
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

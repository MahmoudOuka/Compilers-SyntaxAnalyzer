package Lexical;

public class Token {
	public String name,regex,value;
	Token(String _name , String _regex){
		name=_name;
		regex=_regex;
	}
	public Token(String _name , String _value,String _regex){
		name=_name;
		value=_value;
	}
	Token(){
		name="";
		regex="";
	}
}

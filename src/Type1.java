public class Type1 implements Type {
	
	String type ;
	SquareBrackets sqr ;
	
	
	public Type1(String type, SquareBrackets sqr) {
		super();
		this.type = type;
		this.sqr = sqr;
	}
	
	@Override
	public String getValue()
	{
		return type + " " +sqr.getValue();
	}
	

}
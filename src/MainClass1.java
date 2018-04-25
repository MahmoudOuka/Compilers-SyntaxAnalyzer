
public class MainClass1 implements MainClass{
	
	Identifier id1;
	Identifier id2; 
	Statement statement;
	
	public MainClass1(Identifier id1,Identifier id2,Statement statement) {
		this.id1 = id1;
		this.id2 = id2;
		this.statement = statement;
	}

	@Override
    public String getValue() {
        return  "class " + id1.getValue() + "{" + "public" + "static" + "void" + "main" + "(" 
		+ "String" + "[" + "]" + id2.getValue() + ")" + "{" + statement.getValue() + "}" + "}";
    }
}

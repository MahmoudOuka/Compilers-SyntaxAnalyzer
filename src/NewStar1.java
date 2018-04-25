
public class NewStar1 implements NewStar {
	// ("int" | "float" | "String" | "char" | "boolean" ) "[" Expression "]" ExprStar
	
	private String type;
	private Expression expr;
	private ExprStar exprStar;
	public NewStar1(String type, Expression expr, ExprStar exprStar) {
		super();
		this.type = type;
		this.expr = expr;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return type+"["+expr.getValue()+"]"+exprStar.getValue();
	}

}

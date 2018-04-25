
public class Expression4 implements Expression {
	// "false" ExprStar
	private ExprStar exprStar;
	
	public Expression4(ExprStar exprStar) {
		super();
		this.exprStar = exprStar;
	}

	@Override
	public String getValue() {
		return "false"+exprStar.getValue();
	}

}

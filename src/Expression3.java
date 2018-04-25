
public class Expression3 implements Expression {
	// "true" ExprStar
	private ExprStar exprStar;
	
	public Expression3(ExprStar exprStar) {
		super();
		this.exprStar = exprStar;
	}

	@Override
	public String getValue() {
		return "true"+exprStar.getValue();
	}

}

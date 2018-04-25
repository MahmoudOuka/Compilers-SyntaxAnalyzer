
public class Expression6 implements Expression {
	// "this" ExprStar
	private ExprStar exprStar;
	
	public Expression6(ExprStar exprStar) {
		super();
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return "this"+exprStar.getValue();
	}

}

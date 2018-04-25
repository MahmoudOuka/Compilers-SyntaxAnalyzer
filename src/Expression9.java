
public class Expression9 implements Expression {
	// "(" Expression ")" ExprStar

	private Expression expr;
	private ExprStar exprStar;
	public Expression9(Expression expr, ExprStar exprStar) {
		super();
		this.expr = expr;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return "("+expr.getValue()+")"+exprStar.getValue();
	}

}


public class Expression8 implements Expression {
	// "!" Expression ExprStar
	private Expression expr;
	private ExprStar exprStar;
	public Expression8(Expression expr, ExprStar exprStar) {
		super();
		this.expr = expr;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return "!"+expr.getValue()+exprStar.getValue();
	}

}

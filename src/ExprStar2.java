
public class ExprStar2 implements ExprStar {

	//"[" Expression "]" ExprStar
	public Expression expr;
	public ExprStar exprStar;
	public ExprStar2(Expression expr, ExprStar exprStar) {
		super();
		this.expr = expr;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return "["+expr.getValue()+"]"+exprStar.getValue();
	}

}

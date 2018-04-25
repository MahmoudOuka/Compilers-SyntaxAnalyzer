
public class Expression2 implements Expression {
	// <FLOAT_LITERAL> ExprStar
	float floatLiteral;
	ExprStar exprStar;
	public Expression2(float floatLiteral, ExprStar exprStar) {
		super();
		this.floatLiteral = floatLiteral;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return String.valueOf(floatLiteral)+exprStar.getValue();
	}
}

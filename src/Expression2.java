
public class Expression2 implements Expression {
	// <FLOAT_LITERAL> ExprStar
	String floatLiteral;
	ExprStar exprStar;
	public Expression2(String floatLiteral, ExprStar exprStar) {
		super();
		this.floatLiteral = floatLiteral;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return floatLiteral+" "+exprStar.getValue();
	}
}

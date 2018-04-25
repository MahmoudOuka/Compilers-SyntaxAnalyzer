
public class Expression1 implements Expression {
	 // <INTEGER_LITERAL> ExprStar
	int intLiteral;
	ExprStar exprStar;
	public Expression1(int intLiteral, ExprStar exprStar) {
		super();
		this.intLiteral = intLiteral;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return String.valueOf(intLiteral)+exprStar.getValue();
	}

}

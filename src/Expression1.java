
public class Expression1 implements Expression {
	 // <INTEGER_LITERAL> ExprStar
	String intLiteral;
	ExprStar exprStar;
	public Expression1(String intLiteral, ExprStar exprStar) {
		super();
		this.intLiteral = intLiteral;
		this.exprStar = exprStar;
	}
	@Override
	public String getValue() {
		return intLiteral+exprStar.getValue();
	}

}

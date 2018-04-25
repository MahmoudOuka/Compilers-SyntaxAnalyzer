
public class ExprStar1 implements ExprStar {
	///( "&&" | "||" | "==" | "!=" | ">" | "<" | "<" Equal | ">" Equal | "+" | "-" | "*" | "/" ) Expression ExprStar
	
	public String comparisonOperator;
	public Expression expr;
	public ExprStar exprStar;
	public Equal equal;
	public ExprStar1(String comparisonOperator, Expression expr, ExprStar exprStar) {
		super();
		this.comparisonOperator = comparisonOperator;
		this.expr = expr;
		this.exprStar = exprStar;
		this.equal=new Equal2();
	}
	public ExprStar1(String comparisonOperator, Expression expr, ExprStar exprStar,Equal equal) {
		super();
		this.comparisonOperator = comparisonOperator;
		this.expr = expr;
		this.exprStar = exprStar;
		this.equal = equal;
	}
	

	@Override
	public String getValue() {
		return comparisonOperator+equal.getValue()+expr.getValue()+exprStar.getValue();
	}

}

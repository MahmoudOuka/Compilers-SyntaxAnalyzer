import java.util.ArrayList;

public class NewStar2 implements NewStar {
	// Identifier "(" (Expression ( "," Expression)*)? ")" ExprStar
	
	private Identifier id;
	private Expression expr;
	private ExprStar exprStar;
	private ArrayList<Expression>dotExpr;
	
	public NewStar2(Identifier id, Expression expr, ExprStar exprStar, ArrayList<Expression> dotExpr) {
		super();
		this.id = id;
		this.expr = expr;
		this.exprStar = exprStar;
		this.dotExpr = dotExpr;
	}
	public NewStar2(Identifier id, ExprStar exprStar) {
		super();
		this.id = id;
		this.expr = null;
		this.exprStar = exprStar;
		this.dotExpr = null;
	}

	@Override
	public String getValue() {
		if(expr==null) {
			return id.getValue()+" ( )"+exprStar.getValue();
		}
		String value="";
		for(Expression u : dotExpr) {
			value=value+" , "+u.getValue();
		}
		return id.getValue()+" ( "+expr.getValue()+value+" ) "+exprStar.getValue();
	}

}

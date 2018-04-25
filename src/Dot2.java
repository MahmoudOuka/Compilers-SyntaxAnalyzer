import java.util.ArrayList;


public class Dot2 implements Dot{
	private Identifier id;
	private Expression expr;
	private ExprStar exprStar;
	private ArrayList<Expression>dotExpr;
	
	/// Identifier "(" ( Expression ( "," Expression )* )? ")" ExprStar

	public Dot2(Identifier id, Expression expr, ExprStar exprStar, ArrayList<Expression> dotExpr) {
		super();
		this.id = id;
		this.expr = expr;
		this.exprStar = exprStar;
		this.dotExpr = dotExpr;
	}
	public Dot2(Identifier id, ExprStar exprStar) {
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
			value=value+" ,"+u.getValue();
		}
		return id.getValue()+" ( "+expr.getValue()+value+" ) "+exprStar.getValue();
	}


	
}

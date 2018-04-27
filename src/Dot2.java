import java.util.ArrayList;


public class Dot2 implements Dot{
	private Identifier id;
	private Expression expr;
	private ExprStar exprStar;
	private CommaExpr ce;
	
	/// Identifier "(" ( Expression ( "," Expression )* )? ")" ExprStar

	public Dot2(Identifier id, Expression expr, ExprStar exprStar, CommaExpr ce) {
		super();
		this.id = id;
		this.expr = expr;
		this.exprStar = exprStar;
		this.ce = ce;
	}
	public Dot2(Identifier id, ExprStar exprStar) {
		super();
		this.id = id;
		this.expr = null;
		this.exprStar = exprStar;
		this.ce = null;
	}

	@Override
	public String getValue() {
		if(expr==null) {
			return id.getValue()+" ( )"+exprStar.getValue();
		}
		return id.getValue()+" ( "+expr.getValue()+" "+ce.getValue()+" ) "+exprStar.getValue();
	}


	
}

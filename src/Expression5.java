
public class Expression5 implements Expression {
	// Identifier ExprStar
	private ExprStar exprStar;
	private Identifier id;
	
	public Expression5(ExprStar exprStar,Identifier id) {
		super();
		this.exprStar = exprStar;
		this.id = id;
	}

	@Override
	public String getValue() {
		return id.getValue()+exprStar.getValue();
	}

}

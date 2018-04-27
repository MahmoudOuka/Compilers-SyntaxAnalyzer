
public class CommaExpr1 implements CommaExpr {
	Expression ex;
	CommaExpr ce;
	public CommaExpr1(Expression ex, CommaExpr ce) {
		super();
		this.ex = ex;
		this.ce = ce;
	}
	@Override
	public String getValue() {
		return " , "+ex.getValue()+" , "+ce.getValue();
	}

}

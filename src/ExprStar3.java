public class ExprStar3 implements ExprStar {
	Dot dot;
	public ExprStar3(Dot dot) {
		super();
		this.dot = dot;
	}
	@Override
	public String getValue() {
		return "."+dot.getValue();
	}

}

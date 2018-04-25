
public class Dot1 implements Dot {

	ExprStar exprStar;

	
	public Dot1(ExprStar exprStar) {
		super();
		this.exprStar = exprStar;
	}


	@Override
	public String getValue() {
		return ".length"+exprStar.getValue(); 
	}

}

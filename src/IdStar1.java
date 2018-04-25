
public class IdStar1 implements IdStar{
	
	Expression expression;
	
	public IdStar1(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String getValue() {
		return "=" + expression.getValue() + ";";
	}
}

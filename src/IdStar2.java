
public class IdStar2 implements IdStar{
	
	Expression expression1;
	Expression expression2;
	
	public IdStar2(Expression expression1,Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}
	
	@Override
    public String getValue() {
        return "[" + expression1.getValue() + "]" + "=" + expression2.getValue() + ";";
    }
}

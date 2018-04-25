
public class Statement2 implements Statement{
	
	Expression expression;
	Statement statement;
	IfStar ifStar;
	
	public Statement2(Expression expression,Statement statement,IfStar ifStar) {
		this.expression = expression;
		this.statement = statement;
		this.ifStar = ifStar;
	}
	
	@Override
    public String getValue() {
        return "if" + "(" + expression.getValue() + ")" + statement.getValue() + ifStar.getValue();
    }
}
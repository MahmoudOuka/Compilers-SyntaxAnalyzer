
public class IfStar1 implements IfStar{
	
	Statement statement;
	
	public IfStar1(Statement statement) {
		this.statement = statement;
	}
	
	@Override
	public String getValue() {
		return "else" + statement.getValue();
	}
}

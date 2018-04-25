import java.util.ArrayList;

public class Statement1 implements Statement {

	ArrayList<Statement> statements;
	
	public Statement1(ArrayList<Statement> statements) {
		this.statements = statements;
	}
	
	////////////////////////////////////////////////
	@Override
    public String getValue() {
		String value = "";
		for (int i = 0; i < statements.size(); i++) {
			value += statements.get(i).getValue() + " ";
		}
        return  "{" + value + "}";
    }
}
import java.util.ArrayList;

public class Statement1 implements Statement {

	Stat stat;
	
	public Statement1(Stat stat) {
		this.stat = stat;
	}
	
	@Override
    public String getValue() {
        return  "{" + stat.getValue()+ "}";
    }
}
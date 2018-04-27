public class Stat1 implements Stat{
	Statement statment;
	Stat st;
	
	public Stat1(Statement statment, Stat st) {
		super();
		this.statment = statment;
		this.st = st;
	}

	@Override
	public String getValue() {
		return statment.getValue()+" "+st.getValue();
	}

}

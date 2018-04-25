
public class Expression7 implements Expression {
	// "new" NewStar
	private NewStar newStar;
	
	public Expression7(NewStar newStar) {
		super();
		this.newStar = newStar;
	}
	@Override
	public String getValue() {
		return "new"+newStar.getValue();
	}

}

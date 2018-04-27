
public class CommaVar1 implements CommaVar  {
	Type t;
	Identifier id;
	CommaVar cv;
	public CommaVar1(Type t, Identifier id, CommaVar cv) {
		super();
		this.t = t;
		this.id = id;
		this.cv = cv;
	}
	@Override
	public String getValue() {
		return t.getValue()+" "+id.getValue()+" "+cv.getValue();
	}
	
}

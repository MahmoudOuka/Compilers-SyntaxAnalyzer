
public class MethodD1 implements MethodD {
	MethodDeclaration md;
	MethodD m;
	
	public MethodD1(MethodDeclaration md, MethodD m) {
		super();
		this.md = md;
		this.m = m;
	}

	@Override
	public String getValue() {
		return md.getValue()+" "+m.getValue();
	}
}

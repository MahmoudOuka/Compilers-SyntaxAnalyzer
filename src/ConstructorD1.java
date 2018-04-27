
public class ConstructorD1 implements ConstructorD {
	ConstructorDeclaration cd1;
	ConstructorD c;
	public ConstructorD1(ConstructorDeclaration cd1, ConstructorD c) {
		super();
		this.cd1 = cd1;
		this.c = c;
	}
	@Override
	public String getValue() {
		return cd1.getValue()+" "+c.getValue();
	}

}

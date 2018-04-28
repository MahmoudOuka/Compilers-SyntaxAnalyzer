public class ClassD1 implements ClassD{
	private ClassDeclaration cd;
	ClassD c;
	
	public ClassD1(ClassDeclaration cd, ClassD c) {
		super();
		this.cd = cd;
		this.c = c;
	}

	@Override
	public String getValue() {
		return cd.getValue()+" "+c.getValue();
	}
}

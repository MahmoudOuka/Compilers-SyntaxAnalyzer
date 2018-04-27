
public class VarD1 implements VarD {
	VarDeclaration vr1;
	VarD vd1;
	
	public VarD1(VarDeclaration vr1, VarD vd1) {
		super();
		this.vr1 = vr1;
		this.vd1 = vd1;
	}

	@Override
	public String getValue() {
		return vr1.getValue()+" "+vr1.getValue();
	}

}

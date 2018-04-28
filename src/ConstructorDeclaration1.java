
class TypeIdentifier {
	Type type;
	Identifier id;
	
	public TypeIdentifier(Type type, Identifier id) {
		super();
		this.type = type;
		this.id = id;
	}
	
	public String getValue() {
		return type.getValue() + " " + id.getValue();
	}
}

public class ConstructorDeclaration1 implements ConstructorDeclaration{
	
	Identifier id1;
	Type type1;
	Identifier id2;
	CommaVar cv;
	VarD vd;
	Stat st;
	
	public ConstructorDeclaration1(Identifier id1, Type type1, Identifier id2, CommaVar cv, VarD vd, Stat st) {
		super();
		this.id1 = id1;
		this.type1 = type1;
		this.id2 = id2;
		this.cv = cv;
		this.vd = vd;
		this.st = st;
	}
	
	public ConstructorDeclaration1(Identifier id1, VarD vd, Stat st) {
		super();
		this.id1 = id1;
		this.vd = vd;
		this.st = st;
		this.id2 = null;
	}

	@Override
    public String getValue() {
		
		if(id2 == null) {
			return id1.getValue() + "(" + ")" + "{" + vd.getValue() + st.getValue() + "}" ;
		}
		
        return id1.getValue() + "(" + type1.getValue() + id2.getValue() + cv.getValue() + ")" + "{" +
        vd.getValue() +"  "+ st.getValue() ;
    }
}
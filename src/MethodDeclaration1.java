import java.util.ArrayList;

class TypeIdentifier_ {
	Type type;
	Identifier id;
	
	public TypeIdentifier_(Type type, Identifier id) {
		super();
		this.type = type;
		this.id = id;
	}
	
	public String getValue() {
		return type.getValue() + " " + id.getValue();
	}
}

public class MethodDeclaration1 implements MethodDeclaration  {
	
	String privacyType;
	Type type1;
	Type type2;
	Identifier id1;
	Identifier id2;
	CommaVar cv;
	VarD vd;
	Stat st;
	Expression expression;
	


    public MethodDeclaration1(String privacyType, Type type1, Type type2, Identifier id1, Identifier id2, CommaVar cv,
			VarD vd, Stat st, Expression expression) {
		super();
		this.privacyType = privacyType;
		this.type1 = type1;
		this.type2 = type2;
		this.id1 = id1;
		this.id2 = id2;
		this.cv = cv;
		this.vd = vd;
		this.st = st;
		this.expression = expression;
	}
	public MethodDeclaration1(String privacyType, Type type1, Identifier id1, VarD vd, Stat st, Expression expression) {
		super();
		this.cv = null;
		this.type2 = null;
		this.id2 = null;
		this.privacyType = privacyType;
		this.type1 = type1;
		this.id1 = id1;
		this.vd = vd;
		this.st = st;
		this.expression = expression;
	}
	@Override
	public String getValue(){
		String x= expression.getValue();
		if(id2 == null) {
			return privacyType + type1.getValue() + id1.getValue() + "(" + ")" + "{" + vd.getValue() +
					st.getValue() + "return" + x + ";" + "}";
		}
		return privacyType + type1.getValue() + id1.getValue() + "(" + type1.getValue()+" "+id2.getValue()+" "+cv.getValue() + ")" + "{" + vd.getValue() +
				st.getValue() + "return" + x + ";" + "}";
    }
}
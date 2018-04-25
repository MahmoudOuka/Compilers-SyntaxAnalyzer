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

public class MethodDeclaration1 {
	
	String privacyType;
	Type type1;
	Type type2;
	Identifier id1;
	Identifier id2;
	ArrayList<VarDeclaration> varDeclaration;
	ArrayList<Statement> statement;
	ArrayList<TypeIdentifier_> typeIdentifier;
	Expression expression;

	public MethodDeclaration1(String privacyType, Type type1, Type type2, Identifier id1, Identifier id2,
			ArrayList<VarDeclaration> varDeclaration, ArrayList<Statement> statement,
			ArrayList<TypeIdentifier_> typeIdentifier, Expression expression) {
		super();
		this.privacyType = privacyType;
		this.type1 = type1;
		this.type2 = type2;
		this.id1 = id1;
		this.id2 = id2;
		this.varDeclaration = varDeclaration;
		this.statement = statement;
		this.typeIdentifier = typeIdentifier;
		this.expression = expression;
	}

	public MethodDeclaration1(String privacyType, Type type1, Identifier id1,
			ArrayList<VarDeclaration> varDeclaration, ArrayList<Statement> statement,
			Expression expression) {
		super();
		this.privacyType = privacyType;
		this.type1 = type1;
		this.type2 = null;
		this.id1 = id1;
		this.id2 = null;
		this.varDeclaration = varDeclaration;
		this.statement = statement;
		this.typeIdentifier = null;
		this.expression = expression;
	}

    public String getValue(){
		String value1 = "";
		String value2 = "";
		String value3 = "";
		for (int i = 0; i < varDeclaration.size(); i++) {
			value1 += varDeclaration.get(i).getValue() + " ";
		}
		for (int i = 0; i < statement.size(); i++) {
			value2 += statement.get(i).getValue() + " ";
		}
		for (int i = 0; i < typeIdentifier.size(); i++) {
			value3 += " , " + typeIdentifier.get(i).getValue() + " ";
		}
		
		if(id2 == null) {
			String x= expression.getValue();
			return privacyType + type1.getValue() + id1.getValue() + "(" + ")" + "{" + value1 +
					value2 + "return" + x + ";" + "}";
		}
		
        return privacyType + type1.getValue() + id1.getValue() + "(" + type2.getValue() + 
        		id2.getValue() + value3 + ")" + "{" + value1 + value2 + "return" + 
        		expression.getValue() + ";" + "}";
    }
}
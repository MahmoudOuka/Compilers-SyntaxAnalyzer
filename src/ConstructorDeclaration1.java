import java.util.ArrayList;

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
	Identifier id2;
	Type type1;
	ArrayList<VarDeclaration> varDeclaration;
	ArrayList<Statement> statement;
	ArrayList<TypeIdentifier> typeIdentifier;
	
	public ConstructorDeclaration1(Identifier id1, Identifier id2,Type type1,
			ArrayList<VarDeclaration> varDeclaration, ArrayList<Statement> statement,
			ArrayList<TypeIdentifier> typeIdentifier) {
		this.id1 = id1;
		this.id2 = id2;
		this.type1 = type1;
		this.varDeclaration = varDeclaration;
		this.statement = statement;
		this.typeIdentifier = typeIdentifier;
	}
	
	public ConstructorDeclaration1(Identifier id1,ArrayList<VarDeclaration> varDeclaration, 
			ArrayList<Statement> statement) {
		this.id1 = id1;
		this.id2 = null;
		this.type1 = null;
		this.varDeclaration = varDeclaration;
		this.statement = statement;
		this.typeIdentifier = null;
	}

	@Override
    public String getValue() {
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
			return id1.getValue() + "(" + ")" + "{" + value1 + value2 + "}" ;
		}
		
        return id1.getValue() + "(" + type1.getValue() + id2.getValue() + value3 + ")" + "{" +
        		value1 + value2 ;
    }
}

public class VarDeclaration1 implements VarDeclaration{
	
	Type type;
	Identifier id;
	
	public VarDeclaration1(Type type,Identifier id) {
		this.type = type;
		this.id = id;
	}
	
	@Override
    public String getValue() {
		return type.getValue() + id.getValue() + ";";
    }
}

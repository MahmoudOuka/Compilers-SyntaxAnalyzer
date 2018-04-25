import java.util.ArrayList;

public class Goal1 implements Goal{
	
	MainClass mainClass;
	ArrayList<ClassDeclaration> classDeclaration;
	
	public Goal1(MainClass mainClass,ArrayList<ClassDeclaration> classDeclaration) {
		this.mainClass = mainClass;
		this.classDeclaration = classDeclaration;
	}
	
	@Override
    public String getValue() {
		String value = "";
		for (int i = 0; i < classDeclaration.size(); i++) {
			value += classDeclaration.get(i).getValue() + " ";
		}
        return  mainClass.getValue() + value + "<EOF>";
    }
}
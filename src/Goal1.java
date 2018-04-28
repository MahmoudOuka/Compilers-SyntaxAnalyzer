
public class Goal1 implements Goal{
	
	MainClass mainClass;
	ClassD c;
	
	public Goal1(MainClass mainClass,ClassD c) {
		this.mainClass = mainClass;
		this.c = c;
	}
	
	@Override
    public String getValue() {
        return mainClass.getValue() + " "+c.getValue();
    }
}
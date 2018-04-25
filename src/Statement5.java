
public class Statement5 implements Statement{
	
	Identifier id;
	IdStar idStar;
	
	public Statement5(Identifier id,IdStar idStar) {
		this.id = id;
		this.idStar = idStar;
	}
	
	@Override
    public String getValue() {
        return id.getValue() + " " + idStar.getValue();
    }
}
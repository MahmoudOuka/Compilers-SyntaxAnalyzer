import java.util.ArrayList;

public class ClassDeclaration1 implements ClassDeclaration {
	
	Identifier id ; 
	Identifier id1 ;
	
	 ArrayList<VarDeclaration>  vd ;
	ArrayList<ConstructorDeclaration> cd ;
	ArrayList<MethodDeclaration> md;
	
	
	public ClassDeclaration1(Identifier id, Identifier id1, ArrayList<VarDeclaration> vd,
			ArrayList<ConstructorDeclaration> cd, ArrayList<MethodDeclaration> md) {
		super();
		this.id = id;
		this.id1 = id1;
		this.vd = vd;
		this.cd = cd;
		this.md = md;
	}

	
	public ClassDeclaration1(Identifier id, ArrayList<VarDeclaration> vd,
			ArrayList<ConstructorDeclaration> cd, ArrayList<MethodDeclaration> md) {
		super();
		this.id = id;
		this.id1 = null;
		this.vd = vd;
		this.cd = cd;
		this.md = md;
	}


	@Override
	public String getValue()
	{   
		String value1 = "";
		for(int i=0;i<vd.size();i++)
		{
			value1+=vd.get(i).getValue()+" ";
		}
		
		String value2 = "";
		for(int i=0;i<cd.size();i++)
		{
			value2+=cd.get(i).getValue()+" ";
		}
		
		String value3 = "";
		for(int i=0;i<md.size();i++)
		{
			value3+=md.get(i).getValue()+" ";
		}
		
		
		String ans = "";
		ans +="class "+id.getValue();
		if(id1!= null)
			ans+="extends "+id1.getValue();
			
		return ans+"{"+value1+value2+value3+"}" ;
	}

}

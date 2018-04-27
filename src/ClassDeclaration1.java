import java.util.ArrayList;

public class ClassDeclaration1 implements ClassDeclaration {
	
	Identifier id ; 
	Identifier id1 ;
	
	VarD vd ;
	ConstructorD cd ;
	MethodD md;
	
	
	public ClassDeclaration1(Identifier id, Identifier id1,VarD vd,
			ConstructorD cd, MethodD md) {
		super();
		this.id = id;
		this.id1 = id1;
		this.vd = vd;
		this.cd = cd;
		this.md = md;
	}

	
	public ClassDeclaration1(Identifier id, VarD vd,
			ConstructorD cd, MethodD md) {
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
		String ans = "";
		ans +="class "+id.getValue();
		if(id1!= null)
			ans+="extends "+id1.getValue();
		return ans+"{ "+vd.getValue()+" "+cd.getValue()+" "+md.getValue()+" }" ;
	}

}

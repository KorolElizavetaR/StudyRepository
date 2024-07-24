package koroler.Spring.IoCDI_DZ;

public class MetalMusic implements Music{
	String name;
	
	public MetalMusic (String name)
	{
		setName(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}

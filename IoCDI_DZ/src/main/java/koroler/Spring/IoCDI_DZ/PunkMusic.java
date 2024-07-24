package koroler.Spring.IoCDI_DZ;

public class PunkMusic implements Music{
	String name;
	public PunkMusic (String name)
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

package koroler.spring.InitDestroy;

public class ClassicalMusic implements Music{
	String name;
	
	public ClassicalMusic(String name)
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

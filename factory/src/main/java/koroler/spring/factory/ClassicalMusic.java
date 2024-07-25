package koroler.spring.factory;

public class ClassicalMusic implements Music{
	String name;
	
	public static ClassicalMusic getClassicalMusic()
	{
		return new ClassicalMusic();
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

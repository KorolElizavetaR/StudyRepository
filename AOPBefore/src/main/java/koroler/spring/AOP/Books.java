package koroler.spring.AOP;

public class Books {
	String name;
	String author;
	public Books(String name, String author) {
		setName(name);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAuthor(String name)
	{
		this.name = name;
	}
	
	public String getBook()
	{
		return name + " by " + author;
	}
}

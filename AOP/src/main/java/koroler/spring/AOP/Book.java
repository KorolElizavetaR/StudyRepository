package koroler.spring.AOP;

public class Book {
	String name;
	String author;
//
//	public Book(String name, String author) {
//		setName(name);
//	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getName()
	{
		return name;
	}
}

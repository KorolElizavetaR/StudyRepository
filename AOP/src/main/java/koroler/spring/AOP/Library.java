package koroler.spring.AOP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ConfigurationProperties("list")
public class Library {
	List<Book> books;
	
	public void setBooks(List<Book> books) {
	this.books = new ArrayList<>();
	for (Book book: books)
	{
		this.books.add(book);
	} }
	
	public String getBook(Integer id)
	{
		return books.get(id).getName() + " by " + books.get(id).getAuthor();
	}
	
	public List<Book> getBooks()
	{
		return this.books;
	}
	
	public void getBooks(Boolean bool)
	{
		System.out.println("Library books:");
		for (Book book: books)
		System.out.println(book.getName() + " by " + book.getAuthor());
	}
	
	public void addBook(AnnotationConfigApplicationContext context, String name, String author)
	{
		Book book = context.getBean(("books"), Book.class);
		book.setName(name);
		book.setAuthor(author);
		this.books.add(book);
		System.out.println("Book is succesfully added");
	}
}

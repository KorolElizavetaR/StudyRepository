package koroler.spring.AOP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("list")
public class Library {
	List<Book> books;
	
	public void setBooks(List<Book> books) {
		 this.books = new ArrayList<>();
			for (Book book: books)
			{
				this.books.add(book);
			} }
	
	public String getBook(int id)
	{
		return books.get(id).getName() + " by " + books.get(id).getAuthor();
	}
}

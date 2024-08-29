package koroler.spring.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import koroler.spring.library.models.Book;
import koroler.spring.library.models.Person;
import koroler.spring.library.repos.BooksRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class BookService {
	@Autowired
	private final BooksRepository bookRepos;
	
	public List<Book> getBookList()
	{
		return bookRepos.findAll();
	}
	
	public Book findBook(Integer id)
	{
		return bookRepos.findById(id).orElse(null);
	}
	
	@Transactional
	public void saveBook(Book book)
	{
		bookRepos.save(book);
	}
	
	@Transactional
	public void updateBook(Integer id, Book newBook)
	{
		newBook.setId(id);
		bookRepos.save(newBook);
	}
	
	public void deletePerson(Integer id)
	{
		bookRepos.deleteById(id);
	}
//	
//	public Person getBookByPersonId(Integer id)
//	{
//		return bookRepos.getBookByPersonId(id);
//	}

}

package koroler.spring.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.project1.DAOs.BooksDAO;
import koroler.spring.project1.DAOs.PeopleDAO;
import koroler.spring.project1.models.Book;

@Controller
@RequestMapping ("/books")
public class BooksController {
	@Autowired
	PeopleDAO peopleDAO;
	@Autowired
	BooksDAO booksDAO;
	
	@GetMapping ()
	public String GetBooks(Model model)
	{
		model.addAttribute("books", booksDAO.getBooks());
		return "books/list";
	}
	
	@GetMapping ("/{id}")
	public String getBook(Model model, @PathVariable ("id") Integer id)
	{
		Book book = booksDAO.getBook(id);
		model.addAttribute("book", book);
		model.addAttribute("person", peopleDAO.getPerson(book.getBook_owner()));
		return "books/book";
	}
	// books
	// books/new
	// books/{id}
	// books/{id}/edit
}

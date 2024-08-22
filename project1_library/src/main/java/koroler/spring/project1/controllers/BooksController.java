package koroler.spring.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.project1.DAOs.BooksDAO;
import koroler.spring.project1.DAOs.PeopleDAO;
import koroler.spring.project1.models.Book;
import koroler.spring.project1.models.Person;

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
	public String getBook(Model model, @PathVariable ("id") Integer id, @ModelAttribute ("person") Person person)
	{
		Book book = booksDAO.getBook(id);
		model.addAttribute("book", book);
		model.addAttribute("owner", peopleDAO.getPerson(book.getBook_owner()));
		model.addAttribute("people", peopleDAO.getList());
		return "books/book";
	}
	
	@PatchMapping ("/{id}")
	public String addBookOwner(Person person)
	{
		System.out.println(person.getPerson_id());
		return "redirect:/books/{id}";
	}
	
	// books
	// books/new
	// books/{id}
	// books/{id}/edit
}

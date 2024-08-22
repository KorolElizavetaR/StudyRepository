package koroler.spring.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
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
	
	@PatchMapping ("/{id}/add")
	public String addBookOwner(Person person, @PathVariable("id") Integer id)
	{
		booksDAO.addOwner(person.getPerson_id(), id);
		//System.out.println(person.getPerson_id());
		return "redirect:/books/{id}";
	}
	
	@PatchMapping ("/{id}/remove")
	public String removeBookOwner(@PathVariable("id") Integer id)
	{
		booksDAO.addOwner(null, id);
		//System.out.println(person.getPerson_id());
		return "redirect:/books/{id}";
	}
	
	@GetMapping ("/add")
	public String addBook(@ModelAttribute Book book)
	{
		return "books/addbook";
	}
	
	@PostMapping () 
	public String submitAddBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return "books/addbook";
		}
		booksDAO.addBook(book);
		return "redirect:/books";
	}
	
	@GetMapping ("/{id}/edit")
	public String editBook(Model model, @PathVariable ("id") Integer id)
	{
		model.addAttribute("book", booksDAO.getBook(id));
		model.addAttribute("book_ID", id);
		return "books/editbook";
	}
	
	@PatchMapping ("/{book_ID}")
	public String commitEditBook(@Valid @ModelAttribute ("book") Book book, BindingResult bindingResult, @PathVariable ("book_ID") Integer id)
	{
		if (bindingResult.hasErrors())
		{
			return "books/editbook";
		}
		booksDAO.updateBook(book, id);
		return "redirect:/books/{book_ID}";
	}
	// books
	// books/new
	// books/{id}
	// books/{id}/edit
}

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
	
	// Получить список всех книг
	@GetMapping ()
	public String GetBooks(Model model)
	{
		model.addAttribute("books", booksDAO.getBooks());
		return "books/list";
	}
	
	// Получить книгу по айди
	@GetMapping ("/{id}")
	public String getBook(Model model, @PathVariable ("id") Integer id, @ModelAttribute ("person") Person person)
	{
		Book book = booksDAO.getBook(id);
		model.addAttribute("book", book);
		model.addAttribute("owner", peopleDAO.getPerson(book.getBook_owner()));
		model.addAttribute("people", peopleDAO.getList());
		return "books/book";
	}
	
	// из /books/{id} - добавить читателя книге
	@PatchMapping ("/{id}/add")
	public String addBookOwner(Person person, @PathVariable("id") Integer id)
	{
		booksDAO.addOwner(person.getPerson_id(), id);
		return "redirect:/books/{id}";
	}
	
	// из /books/{id} - удалить читателя книги
	@PatchMapping ("/{id}/remove")
	public String removeBookOwner(@PathVariable("id") Integer id)
	{
		booksDAO.addOwner(null, id);
		return "redirect:/books/{id}";
	}
	
	// добавить книгу - из /books
	@GetMapping ("/add")
	public String addBook(@ModelAttribute Book book)
	{
		return "books/addbook";
	}
	
	@PostMapping ("/add") 
	public String submitAddBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return "books/addbook";
		}
		booksDAO.addBook(book);
		return "redirect:/books";
	}
	
	// Редачить книгу
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
}

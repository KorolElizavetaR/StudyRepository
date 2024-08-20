package koroler.spring.project1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/books")
public class BooksController {
	@GetMapping ()
	public String GetBooks(Model model)
	{
		return "books/list";
	}
	// books
	// books/new
	// books/{id}
	// books/{id}/edit
}

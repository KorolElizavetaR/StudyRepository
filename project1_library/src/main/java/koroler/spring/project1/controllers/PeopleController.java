package koroler.spring.project1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.project1.DAOs.BooksDAO;
import koroler.spring.project1.DAOs.PeopleDAO;

@Controller
@RequestMapping ("/people")
public class PeopleController {
	@Autowired
	PeopleDAO peopleDAO;
	@Autowired
	BooksDAO booksDAO;

	// people/{id} - конкретный человек
	// people/{id}/edit
	// people/add
	
	// people - список из людей. Есть кнопка добавить человека
	@GetMapping () 
	public String peoplePage(Model model)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "people/list";
	}
	
	@GetMapping ("/{id}") 
	public String personPage(Model model, @PathVariable ("id") Integer id)
	{
		model.addAttribute("person", peopleDAO.getPerson(id));
		model.addAttribute("books", booksDAO.getBooksByPerson(id));
		return "people/person";
	}
	
	@GetMapping ("/add") 
	public String addPerson(Model model)
	{
		
		return "people/person";
	}
}

package koroler.spring.project1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import koroler.spring.project1.DAOs.BooksDAO;
import koroler.spring.project1.DAOs.PeopleDAO;
import koroler.spring.project1.models.Person;

@Controller
@RequestMapping ("/people")
public class PeopleController {
	@Autowired
	PeopleDAO peopleDAO;
	@Autowired
	BooksDAO booksDAO;

	// people/{id}/edit
	// people/add
	
	// people - список из людей. Есть кнопка добавить человека
	@GetMapping () 
	public String peoplePage(Model model)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "people/list";
	}
	
	//  people/{id} - конкретный человек
	@GetMapping ("/{id}") 
	public String personPage(Model model, @PathVariable ("id") Integer id)
	{
		model.addAttribute("person", peopleDAO.getPerson(id));
		model.addAttribute("books", booksDAO.getBooksByPerson(id));
		return "people/person";
	}
	
	// people/add - добавить чушбана
	@GetMapping ("/add") 
	public String addPerson(@ModelAttribute Person person) //@ModelAttribute ??
	{
		return "people/addPerson";
	}
	
	@PostMapping ()
	public String submitAddPerson(@Valid Person person, BindingResult bindingResult)
	{
		// Короче на дате проверочка кринж
		// на ФИО желательно придумать паттерн
		if (bindingResult.hasErrors())
		{
			return "people/addPerson";
		}
		peopleDAO.addPerson(person);
		return "redirect:/people";
	}
	
	// delete person
	@DeleteMapping ("/{id}")
	public String deletePerson(@PathVariable("id") Integer id)
	{
		peopleDAO.deletePerson(id);
		return "redirect:/people";
	}
}

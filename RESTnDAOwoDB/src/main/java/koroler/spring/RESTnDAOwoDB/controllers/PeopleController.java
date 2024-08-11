package koroler.spring.RESTnDAOwoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.RESTnDAOwoDB.DAO.PersonDAO;
import koroler.spring.RESTnDAOwoDB.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PersonDAO personDAO;
	
	@GetMapping () 
	public String GetList (Model model) {
		model.addAttribute("people", personDAO.getList());
		return "people/list"; 
	}
	
	@GetMapping ("/{id}")
	public String ShowPerson(@PathVariable ("id") Integer id, Model model)
	{
		model.addAttribute("person", personDAO.getPerson(id));
		return "people/person";
	}
	
	@GetMapping("/new")
	public String addPerson(@ModelAttribute("human") Person person)
	{
		return "people/newPerson";
	}
	
	@PostMapping()
	public String SuccesfulCreation(@ModelAttribute("human") Person person)
	{
		personDAO.addPerson(person);
		return "redirect:/people";
	}
}

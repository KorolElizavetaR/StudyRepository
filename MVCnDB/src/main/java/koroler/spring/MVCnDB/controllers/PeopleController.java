package koroler.spring.MVCnDB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import koroler.spring.MVCnDB.DAO.PersonDAO;
import koroler.spring.MVCnDB.models.Person;

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
	
	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person)
	{
		return "people/new";
	}
	
	@PostMapping()
	public String addPerson(Person person, BindingResult bindingResult)
	{//@ModelAttribute("person") 
		if (bindingResult.hasErrors())
		{
			return "people/new";
		}
		personDAO.addPerson(person);
		return "redirect:/people";
	}
}

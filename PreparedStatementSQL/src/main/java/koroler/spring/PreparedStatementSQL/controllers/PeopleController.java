package koroler.spring.PreparedStatementSQL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.PreparedStatementSQL.DAOs.PeopleDAO;
import koroler.spring.PreparedStatementSQL.models.Person;

@Controller
@RequestMapping ("/people")
public class PeopleController {
	@Autowired
	PeopleDAO peopleDAO;
	
	// Main page
	@GetMapping ()
	public String getList(Model model)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "people/list";
	}
	
	// Person page
	@GetMapping("/{id}")
	public String getPerson(Model model, @PathVariable ("id") Integer id)
	{
		model.addAttribute("person", peopleDAO.getPerson(id));
		return "people/person";
	}
	
	//Add person
	@GetMapping ("/add")
	public String addPerson(@ModelAttribute ("person") Person person)
	{
		return "people/add";
	}
	
	@PostMapping ()
	public String submitAddPerson(BindingResult bindingResult)
	{
		return "redirect:/people";
	}
	
//	//Update person
//	@GetMapping ()
//	public String UpdatePerson()
//	{
//		
//		return "people/edit";
//	}
}

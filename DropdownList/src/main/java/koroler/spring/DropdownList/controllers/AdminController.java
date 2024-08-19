package koroler.spring.DropdownList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.DropdownList.DAOs.PeopleDAO;
import koroler.spring.DropdownList.models.Person;

@Controller
@RequestMapping
public class AdminController {
	PeopleDAO peopleDAO;
	
	@Autowired
	public AdminController(PeopleDAO peopleDAO) {
	this.peopleDAO = peopleDAO;
	}
	
	@GetMapping()
	public String adminPage(Model model, @ModelAttribute ("person") Person person)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "admin/page";
	}
	
	@PatchMapping ("/add")
	public String addAdmin(Person person)
	{
		System.out.println(person.getId());
		return "redirect:/people";
	}
}

package koroler.spring.RESTnDAOwoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import koroler.spring.RESTnDAOwoDB.DAO.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	@Autowired
	private PersonDAO personDAO;
	
	@GetMapping () 
	public String index (Model model) {
		model.addAttribute("people", personDAO.getList());
		return "people/list"; 
	}
	
	@GetMapping ("/{id}")
	public String ShowPerson(@PathVariable ("id") Integer id, Model model)
	{
		model.addAttribute("person", personDAO.getPerson(id));
		return "people/person";
	}
}

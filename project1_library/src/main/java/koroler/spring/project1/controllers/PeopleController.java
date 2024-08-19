package koroler.spring.project1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.project1.DAOs.PeopleDAO;

@Controller
@RequestMapping ("/people")
public class PeopleController {
	@Autowired
	PeopleDAO peopleDAO;

	// people - список из людей. Есть кнопка добавить человека
	// people/add 
	// people/{id} - конкретный человек
	// people/{id}/edit
	
	@GetMapping ()
	public String peoplePage(Model model)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "people/list";
	}
}

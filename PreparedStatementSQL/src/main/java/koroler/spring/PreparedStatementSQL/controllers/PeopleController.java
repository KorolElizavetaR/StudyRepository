package koroler.spring.PreparedStatementSQL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import koroler.spring.PreparedStatementSQL.DAOs.PeopleDAO;

@Controller
@RequestMapping ("/people")
public class PeopleController {
	@Autowired
	PeopleDAO peopleDAO;
	
	@GetMapping ()
	public String getList(Model model)
	{
		model.addAttribute("people", peopleDAO.getList());
		return "people/list";
	}
}

package korol.spring.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import korol.spring.security.pojo.Person;
import korol.spring.security.security.PersonDetails;

@Controller
public class HelloController {
	
	@GetMapping ()
	public String userInfo(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		PersonDetails personDetails = (PersonDetails)auth.getPrincipal();
		Person person = personDetails.getPerson();
		System.out.println(person);
		model.addAttribute("person", person);
		return "hello/userinf";
	}

}

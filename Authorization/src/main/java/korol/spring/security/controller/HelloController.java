package korol.spring.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@GetMapping ("/api/userInfo")
	public Person userInfoJSON(Model model)
	{
		PersonDetails personDetails = (PersonDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return personDetails.getPerson();
	}
	
	@ResponseBody
	@GetMapping ("/home")
	public String homePage()
	{
		return "home";
	}
	
	@ResponseBody
	@GetMapping ("/hello")
	public String helloPage()
	{
		return "HELLO YAAAY";
	}
	
	@GetMapping ("/admin")
	public String adminPage(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		PersonDetails personDetails = (PersonDetails)auth.getPrincipal();
		Person person = personDetails.getPerson();
		System.out.println(person);
		model.addAttribute("person", person);
		return "hello/ADMIN";
	}

}

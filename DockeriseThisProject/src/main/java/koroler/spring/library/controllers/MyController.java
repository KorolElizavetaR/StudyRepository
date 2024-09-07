package koroler.spring.library.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping () 
	public String HelloPage(Model model)
	{
		return "HelloWorld";
	}
}

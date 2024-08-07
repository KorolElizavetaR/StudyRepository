package koroler.smvc.controllers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/koroler") //notice! <a> tag in html will not return requested page
public class FirstControllerClass {
	@GetMapping ("/helloWorld")
	public String helloWorld() {
		return "first/helloWorld"; //html docname.Если точнее, возвращает имя представления.
	}
	
	@GetMapping ("/farewell")
	public String GoodRiddance()
	{
		return "first/farewell";
	}
}

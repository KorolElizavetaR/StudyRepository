package korol.smvc.RequestParamSMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyControllerClass {
	@GetMapping ("/helloWorld")
	public String helloWorld(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		return "first/helloWorld"; 
	}
	//HttpServletRequest положит null в переменные при отсутствии их в url запросе
	
	@GetMapping ("/farewell")
	public String GoodRiddance(@RequestParam (value = "name", required = false) String name)
	{
		System.out.println(name);
		return "first/farewell";
	}
	// С @RequestParam если переменные не передаются, страница не найдена. Исправляется с помощью required
}

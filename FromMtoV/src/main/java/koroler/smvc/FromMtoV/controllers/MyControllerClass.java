package koroler.smvc.FromMtoV.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import koroler.smvc.FromMtoV.Calculation;

@Controller
public class MyControllerClass {
	@GetMapping ("/helloWorld") // http://localhost:8080/helloWorld?name=amogus
	public String helloWorld(@RequestParam (value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "helloWorld"; 
	}
	
	@GetMapping ("/calculator") // http://localhost:8080/calculator?a=2&b=5.6&status=1
	public String Calculator(@RequestParam (value = "a") Double a, 
							 @RequestParam (value = "b") Double b,  
							 @RequestParam (value = "status") Integer status, Model model)
	{
		model.addAttribute("result", Calculation.calculateValues(a, b, status));
		return "calculator";
	}
}

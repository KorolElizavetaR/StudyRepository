package korol.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import korol.spring.security.pojo.Person;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping ("/login")
	public String loginPage()
	{
		return "auth/login";
	}

}

package korol.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import korol.spring.security.pojo.Person;
import korol.spring.security.services.RegistrationService;
import korol.spring.security.util.PersonValidator;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	private final PersonValidator personValidator;
	
	@Autowired
	private final RegistrationService regService;
	
	@GetMapping ("/login")
	public String loginPage()
	{
		return "auth/login";
	}
	
	@GetMapping ("/reg")
	public String regPage(@ModelAttribute ("person") Person person)
	{
		return "auth/reg";
	}
	
	@PostMapping("/reg")
	public String performReg(@ModelAttribute ("person") @Valid Person person, BindingResult bindingResult)
	{
		personValidator.validate(person, bindingResult);
		if (bindingResult.hasErrors())
			return "/auth/reg";
		regService.register(person);
		return "redirect:/auth/login";
	}

}

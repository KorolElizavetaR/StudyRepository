package korol.rest.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {
	@GetMapping ("/hello")
	public String greeting()
	{
		return "Hello world!";
	}
	
	@GetMapping ("/")
	public String homepage()
	{
		return "accessible by everyone!";
	}
	
	@GetMapping("/no")
	private String secured()
	{
		return "You are logged in";
	}
}

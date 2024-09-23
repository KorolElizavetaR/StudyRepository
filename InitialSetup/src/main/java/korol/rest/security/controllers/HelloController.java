package korol.rest.security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import korol.rest.security.models.UserPrincipal;
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
	private String secured(@AuthenticationPrincipal UserPrincipal principal)
	{
		return "You are logged in as " + principal.getUsername();
	}
	
	@GetMapping("/admin")
	private String admin(@AuthenticationPrincipal UserPrincipal principal)
	{
		return "Admin page. You are: " + principal.getUsername();
	}
}

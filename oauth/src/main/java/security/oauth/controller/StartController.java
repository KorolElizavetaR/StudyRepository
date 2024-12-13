package security.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import security.oauth.model.User;
import security.oauth.service.UserService;

@RequiredArgsConstructor
@RestController
public class StartController {
	private final UserService userService;
	
	@GetMapping("/hi")
	public String home() {
		return "hello";
	}
	
	@GetMapping("/gay")
	public User secured() {
		return userService.addUser();
	}
}

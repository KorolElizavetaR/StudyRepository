package korol.rest.security.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import korol.rest.security.models.LoginRequest;
import korol.rest.security.models.LoginResponse;
import korol.rest.security.security.JWTIssuer;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final JWTIssuer jwtIssuer;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody @Validated LoginRequest request)
	{
		var token = jwtIssuer.issue(1L, request.getUsername(), List.of("USER"));
		return new LoginResponse(token); // наверное штоб не писать new нужен билдер
	}
}

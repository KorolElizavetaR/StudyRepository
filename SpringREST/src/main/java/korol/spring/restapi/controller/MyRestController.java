package korol.spring.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController // теперь мы возвращаем не представления, а объекты
@RequestMapping ("/api")
public class MyRestController {
	
	// @ResponseBody - помечает, что мы возвращаем не представление, а строку
	@GetMapping ("/hello")
	private String sayHello() {
		return "Hello World";
	}
}

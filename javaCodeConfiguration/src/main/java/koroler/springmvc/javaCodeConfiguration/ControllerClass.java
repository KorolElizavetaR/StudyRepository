package koroler.springmvc.javaCodeConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {
	@GetMapping ("/helloWorld")
	public String helloWorld() {
		return "hello world";
	}
}

package koroler.spring.SpringMVCApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import koroler.spring.SpringMVCApp.models.Person;
import koroler.spring.SpringMVCApp.models.Product;
import koroler.spring.SpringMVCApp.services.PeopleService;
import koroler.spring.SpringMVCApp.services.ProductsService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("/people")
@RequiredArgsConstructor
public class PeopleController {
	@Autowired
	private final PeopleService peopleService;
	@Autowired
	private final ProductsService productsService;
	
	// Main page
	@GetMapping ()
	public String getList(Model model)
	{
		model.addAttribute("people", peopleService.getList());
		List <Product> products = productsService.getList();
		for (Product product: products)
			System.out.println(product);
		System.out.println("\n\n" + productsService.findByOwner(peopleService.findPerson(10002)));
		return "people/list";
	}
}

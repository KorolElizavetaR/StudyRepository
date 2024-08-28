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
//		List <Product> products = productsService.getList();
//		for (Product product: products)
//			System.out.println(product);
//		System.out.println("\n\n" + productsService.findByOwner(peopleService.findPerson(10002)));
		return "people/list";
	}
	
	// Person page
		@GetMapping("/{id}")
		public String getPerson(Model model, @PathVariable ("id") Integer id)
		{
			model.addAttribute("person", peopleService.findPerson(id));
			return "people/person";
		}
		
		//Add person
		@GetMapping ("/add")
		public String addPerson(@ModelAttribute ("person") Person person)
		{
			return "people/add";
		}
		
		@PostMapping ()
		public String submitAddPerson(@Valid Person person, BindingResult bindingResult)
		{
			//@ModelAttribute ("person")
			if (bindingResult.hasErrors())
			{
				return "people/add";
			}
			peopleService.savePerson(person);
			return "redirect:/people";
		}
		
		//Update person
		@GetMapping ("/{id}/edit")
		public String UpdatePerson(Model model, @PathVariable ("id") Integer id)
		{
			model.addAttribute("person", peopleService.findPerson(id));
			return "people/edit";
		}
		
		@PatchMapping ("/{id}")
		public String submitUpdatePerson(@ModelAttribute("person") Person person, BindingResult bindingResult, @PathVariable("id") Integer id)
		{
			if (bindingResult.hasErrors())
			{
				return "people/edit";
			}
			//System.out.println(person + "id : " + id);
			peopleService.updatePerson(id, person);
			return "redirect:/people/{id}"; // "redirect:/people";
		}
		
		//Delete person
		@DeleteMapping ("/{id}")
		public String submitDeletePerson(@PathVariable("id") Integer id)
		{
			peopleService.deletePerson(id);
			return "redirect:/people";
		}
}

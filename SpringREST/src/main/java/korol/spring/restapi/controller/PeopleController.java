package korol.spring.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import korol.spring.restapi.models.Person;
import korol.spring.restapi.service.PeopleService;
import korol.spring.restapi.util.InvalidPersonException;
import korol.spring.restapi.util.PeopleErrorResponse;
import korol.spring.restapi.util.PersonNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/people")
@RequiredArgsConstructor
public class PeopleController {
	@Autowired
	private final PeopleService peopleService;

	@GetMapping ()
	public List<Person> getList()
	{
		return peopleService.getPeopleList();
	}
	
	@GetMapping ("/{id}")
	public Person getList(@PathVariable ("id") Integer id)
	{
		return peopleService.findPerson(id);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> addPerson(@RequestBody @Valid Person person, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			StringBuilder errorMsg = new StringBuilder();
			List<FieldError> errList = bindingResult.getFieldErrors();
			for (FieldError err:errList)
			{
				 errorMsg.append(err.getField()).append(" - ").append(err.getDefaultMessage()).append("; ");
			}
			throw new InvalidPersonException(errorMsg.toString());
		}
		peopleService.savePerson(person);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@ExceptionHandler
	private ResponseEntity<PeopleErrorResponse> handleExceptionPersonNotFoundException(PersonNotFoundException ex)
	{
		PeopleErrorResponse errResponse = new PeopleErrorResponse("ERROR: Person with given id does not exists", System.currentTimeMillis());
		return new ResponseEntity<PeopleErrorResponse>(errResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler 
	private ResponseEntity<PeopleErrorResponse> handleExceptionInvalidPersonException(InvalidPersonException ex)
	{
		PeopleErrorResponse errResponse = new PeopleErrorResponse(ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<PeopleErrorResponse>(errResponse, HttpStatus.BAD_REQUEST);
	}
}

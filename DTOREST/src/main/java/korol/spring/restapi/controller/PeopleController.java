package korol.spring.restapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import koroler.spring.library.dto.PersonDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/people")
@RequiredArgsConstructor
public class PeopleController {
	@Autowired
	private final PeopleService peopleService;
	
	@Autowired
	private final ModelMapper mapper;

	@GetMapping ()
	public List<PersonDTO> getList()
	{
		return peopleService.getPeopleList().stream().map(this::convertToPersonDTO).collect(Collectors.toList() );
	}
	
	@GetMapping ("/{id}")
	public PersonDTO getPerson(@PathVariable ("id") Integer id)
	{
		
		return convertToPersonDTO(peopleService.findPerson(id));
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> addPerson(@RequestBody @Valid PersonDTO person, BindingResult bindingResult)
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
		peopleService.savePerson(convertToPerson(person)); //есть подозрение, что это должно быть не в контроллере, но ладно
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	private Person convertToPerson(@Valid PersonDTO person) {
		return mapper.map(person, Person.class);
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
	
	private PersonDTO convertToPersonDTO(@Valid Person person) {
		return mapper.map(person, PersonDTO.class);
	}
}

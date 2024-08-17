package koroler.spring.SpringValidator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import koroler.spring.SpringValidator.DAOs.PeopleDAO;
import koroler.spring.SpringValidator.models.Person;

@Component
public class PersonValidator implements Validator {
//	@Autowired
	private PeopleDAO peopleDAO;
	
	@Autowired
	private PersonValidator (PeopleDAO peopleDAO)
	{
		this.peopleDAO = peopleDAO;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		// посмотреть, если чел с таким же эмейлом в бд
		if (peopleDAO.searchByEmail(person.getEmail()).isPresent())
		{
			errors.rejectValue("email", "", "This email is already taken");
		}
	}
	
}

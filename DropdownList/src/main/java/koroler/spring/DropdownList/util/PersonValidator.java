package koroler.spring.DropdownList.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import koroler.spring.DropdownList.DAOs.PeopleDAO;
import koroler.spring.DropdownList.models.Person;


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
		person = peopleDAO.searchByEmail(person.getEmail());
		if (person != null)
		{
			errors.rejectValue("email", "", "This email is already taken");
		}
	}
	
}

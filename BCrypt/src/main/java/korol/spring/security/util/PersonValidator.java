package korol.spring.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import korol.spring.security.pojo.Person;
import korol.spring.security.services.PersonDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PersonValidator implements Validator {
	@Autowired
	private final PersonDetailsService peopleService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		try
		{
			peopleService.loadUserByUsername(person.getUsername());
			errors.rejectValue("username", "", "[Такой человек уже есть]");
			
		}
		catch (UsernameNotFoundException ex)
		{
			return;
		}
	}

}

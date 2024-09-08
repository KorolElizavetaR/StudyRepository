package korol.spring.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import korol.spring.security.pojo.Person;
import korol.spring.security.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
	@Autowired
	private final PeopleRepository peopleRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public void register(Person person)
	{
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		peopleRepository.save(person);
	}
}

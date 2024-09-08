package korol.spring.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import korol.spring.security.pojo.Person;
import korol.spring.security.repository.PeopleRepository;
import korol.spring.security.security.PersonDetails;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService{
	@Autowired
	private final PeopleRepository peopleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional <Person> person = peopleRepository.findByUsername(username);
		if (person.isEmpty())
			throw new UsernameNotFoundException("User " + username + " is not found");
		return new PersonDetails(person.get());
	}
}

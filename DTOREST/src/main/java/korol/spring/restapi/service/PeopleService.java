package korol.spring.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import korol.spring.restapi.models.Person;
import korol.spring.restapi.repos.PeopleRepository;
import korol.spring.restapi.util.PersonNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class PeopleService {
	@Autowired
	private final PeopleRepository peopleRepos;
	
	public List<Person> getPeopleList()
	{
		return peopleRepos.findAll();
	}
	
	public Person findPerson(Integer id) //optional
	{
		return peopleRepos.findById(id).orElseThrow(PersonNotFoundException::new);
	}
	
	@Transactional
	public void savePerson(Person person)
	{
		peopleRepos.save(person);
	}
	
	@Transactional
	public void updatePerson(Integer id, Person newPerson)
	{
		newPerson.setId(id);
		peopleRepos.save(newPerson);
	}
	
	@Transactional
	public void deletePerson(Integer id)
	{
		peopleRepos.deleteById(id);
	}
}

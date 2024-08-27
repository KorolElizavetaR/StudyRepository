package koroler.spring.SpringMVCApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import koroler.spring.SpringMVCApp.models.Person;
import koroler.spring.SpringMVCApp.repos.PeopleRepository;
import lombok.RequiredArgsConstructor;


@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class PeopleService {
	@Autowired
	private final PeopleRepository peopleRepos;
	
	public List<Person> getList()
	{
		return peopleRepos.findAll();
	}
	
	public Person findPerson(Integer id)
	{
		return peopleRepos.findById(id).orElse(null);
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
	
	public void deletePerson(Integer id)
	{
		peopleRepos.deleteById(id);
	}
}

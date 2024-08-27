package koroler.spring.hibernate.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import koroler.spring.hibernate.models.Person;

@Component
public class PeopleDAO {
	private final SessionFactory sessionFactory;

	@Autowired
	public PeopleDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	// Get full list
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional (readOnly = true)
	public List <Person> getList()
	{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Person").getResultList();
	}
	
	// Add person
	public void addPerson(Person person)
	{
		
	}
	
	public Person getPerson(Integer ID)
	{
		return null;
	}
	
	//Edit info
	public void updatePerson(Integer id, Person newPerson)
	{
		
	}
	
	//Delete person
	public void murderPerson(Integer id)
	{
		
	}
}

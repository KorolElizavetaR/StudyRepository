package koroler.spring.DropdownList.DAOs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import koroler.spring.DropdownList.models.Person;



@Component
public class PeopleDAO {
	final private JdbcTemplate temp;
	final private String SQL_SelectAll = "Select * from person ORDER BY id";
	final private String SQL_Insert = "INSERT INTO person (name, email, address) VALUES(?, ?, ?);";
	final private String SQL_GetPerson = "Select * from person WHERE id = ?";
	final private String SQL_UpdatePerson = "UPDATE person SET name = ?, email = ?, address = ? WHERE id = ?";
	final private String SQL_DeletePerson = "DELETE FROM person WHERE id = ?";
	final private String SQL_FindByEmail = "Select * from person WHERE email = ?";

	@Autowired
	public PeopleDAO(JdbcTemplate temp)
	{
		this.temp = temp;
	}
	
	@SuppressWarnings("deprecation")
	public Person searchByEmail(String email)
	{
		return temp.query(SQL_FindByEmail, new Object[]{email}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}
	
	// Show full list
	public List <Person> getList()
	{
		return temp.query(SQL_SelectAll, new BeanPropertyRowMapper<>(Person.class));
	}
	
	// Add person
	public void addPerson(Person person)
	{
		temp.update(SQL_Insert, person.getName(), person.getEmail(), person.getAddress());
	}
	
	// Return person from list
	@SuppressWarnings("deprecation")
	public Person getPerson(Integer ID)
	{
		return temp.query(SQL_GetPerson, new Object[]{ID}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}
	
	//Edit info
	public void updatePerson(Integer id, Person newPerson)
	{
		temp.update(SQL_UpdatePerson, newPerson.getName(), newPerson.getEmail(), newPerson.getAddress(), id);
	}
	
	//Delete person
	public void murderPerson(Integer id)
	{
		temp.update(SQL_DeletePerson, id);
	}
}

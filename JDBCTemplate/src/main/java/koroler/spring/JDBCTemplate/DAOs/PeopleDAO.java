package koroler.spring.JDBCTemplate.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import koroler.spring.JDBCTemplate.models.Person;

@Component
public class PeopleDAO {
	final private JdbcTemplate temp;
	final private String SQL_SelectAll = "Select * from person ORDER BY id";
	final private String SQL_Insert = "INSERT INTO person VALUES(?, ?, ?);";
	final private String SQL_GetPerson = "Select * from person WHERE id = ?";
	final private String SQL_UpdatePerson = "UPDATE person SET name = ?, email = ? WHERE id = ?";
	final private String SQL_DeletePerson = "DELETE FROM person WHERE id = ?";

	private Integer newtindex;

	@Autowired
	public PeopleDAO(JdbcTemplate temp)
	{
		this.temp = temp;
	}
	
	// Show full list
	public List <Person> getList()
	{
		List <Person> list = temp.query(SQL_SelectAll, new BeanPropertyRowMapper<>(Person.class));
		newtindex = list.size();
		//return temp.query(SQL_SelectAll, new PersonMapper());
		return list;
	}
	
	// Add person
	public void addPerson(Person person)
	{
		temp.update(SQL_Insert, ++newtindex, person.getName(), person.getEmail());
	}
	
	// Return person from list
	@SuppressWarnings("deprecation")
	public Person getPerson(Integer ID)
	{
		//return temp.query(SQL_GetPerson, new Object[]{ID}, new PersonMapper()).stream().findAny().orElse(null);
		return temp.query(SQL_GetPerson, new Object[]{ID}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}
	
	//Edit info
	public void updatePerson(Integer id, Person newPerson)
	{
		temp.update(SQL_UpdatePerson, newPerson.getName(), newPerson.getEmail(), id);
	}
	
	//Delete person
	public void murderPerson(Integer id)
	{
		temp.update(SQL_DeletePerson, id);
	}
}

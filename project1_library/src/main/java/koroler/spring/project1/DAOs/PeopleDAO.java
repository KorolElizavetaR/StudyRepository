package koroler.spring.project1.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import koroler.spring.project1.models.Person;

@Component
public class PeopleDAO {
	private final JdbcTemplate temp;
	private String database_name = null;
	
	@Autowired //check if this one is even needed. If not, use NoArgs
	public PeopleDAO(JdbcTemplate temp, @Value("${database.people}") String database_name) {
		this.temp = temp;
		this.database_name = database_name;
	}
	
	public List <Person> getList()
	{
		return temp.query("SELECT * FROM " + database_name, new BeanPropertyRowMapper<>(Person.class));
	}
	
	@SuppressWarnings("deprecation")
	public Person getPerson(Integer id)
	{
		return temp.query("SELECT * FROM person WHERE person_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}
}

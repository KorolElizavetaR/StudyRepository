package koroler.spring.project1.DAOs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Nullable;
import koroler.spring.project1.models.Book;
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
	public Person getPerson(@Nullable Integer id)
	{
		if (id == null) id = -1;
		return temp.query("SELECT * FROM person WHERE person_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
	}
	
	public void addPerson(Person person)
	{
		temp.update("INSERT INTO " + database_name + "(full_name, birth_year) VALUES (?, ?)", person.getFull_name(), person.getBirth_year_asDate());
	}
	
	public void deletePerson(Integer id)
	{
		temp.update("DELETE FROM " + database_name +" WHERE person_id = ?", id);
	}
	
	public void updatePerson(Person person, Integer id)
	{
		temp.update("UPDATE "+ database_name +" SET full_name = ?, birth_year = ? WHERE person_id = ?", person.getFull_name(), person.getBirth_year_asDate(), id);
	}
			
}

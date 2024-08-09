package koroler.spring.RESTnDAOwoDB.DAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import koroler.spring.RESTnDAOwoDB.models.*;

@Component
public class PersonDAO {
	private List<Person> people;
	
	public PersonDAO() {
		people = new ArrayList<Person>();
		
		people.add(new Person(0, "Anna"));
		people.add(new Person(1, "Ron"));
		people.add(new Person(2, "Sheon"));
		people.add(new Person(3, "Tom"));
	}
	
	public List<Person> getList()
	{
		return people;
	}
	
	public Person getPerson(Integer id)
	{
		try
		{

			return people.get(id);
		}
		catch (Exception ex)
		{
			return null;
		}
	}
}

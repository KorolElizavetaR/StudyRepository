package koroler.spring.RESTnDAOwoDB.DAO;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import koroler.spring.RESTnDAOwoDB.models.*;

@Component
public class PersonDAO {
	private List<Person> people;
	private static Integer counter = 0;
	private Person nullPerson = new Person("unknown_email", "EMPTY", -1);
	
	public PersonDAO() {
		people = new ArrayList<Person>();
		people.add(new Person("anna2001@gmail.com","Anna", counter++));
		people.add(new Person("RonWhite@gmail.com", "Ron",  counter++));
		people.add(new Person("IamAmoron@gmail.com", "Sheon",  counter++));
		people.add(new Person("ThomasFrank@gmail.com", "Tom",  counter++));
	}
	
	public List<Person> getList()
	{
		return people;
	}
	
	public Person getPerson(Integer id)
	{
		return people.stream().filter(person -> person.getID() == id).findAny().orElse(nullPerson);
	}
	
	public void addPerson(Person person)
	{
		person.setID(counter++);
		people.add(person);
	}
	
	public void update(Integer id, Person person)
	{
		Person UpdatePerson = people.get(id);
		if (!(person.getName().isEmpty() || person.getName().isBlank()))
		{
			UpdatePerson.setName(person.getName());
		}
		if (!(person.getEmail().isEmpty() || person.getEmail().isBlank()))
		{
			UpdatePerson.setEmail(person.getEmail());
		}
	}
	
	public void removePerson(int id)
	{
		people.removeIf(p -> p.getID() == id);
	}
}

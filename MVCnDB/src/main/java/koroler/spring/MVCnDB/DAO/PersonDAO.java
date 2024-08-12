package koroler.spring.MVCnDB.DAO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import koroler.spring.MVCnDB.models.Person;

@Component
public class PersonDAO {
	private static Integer counter = 0;
	static String URL = "jdbc:postgresql://localhost:5432/testdb1";
	static String username = "postgres";
	static String password = "Emsobak321";
	static Connection conn;
	
	public PersonDAO() {
		try
		{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(URL, username, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> getList()
	{
		 List<Person>people= new ArrayList<>();
		 Statement statement;
		 try 
		 {	statement = conn.createStatement();
			ResultSet res = statement.executeQuery("select * from person");
			while (res.next())
			{
				Person person = new Person();
				person.setID(res.getInt("id"));
				person.setName(res.getString("name"));
				person.setEmail(res.getString("email"));
				people.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;		
	}

}

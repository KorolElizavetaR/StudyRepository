package koroler.spring.PreparedStatementSQL.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import koroler.spring.PreparedStatementSQL.models.Person;

@Component
public class PeopleDAO {
	final private String SQL_SelectAll = "Select * from person";
	final private String SQL_GetPerson = SQL_SelectAll + " WHERE id = ?";
	final private String SQL_UpdatePerson = "UPDATE person SET name = ?, email = ? WHERE id = ?";
	static Connection conn;
	Integer newtindex;

	public PeopleDAO(@Value ("${spring.datasource.driver-class-name}") String drivers,
					@Value ("${spring.datasource.username}") String username,
					@Value ("${spring.datasource.password}") String password,
					@Value ("${spring.datasource.url}") String URL)
	{
		try
		{
		Class.forName(drivers);
		conn = DriverManager.getConnection(URL, username, password);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public List <Person> getList()
	{
		newtindex = 1;
		List <Person> people = new ArrayList<Person>();
		try {
			Statement statement = conn.createStatement();
			ResultSet res = statement.executeQuery(SQL_SelectAll);
			while (res.next())
			{
				people.add(new Person(res.getInt("id"), res.getString("name"), res.getString("email")));
				newtindex++;
			}
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}
	
	public void addPerson(Person person)
	{
		String SQL_Insert = "INSERT INTO person VALUES(" + newtindex + ", ?, ?);";
		try
		{
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_Insert);
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getEmail());
			preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Person getPerson(Integer ID)
	{
		ResultSet res;
		Person person = null;
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_GetPerson);
			preparedStatement.setInt(1, ID);
			res = preparedStatement.executeQuery();
			res.next();
			person = new Person(res.getInt("id"), res.getString("name"), res.getString("email"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public void updatePerson(Integer id, Person newPerson)
	{
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SQL_UpdatePerson);
			preparedStatement.setString(1, newPerson.getName());
			preparedStatement.setString(2, newPerson.getEmail());
			preparedStatement.setInt(3, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

//package koroler.spring.JDBCTemplate.DAOs;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import koroler.spring.JDBCTemplate.models.Person;
//
//public class PersonMapper implements RowMapper<Person>{
//	@Override
//	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//		return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
//	}
//}

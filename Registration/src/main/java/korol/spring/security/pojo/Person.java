 package korol.spring.security.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "person")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Person {
	@Column (name = "id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "username")
	@NotEmpty
	@Size (min = 4, max = 50)
	private String username;
	
	@Column (name = "password")
	@NotEmpty
	private String password;
	
	@Past 
	@NotNull 
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "y-MM-dd")
	@Column (name = "birth_date")
	private Date birth_date;
	
	public Person (String username, String password, Date birth_date)
	{
		this.birth_date = birth_date;
		this.password = password;
		this.username = username;
	}
}

package koroler.spring.hibernate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table (name = "person")
public class Person {
	@NotNull
	@Column (name = "id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank (message = "Name can't be empty")
	@Size(min=2, max=40)
	@Column (name = "name")
	private String name;
	
	@Email (message = "Input valid email!")
	@Column (name = "email")
	private String email; 
	
	public Person (String name, String email)
	{
		this.name = name;
		this.email = email;
	}
}

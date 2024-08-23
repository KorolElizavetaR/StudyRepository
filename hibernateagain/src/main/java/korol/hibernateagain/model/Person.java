package korol.hibernateagain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "person")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
	@Id
	@Column (name = "person_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int person_id;
	
	@Column (name = "person_name")
	private String person_name;
	
	@Column (name = "age")
	private int age;
	
	public Person(String person_name, int age)
	{
		this.person_name = person_name;
		this.age = age;
	}
}

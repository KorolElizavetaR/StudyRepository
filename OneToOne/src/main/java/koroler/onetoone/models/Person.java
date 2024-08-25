package koroler.onetoone.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "person")
@NoArgsConstructor
@ToString
public class Person {
	@Id
	@Column (name = "person_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer person_id;
	
	@Column (name = "full_name")
	@Getter
	@Setter
	private String full_name;
	
	@OneToOne(mappedBy = "person_id",  cascade = CascadeType.PERSIST)
	@Getter	
	private Passport passport;
	
	public Person(String full_name)
	{
		this.full_name = full_name;
	}
	
	public void setPassport(Passport passport)
	{
		this.passport = passport;
		passport.setPerson_id(this);
	}
	
}

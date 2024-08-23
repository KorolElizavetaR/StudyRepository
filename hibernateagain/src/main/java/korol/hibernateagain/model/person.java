package korol.hibernateagain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@Getter
@Setter
@ToString
public class person {
	@Id
	@Column (name = "person_id")
	private int person_id;
	
	@Column (name = "person_name")
	private String person_name;
	
	@Column (name = "age")
	private int age;
}

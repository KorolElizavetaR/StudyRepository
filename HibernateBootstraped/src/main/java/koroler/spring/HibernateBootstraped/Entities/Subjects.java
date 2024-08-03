package koroler.spring.HibernateBootstraped.Entities;

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

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {
	@Id
	@Column(name = "subject_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int subject_id;
	
	@Column (name = "subject_name")
	String subject_name;
	
	@Override
	public String toString() {
		return "subject_id = " + subject_id + "; subject_name = " + subject_name;
	}
}

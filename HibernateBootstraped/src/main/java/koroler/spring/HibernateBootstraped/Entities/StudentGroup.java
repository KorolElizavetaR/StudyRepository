package koroler.spring.HibernateBootstraped.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "student_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {
	@Id
	@Column(name = "group_no")
	private String group_no;
	@Column(name = "faculty")
	private String faculty;
	
	@Override
	public String toString() {
		return "group_no = " + group_no + "; faculty = " + faculty;
	}
}

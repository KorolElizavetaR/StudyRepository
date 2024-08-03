package koroler.spring.HibernateBootstraped.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "exams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exams {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "student_res_id")
	int student_res_id;
	
	@ManyToOne
	@JoinColumn (name = "subject_id")
	Subjects subjects;

	@ManyToOne
	@JoinColumn (name = "rec_book_id")
	Students student;
	
	@Column (name = "score")
	int score;
	
	@Override
	public String toString() {
		return "student_res_id = " + student_res_id + "; " + subjects + "; " + student +  "; score = " + score;
	}
}

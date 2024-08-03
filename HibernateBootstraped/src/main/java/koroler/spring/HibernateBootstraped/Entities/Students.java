package koroler.spring.HibernateBootstraped.Entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "students")
public class Students {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "rec_book_id")
	Integer rec_book_id;
	
	@Column(name = "last_name")
	String last_name;
	
	@Column(name = "birth_date")
	Calendar birth_date;
	
	@Column(name = "enroll_date")
	Calendar enroll_date;
	
	@ManyToOne
	@JoinColumn(name = "group_no")
	StudentGroup student_group;
	
	public String toString() {
		return "rec_book_id = " + rec_book_id + "; last_name = " + last_name + "; birth_date = " + 
				(new SimpleDateFormat("dd MMM yyyy")).format(birth_date.getTime()) +  "; enroll_date = " + enroll_date.get(Calendar.YEAR) + ";" + student_group; }
}

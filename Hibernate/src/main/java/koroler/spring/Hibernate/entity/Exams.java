package koroler.spring.Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "exams")
public class Exams {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "student_res_id")
	Integer student_res_id;
	
//	@Column (name = "subject_id")
//	int subject_id;
	@ManyToOne
	@JoinColumn (name = "subject_id")
	Subjects subjects;
	
//	@Column (name = "rec_book_id")
//	int rec_book_id;
	@ManyToOne
	@JoinColumn (name = "rec_book_id")
	Students student;
	
	@Column (name = "score")
	int score;
	
	public Exams() {}
	public Exams(Students student, Subjects subjects, int score) {
		//setRec_book_id(rec_book_id);
		setStudent(student);
		setScore(score);
		setSubjects(subjects);
		//setSubject_id(subject_id);
	}
	
	@Override
	public String toString() {
		return "student_res_id = " + student_res_id + "; " + subjects + "; " + student +  "; score = " + score;
	}
	
//	public void setRec_book_id(int rec_book_id) {
//		this.rec_book_id = rec_book_id;
//	}
	
	public void setStudent(Students student) {
		this.student = student;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
//	public void setSubject_id(int subject_id) {
//		this.subject_id = subject_id;
//	}
	
	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}
	
	public Subjects getSubjects() {
		return subjects;
	}
	
	public void setStudent_res_id(int student_res_id) {
		this.student_res_id = student_res_id;
	}
	
//	public int getRec_book_id() {
//		return rec_book_id;
//	}
	
	public Students getStudent() {
		return student;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getStudent_res_id() {
		return student_res_id;
	}
	
//	public int getSubject_id() {
//		return subject_id;
//	}
}

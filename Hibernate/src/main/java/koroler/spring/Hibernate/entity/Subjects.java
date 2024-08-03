package koroler.spring.Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
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
	
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	public int getSubject_id() {
		return subject_id;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	
	public Subjects() {	}
	
	public Subjects(String subject_name) {
		this.subject_name = subject_name;
	}
}

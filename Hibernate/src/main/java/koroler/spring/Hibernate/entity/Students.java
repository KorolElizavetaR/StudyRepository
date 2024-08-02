package koroler.spring.Hibernate.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "students")
public class Students {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "rec_book_id")
	int rec_book_id;
	
	@Column(name = "last_name")
	String last_name;
	
	@Column(name = "birth_date")
	Calendar birth_date;
	
	@Column(name = "enroll_date")
	Calendar enroll_date;
	
	@Column(name = "group_no")
	String group_no;
	
	public Students() {	}
	public Students(String last_name, String group_no, Calendar birth_date, Calendar enroll_date) {
		setLast_name(last_name);
		setGroup_no(group_no);
		setBirth_date(birth_date);
		setEnroll_date(enroll_date);
	}
	
	@Override
	public String toString() {
		return "rec_book_id = " + rec_book_id + "; last_name = " + last_name + "; birth_date = " + 
				(new SimpleDateFormat("dd MMM yyyy")).format(birth_date.getTime()) +
	 "; enroll_date = " + enroll_date.get(Calendar.YEAR) + "; group_no = " 
	+ group_no;
	}
	
	public void setBirth_date(Calendar birth_date) {
		this.birth_date = birth_date;
	}
	
	public void setEnroll_date(Calendar enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public void setRec_book_id(int rec_book_id) {
		this.rec_book_id = rec_book_id;
	}
	
	public Calendar getBirth_date() {
		return birth_date;
	}
	
	public Calendar getEnroll_date() {
		return enroll_date;
	}
	
	public String getGroup_no() {
		return group_no;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public int getRec_book_id() {
		return rec_book_id;
	}
}

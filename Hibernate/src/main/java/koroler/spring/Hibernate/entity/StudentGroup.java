package koroler.spring.Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.persistence.Entity;

@Entity
@Table(name = "student_group")
public class StudentGroup {
	@Id
	@Column(name = "group_no")
	private String group_no;
	@Column(name = "faculty")
	private String faculty;
	
	public StudentGroup() {	}
	public StudentGroup(String group_no, String faculty)
	{
		setFaculty(faculty);
		setGroup_no(group_no);
	}
	
	@Override
	public String toString() {
		return "group_no = " + group_no + "; faculty = " + faculty;
	}
	
	public String getFaculty() {
		return faculty;
	}
	
	public String getGroup_no() {
		return group_no;
	}
	
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}
}

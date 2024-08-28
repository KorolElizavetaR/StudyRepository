package koroler.spring.SpringMVCApp.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table (name = "person")
public class Person {
	@NotNull
	@Column (name = "personid")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank (message = "Name can't be empty")
	@Column (name = "full_name")
	private String name;
	
	@Column (name = "birth_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "y-MM-dd")
	private Date birth_date;
	
	@ToString.Exclude
	@OneToMany (mappedBy = "customer")
	private List<Product>products;
	
	public Person (String name, Integer age)
	{
		this.name = name;
	}
}

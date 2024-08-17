package koroler.spring.JDBCTemplate.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	@NotNull
	private int id;
	@NotNull
	@Size(min=2, max=40)
	private String name;
	@Email
	@Size(min=9, max=70)
	private String email; 
}

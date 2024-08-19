package koroler.spring.DropdownList.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern (regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Address is not valid. Accepted format: Country, City, postal code (6 digits)")
	private String address;
}

package koroler.spring.project1.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
	@Getter
	@Setter
	@NotNull
	Integer person_id;
	@Setter
	@Getter
	@NotNull
	@Pattern (regexp = "[A-Z]\\w+, [A-Z]\\w+, [A-Z]\\w+", message = "Некорректный ввод ФИО")
	String full_name;
	@Past
	@NotNull
	@Setter
	// написать проверку не раньше 1920.01.01 в util
	Date birth_year;
	
	public String getBirth_year()
	{
		return (new SimpleDateFormat("dd MMM yyyy")).format(birth_year.getTime());
	}
}

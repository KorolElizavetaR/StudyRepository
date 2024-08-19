package koroler.spring.project1.models;

import java.sql.Date;

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
@Setter
@Getter
@ToString
public class Person {
	@NotNull
	Integer person_id;
	@NotNull
	@Pattern (regexp = "[A-Z]\\w+, [A-Z]\\w+, [A-Z]\\w+", message = "Некорректный ввод ФИО")
	String full_name;
	@Past
	@NotNull
	// написать проверку не раньше 1920.01.01 в util
	Date birth_year;
}

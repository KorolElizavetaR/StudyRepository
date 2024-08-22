package koroler.spring.project1.models;

import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotEmpty;
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
	Integer person_id;
	// @Pattern (regexp = "[А-Я]\\w+ [А-Я]\\w+ [А-Я]\\w+", message = "Некорректный ввод ФИО")
	// В конце работы над проектом глянуть на regexp
	@Setter
	@Getter
	@NotEmpty (message = "Name can't be empty")
	//(message = "Имя не может быть пустым")
	String full_name;
	@Past (message = "You can't be born tomorrow or any other future time")
	//(message = "Дата рождения не может быть пустой")
	@NotNull (message = "Birth date can't be empty")
	java.util.Date birth_year; // написать проверку не раньше 1920.01.01 в util
	
	public String getBirth_year()
	{
		if (birth_year == null)
			return null;
		return (new SimpleDateFormat("y.MM.dd")).format(birth_year.getTime());
	}
	
	public Date getBirth_year_asDate()
	{
		return birth_year;
	}
	
//	public void setBirth_year(Date date) 
//	{
//		this.birth_year = date;
//	}
	public void setBirth_year(String date)
	{
		Date datee = java.sql.Date.valueOf(date);
		this.birth_year = datee;
		//Date.valueOf(date);
	}
}

package koroler.spring.project1.models;

import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.validation.constraints.NotBlank;
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
	@Pattern (regexp = "[А-ЯЁ][-А-яЁё]+ [А-ЯЁ][-А-яЁё]+ [А-ЯЁ][-А-яЁё]+", message = "Некорректный ввод ФИО")
	@Setter
	@Getter
	@NotEmpty (message = "Имя не может быть пустым")
	//(message = "Имя не может быть пустым")
	String full_name;
	@Past (message = "Время не может быть в будущем")
	//(message = "Дата рождения не может быть пустой")
	@NotNull (message = "Дата рождения не может быть пустой")
	java.util.Date birth_year;
	
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

package korol.spring.restapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table (name = "person")
@Entity
public class Person {
	@Column (name = "person_id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Pattern (regexp = "[А-ЯЁ][-А-яЁё]+", message = "Некорректный ввод фамилии")
	@NotEmpty (message = "Имя не может быть пустым")
	@Column (name = "person_name")
	private String full_name;
	
	@Column (name = "age")
	@Min (value = 0, message = "Нельзя быть младше 0 лет")
	@Max (value = 150, message = "А у вас точно есть бибки в чемодане?")
	private Integer age;

	public Person(String full_name, Integer age) {
		this.full_name = full_name;
		this.age = age;
	}
}

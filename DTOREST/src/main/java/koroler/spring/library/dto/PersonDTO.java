package koroler.spring.library.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import korol.spring.restapi.models.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class PersonDTO {	
	@Getter
	@Setter
	@Pattern (regexp = "[А-ЯЁ][-А-яЁё]+", message = "Некорректный ввод фамилии")
	@NotEmpty (message = "Имя не может быть пустым")
	private String full_name;
	
	@Getter
	@Setter
	@Min (value = 0, message = "Нельзя быть младше 0 лет")
	@Max (value = 150, message = "А у вас точно есть бибки в чемодане?")
	private Integer age;
	
}

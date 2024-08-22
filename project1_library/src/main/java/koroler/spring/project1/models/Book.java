package koroler.spring.project1.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
	@Getter
	@Setter
	private Integer book_id;
	@Setter
	private Integer book_owner;
	@NotBlank (message = "Название книги не может быть пустым")
	@Getter
	@Setter
	private String book_name;
	@NotBlank (message = "Автор книги не может быть пустым")
	@Getter
	@Setter
	private String book_author;
	
	public Integer getBook_owner() {
		if (book_owner == null) return -1;
		return book_owner;
	}
}

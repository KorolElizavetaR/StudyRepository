package koroler.spring.project1.models;

import jakarta.validation.constraints.NotNull;
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
public class Book {
	@NotNull
	private Integer book_id;
	private Integer book_owner;
	@NotNull
	private String book_name;
	@NotNull
	private String book_author;
}

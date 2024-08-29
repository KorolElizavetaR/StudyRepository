package koroler.spring.library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "book")
public class Book {
	@Id
	@Column (name = "book_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank (message = "Название книги не может быть пустым")
	@Column (name = "book_name")
	private String book_name;
	
	@Column (name = "book_author")
	@NotBlank (message = "Автор книги не может быть пустым")
	private String book_author;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn (name = "book_owner", referencedColumnName = "person_id")
	private Person owner;
	
	public Book(String book_name, String book_author)
	{
		setBook_author(book_author);
		setBook_name(book_name);
	}
}

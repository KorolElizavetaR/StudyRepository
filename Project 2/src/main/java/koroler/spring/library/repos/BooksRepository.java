package koroler.spring.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import koroler.spring.library.models.Book;
import koroler.spring.library.models.Person;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer>{
//	@Query (value = "Select * from book where book_owner = ?")
//	Person getBookByPersonId(Integer id);	
}

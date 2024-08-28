package koroler.spring.SpringMVCApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import koroler.spring.SpringMVCApp.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{
	List<Person> findByName(String name);
	List<Person> findByNameStartingWith(String startingWith);
}

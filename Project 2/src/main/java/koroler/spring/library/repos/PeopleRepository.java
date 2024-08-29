package koroler.spring.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import koroler.spring.library.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{}

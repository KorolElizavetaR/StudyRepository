package korol.spring.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import korol.spring.restapi.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{
    
}

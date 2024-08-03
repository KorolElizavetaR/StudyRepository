package koroler.spring.HibernateBootstraped.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import koroler.spring.HibernateBootstraped.Entities.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}

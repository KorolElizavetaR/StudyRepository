package koroler.spring.SpringMVCApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import koroler.spring.SpringMVCApp.models.Person;
import koroler.spring.SpringMVCApp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List <Product> findByCustomer(Person customer);
}

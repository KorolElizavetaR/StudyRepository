package koroler.spring.SpringMVCApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import koroler.spring.SpringMVCApp.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import koroler.spring.SpringMVCApp.models.Person;
import koroler.spring.SpringMVCApp.models.Product;

@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class ProductsService {
	@Autowired
	private final ProductRepository productRepos;
	
	public List <Product> findByOwner(Person person)
	{
		return productRepos.findByCustomer(person);
	}
	
	public List <Product> getList()
	{
		return productRepos.findAll();
	}
}

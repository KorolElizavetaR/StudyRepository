package koroler.onetomany.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "product")
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Product {
	@Id
	@Column (name = "product_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	@Column (name = "product_name")
	private String product_name;
	
	@ManyToOne
	@JoinColumn(name = "customer", referencedColumnName = "personid")
	private Person customer;
	
	public Product(String product_name)
	{
		this.product_name = product_name;
	}
	
	public Product(String product_name, Person customer)
	{
		this(product_name);
		this.customer = customer;
	}
}

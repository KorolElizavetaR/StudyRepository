package koroler.spring.SpringMVCApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "product")
@ToString
@NoArgsConstructor
@Setter
@Getter
public class Product {
	@Id
	@Column (name = "product_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	@NotEmpty (message = "Item cannot be empty")
	@Column(name = "product_name")
	private String product_name;
	
	@ManyToOne
	@JoinColumn (name = "customer", referencedColumnName = "personid") // might be personid
	@ToString.Exclude
	private Person customer;
	
	public Product(String product_name)
	{
		setProduct_name(product_name);
	}
}

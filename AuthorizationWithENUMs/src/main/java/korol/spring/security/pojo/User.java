package korol.spring.security.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "user")
public class User {

	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	Integer user_id;
	
	@Column (name = "username")
	@NotNull
	String username;
	
	String password;
	
	@Column
	UserRoles role;
}

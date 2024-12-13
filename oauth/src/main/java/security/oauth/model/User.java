package security.oauth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
	@Id
	private String id;
	@Column(name = "given_name")
	private String givenName;
	@Column(name = "family_name")
	private String familyName;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "picture")
	private String picture;
}

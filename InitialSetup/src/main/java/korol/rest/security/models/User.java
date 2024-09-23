package korol.rest.security.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Integer id;
	private String username;
	@JsonIgnore
	private String password;
	private String role;
}

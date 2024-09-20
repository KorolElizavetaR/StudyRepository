package korol.rest.security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
//@Builder
@AllArgsConstructor
public class LoginRequest {
	private String username;
	private String password;
}

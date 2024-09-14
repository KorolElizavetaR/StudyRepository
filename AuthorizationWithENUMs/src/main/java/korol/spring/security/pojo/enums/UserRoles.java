package korol.spring.security.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRoles {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	final String role;
}

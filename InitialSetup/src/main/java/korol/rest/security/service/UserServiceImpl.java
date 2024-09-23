package korol.rest.security.service;

import java.util.Optional;

import korol.rest.security.models.User;

public class UserServiceImpl implements UserService{
	private final String USER = "admin";

	@Override
	public Optional<User> findByUsername(String username) {
		if (!USER.equalsIgnoreCase(username)) return Optional.empty();
		
		// Normally you would return new person from here
		var user = new User();
		user.setId(1);
		user.setUsername(username);
		user.setPassword("$2a$12$eO.bhm4lBxTH9I68AWLNxeXgmhZh7VPMTBXfNo06fzI/LYBDkjuri"); //test
		user.setRole("ROLE_ADMIN");
		return Optional.of(user);
	}

}

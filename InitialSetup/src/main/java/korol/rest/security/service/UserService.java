package korol.rest.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import korol.rest.security.models.User;

@Service
public interface UserService {
	public Optional<User> findByUsername(String username);
}

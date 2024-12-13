package security.oauth.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import security.oauth.exception.NoAuthTokenFound;
import security.oauth.model.User;
import security.oauth.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User addUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
			OAuth2User oAuth2User = oauthToken.getPrincipal();
			if (oAuth2User != null) {
				Map<String, Object> attributes = oAuth2User.getAttributes();
				Optional<User> optionalUser = userRepository.findById((String) attributes.get("sub"));
				if (optionalUser.isEmpty()) {
					User user = new User().setId((String) attributes.get("sub"))
							.setGivenName((String) attributes.get("given_name"))
							.setFamilyName((String) attributes.get("family_name"))
							.setEmail((String) attributes.get("email"))
							.setPicture((String) attributes.get("picture"))
							.setName((String) attributes.get("name"));
					userRepository.save(user);
					return user;
				}
			}
		}
		throw new NoAuthTokenFound();
	}
}

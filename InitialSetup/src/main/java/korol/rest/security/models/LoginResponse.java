package korol.rest.security.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@Builder
@RequiredArgsConstructor
public class LoginResponse {
	private final String accessToken;
}

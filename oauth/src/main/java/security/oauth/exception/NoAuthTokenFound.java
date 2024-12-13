package security.oauth.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoAuthTokenFound extends NoSuchElementException{
	public NoAuthTokenFound() {
		super("No OAuth2AuthenticationToken found");
	}
}

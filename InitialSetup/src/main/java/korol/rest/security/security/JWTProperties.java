package korol.rest.security.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
//@ConfigurationProperties("security.jwt")
public class JWTProperties {
	@Value ("${security.jwt.secret-key}")
	private String secretKey;
}

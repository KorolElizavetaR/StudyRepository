package korol.spring.restapi.util;

public class InvalidPersonException extends RuntimeException{
	public InvalidPersonException(String msg)
	{
		super(msg);
	}
}

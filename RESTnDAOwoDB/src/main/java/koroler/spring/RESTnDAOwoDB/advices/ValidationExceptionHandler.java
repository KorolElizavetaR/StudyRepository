//package koroler.spring.RESTnDAOwoDB.advices;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ValidationExceptionHandler {
//	@ExceptionHandler (MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex)
//	{
//		Map<String, String> errorMap = new HashMap<>();
//		ex.getBindingResult().getFieldErrors().forEach((error)->{errorMap.put(error.getField(), error.getDefaultMessage());});
//		return null;
//	}
//}

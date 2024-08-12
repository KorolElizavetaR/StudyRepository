package koroler.spring.RESTnDAOwoDB.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Person {
@Email
private String email;
@NotEmpty(message = "Name is mandatory")
@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
private String name;

private Integer ID;
}

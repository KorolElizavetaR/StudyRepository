package koroler.junit;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Employee {
	private String full_name;
	private Integer salary;
	private String phoneNumber;
	private final Integer MINIMUM_SALARY = 100;
	private final Integer MAXIMUM_SALARY = 5000;
	
	private static <T> void validate(T arg) {
		if (arg == null)
			throw new RuntimeException("Cannot be null");
	}
	
	  public void validatePhoneNumber(String phoneNumber) {
	        if (phoneNumber.length() != 7) {
	            throw new RuntimeException("Phone Number Should be 10 Digits Long");
	        }
	        if (!phoneNumber.matches("\\d+")) {
	            throw new RuntimeException("Phone Number Contain only digits");
	        }
	    }
	  
	  public void validateSalary(Integer salary)
	  {
		  if (salary > MAXIMUM_SALARY || salary < MINIMUM_SALARY)
			  throw new RuntimeException("Salary cannot be >" + MAXIMUM_SALARY + " or " + MINIMUM_SALARY);
	  }

	public Employee(String full_name, Integer salary, String phoneNumber) {
//		try
//		{
//			validate(full_name);
//			validate(salary);
//			validate(phoneNumber);
//			validatePhoneNumber(phoneNumber);
//		}
//		catch (RuntimeException ex)
//		{
//			ex.printStackTrace();
//			throw ex;
//		}
		this.full_name = full_name;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}
}

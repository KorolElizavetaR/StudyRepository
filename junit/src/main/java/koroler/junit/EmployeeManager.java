package koroler.junit;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	 List<Employee> employeeList = new ArrayList<Employee>();
	 
	 public void addEmployee(String name, Integer salary, String phoneNumber)
	 {
		 employeeList.add(new Employee(name, salary, phoneNumber));
	 }
	 
	 public Employee getEmployee(int id)
	 {
		 return employeeList.get(id);
	 }
}

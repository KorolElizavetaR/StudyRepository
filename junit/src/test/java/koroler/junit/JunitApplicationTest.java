package koroler.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.xmlunit.assertj.XmlAssert; 

import net.javacrumbs.jsonunit.assertj.JsonAssertions;

class JunitApplicationTest {
	static Employee emp1;
	
	// @BeforeEach : NOT a test - initialise before each test
	@BeforeAll //!! method and used inside it fields should be static.
	static void initialiseEmployee()
	{
		emp1 = new Employee("Zaur", 450, "3425198");
	}
	
	// @AfterEach : NOT a test - destroy after each test
	@AfterAll //!! method and used inside it fields should be static.
	static void killEmplyee()
	{
		emp1 = null;
	}
	
	@Test
	void BlankTest() {
		Assertions.assertThat(emp1.getFull_name()).as("FullName can't be blank").isNotBlank();
		Assertions.assertThat(emp1.getSalary()).as("Salary can't be blank").isNotNull();
		Assertions.assertThat(emp1.getPhoneNumber()).as("PhoneNumber can't be blank").isNotBlank();
	}
	
	@Test
	@DisplayName ("i ate a dog")
	void NumberTest()
	{
		Assertions.assertThat(emp1.getPhoneNumber()).containsOnlyDigits();
	}
	
	@Test
	void JSONtest()
	{
		JsonAssertions.assertThatJson(emp1).isEqualTo("{\"full_name\":\"Zaur\",\"salary\":450,\"phoneNumber\":\"3425198\",\"maximum_SALARY\":5000,\"minimum_SALARY\":100}");
	}
	
	@Test
	void XMLTest()
	{
		XmlAssert.assertThat( "<a><b attr=\"abc\"></b></a>").nodesByXPath("//a/b/@attr").exist();
	}
	
	@ParameterizedTest //run a test for each element of array
	//@ValueSource (ints = {4, 5, 24, 2, 6})
	@CsvFileSource (resources = "/friends.csv", numLinesToSkip = 1)
	void ParameterizedTest_ChechIfMajor(String name, Integer nums)
	{
		Assertions.assertThat(nums).isGreaterThan(17);
	}
	

	@Test
	@Disabled
	void MathematicTest()
	{
		 Throwable exception = assertThrows(ArithmeticException.class, () -> Mathematics.divide(2., 0.));
		 Mathematics.divide(2., 0.);
	}

}

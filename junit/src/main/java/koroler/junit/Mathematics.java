package koroler.junit;

public class Mathematics {
	
	public static Double divide(Double a, Double b)
	{
		if (b == 0) throw new ArithmeticException("Can't divide by zero");
		return a/b;
	}

}

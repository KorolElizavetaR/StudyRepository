package koroler.smvc.FromMtoV;

public class Calculation {
	public static String calculateValues(Double a, Double b, Integer status)
	{
		switch (status)
		{
		case 0:
			return String.valueOf(a+b);
		case 1:
			return String.valueOf(a-b);
		case 2:
			return String.valueOf(a/b);
		case 3:
			return String.valueOf(a*b);
		}
		return "Invalid status.";
	}
}

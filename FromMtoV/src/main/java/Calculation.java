public enum Calculation {
add(0), substract(1), multiply(2), divide(3);
	private int status;
	Calculation(int status)
	{
		this.status = status;
	}
	int getStatus()
	{
		return status;
	}
}

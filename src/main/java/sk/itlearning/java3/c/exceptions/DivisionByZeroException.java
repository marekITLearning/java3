package sk.itlearning.java3.c.exceptions;

public class DivisionByZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getLocalizedMessage() {
		return "Division by zero exception. Divisor in math operations cannot be 0.";
	}

}

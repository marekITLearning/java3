package sk.itlearning.java3.java3a.c.exceptions;

public class DivisionByZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Delenie nulou.";
	}

}

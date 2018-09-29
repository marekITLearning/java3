package sk.itlearning.java3.c.exceptions;

public class DivisionByZeroException extends Exception {

	@Override
	public String getMessage() {
		return "Delenie nulou.";
	}
	
}

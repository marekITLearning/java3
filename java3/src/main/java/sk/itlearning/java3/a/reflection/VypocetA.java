package sk.itlearning.java3.a.reflection;

public class VypocetA implements Vypocet {

	private int result;
	
	@Override
	public int vypocitaj() {
		return result;
	}
	
	public VypocetA (int value) {
		result = value;
	}
	
}

package sk.itlearning.java3.b.memory;

public class StringBuffer {

	public static void main(String[] args) {
		
		// fullname lebo conflict s nazvom triedy
		java.lang.StringBuffer kniha1 = new java.lang.StringBuffer();
		
		//radsej StringBuffer, lebo je Thread safe
		
		// StringBuilder kniha2 = new StringBuilder();
		
		for (int i = 0; i < 100_000; i++) {
			kniha1.append(String.valueOf(i));
		}
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
	}

}

package sk.itlearning.java3.b.memory;

public class StringPool {

	public static void main(String[] args) {
	
		String knihaString2 = "";
		
		for (int i = 0; i < 300_000; i++) {
			knihaString2 += String.valueOf(i);
		}
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		System.out.println(knihaString2.length());
		
	}

}

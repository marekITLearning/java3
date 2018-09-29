package sk.itlearning.java3.b.memory;

public class StringBuffer {

	public static void main(String[] args) {
		
		String knihaString = "";
		
		String item = "a";
		for (int i = 0; i < 1_000_000; i++) {
			item += "a";
			knihaString = item;
		}
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
	}

}

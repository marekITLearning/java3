package sk.itlearning.java3.b.memory;

public class StringPool {

	public static void main(String[] args) {
		
		
		// pomale
		String knihaString1 = "";
				
		String item = "a";
		for (int i = 0; i < 100_000; i++) {
			knihaString1 += item;
			}

		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		
		//este pomalsie	
		String knihaString2 = "";
		
		
		for (int i = 0; i < 100_000; i++) {
			knihaString2 += String.valueOf(i);
			
		}
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
	}

}

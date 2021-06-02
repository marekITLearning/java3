package sk.itlearning.java3.java3a.b.memory;

public class FillMemory {

	public static void main(String[] args) {
	
		String[] array = new String[1_000];
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
		
	}
	
}

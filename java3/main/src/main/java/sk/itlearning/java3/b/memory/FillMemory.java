package sk.itlearning.java3.b.memory;

public class FillMemory {

	public static void main(String[] args) {
	
		StringBuilder[] sbArray = new StringBuilder[400000000];
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		System.out.println();
		
		sbArray = null;
		
	}
}

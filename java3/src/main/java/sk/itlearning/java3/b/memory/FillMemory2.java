package sk.itlearning.java3.b.memory;

public class FillMemory2 {

	public static void main(String[] args) {
	
		String[] array = new String[250_000_000];
		
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
		
		System.out.println(array);
		
		for (int i = 0; i < array.length; i++) {
			//array[i] = new String("0123456789abcdef");
			array[i] = "0123456789abcdef";
		}
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);

	}
	
}

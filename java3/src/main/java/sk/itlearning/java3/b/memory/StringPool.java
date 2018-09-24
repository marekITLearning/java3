package sk.itlearning.java3.b.memory;

public class StringPool {

	public static void main(String[] args) {

//		String[] kniha = new String[200_000_000];
		String kniha = "";
		StringBuilder sbKniha = new StringBuilder();
		for (int i = 1; i < 1000000; i++) {
			kniha += String.valueOf(i);
//			sbKniha.append(String.valueOf(i));
		}

		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

	}

}

package sk.itlearning.java3.b.memory;

public class StringPool {

	public static void main(String[] args) {

		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
		
		String[] kniha = new String[200_000_000];
		String knihaS = "a";
//		StringBuilder sbKniha = new StringBuilder();
		StringBuffer sbKnihaBuff = new StringBuffer();
		kniha[0] = "a";
		for (int i = 1; i < 1_000_000; i++) {
//			knihaS += i;
//			kniha[i] = kniha[i-1] + "a";
			sbKnihaBuff.append(String.valueOf(i));
		}

		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

	}

}

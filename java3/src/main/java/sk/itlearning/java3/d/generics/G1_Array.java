package sk.itlearning.java3.d.generics;

public class G1_Array {

	public static void main(String[] args) {

		// Polia maju definovany typ a nemozno do nich vlozit iny typ
		Integer[] iArray = new Integer[]{
				Integer.valueOf(10),
				Integer.valueOf(20),
		};

		for (Integer i : iArray) {
			System.out.println(i);
		}

	}

}


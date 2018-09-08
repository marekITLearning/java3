package sk.itlearning.java3.d.generics;

import sk.itlearning.java3.m.zakaznik.Firma;
import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G1_Array {

	public static void main(String[] args) {

		Integer[] iArray = new Integer[]{
				Integer.valueOf(10),
				Integer.valueOf(20),
		};

		for (Integer i : iArray) {
			System.out.println(i);
		}

		Zakaznik[] zArray = new Zakaznik[]{
				new Obcan("770727/1234", "Freddy"),
				new Firma("12345678", "Essset")
		};

		for (Zakaznik z : zArray) {
			System.out.println(z.getId());
		}

	}

}


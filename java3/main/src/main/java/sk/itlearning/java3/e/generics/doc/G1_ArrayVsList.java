package sk.itlearning.java3.e.generics.doc;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java3.m.zakaznik.Firma;
import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G1_ArrayVsList {

	public static void main(String[] args) {

		// Polia maju definovany typ a nemozno do nich vlozit iny typ
		Integer[] iArray = new Integer[]{
				new Integer(10),
				new Integer(20),
		};

		for (Integer i : iArray) {
			System.out.println(i);
		}
		System.out.println(); // odriadkovanie v konzole


		// Polia funguju polymorfne - mozno do nich vkladat lubovolne podtriedy
		Zakaznik[] zArray = new Zakaznik[]{
				new Obcan("770727/1234", "Freddy"),
				new Firma("12345678", "Essset")
		};

		for (Zakaznik z : zArray) {
			System.out.println(z.getId());
		}
		System.out.println(); // odriadkovanie v konzole


		// List interface vo verzii Java 1.4 nemal obmedzeny typ,
		// dali sa do neho vkladat hocijake objekty
		List oList = new ArrayList();
		oList.add(new Boolean(true));
		oList.add(new Integer(100));
		oList.add("text");

		for (Object i : oList) {
			System.out.println(i);
			if (i instanceof Zakaznik) {
				((Zakaznik)i).getId();
			}
		}
		System.out.println(); // odriadkovanie v konzole


		// Vo verzii Java 5 prislo riesenie na obmedzenie typov, ktore
		// je mozne vkladat do kolekcii - List, Set, Queue, Map
		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("770727/1234", "Johhny"));
		zList.add(new Firma("23456789", "Ooogle"));

		// toto teraz nebude fungovat, list je typovo chraneny, obmedzeny na Zakaznik
		// zList.add("string value");

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}


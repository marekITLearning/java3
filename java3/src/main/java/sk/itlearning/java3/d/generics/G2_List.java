package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java1.h.zakaznik.Firma;
import sk.itlearning.java1.h.zakaznik.Obcan;
import sk.itlearning.java1.h.zakaznik.Zakaznik;

public class G2_List {

	public static void main(String[] args) {

		// List interface vo verzii Java 1.4 nemal obmedzeny typ,
		// dali sa do neho vkladat hocijake objekty
		List oList = new ArrayList();
		oList.add(0.0);
		oList.add(10);
		oList.add("text");
		oList.add(new Firma("ico", "nazov"));

		for (Object i : oList) {
			if (i instanceof String) {
				System.out.println( ((String)i).toUpperCase() );
			}
		}

		// Vo verzii Java 5 prislo riesenie na obmedzenie typu prvkov, 
		// ktore je mozne vkladat do dynamickeho zoznamu 
		List<Zakaznik> zList = new ArrayList<>();
		zList.add(new Obcan("770727/1234", "Johhny"));
		zList.add(new Firma("23456789", "Ooogle"));

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}


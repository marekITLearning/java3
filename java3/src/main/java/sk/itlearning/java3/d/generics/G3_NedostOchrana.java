package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java1.h.zakaznik.Firma;
import sk.itlearning.java1.h.zakaznik.Obcan;
import sk.itlearning.java1.h.zakaznik.Zakaznik;

public class G3_NedostOchrana {

	public static void main(String[] args) {

		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("770727/1234", "Johhny"));
		zList.add(new Firma("23456789", "Ooogle"));

		// Genericitou zabezpecena typova ochrana ale nie je 100%-na,
		// cez nezabezpecenu triedu nam lahko moze do zabezpeceneho
		// pola vklznut nespravny typ

		G0_Adder a = new G0_Adder();
		a.add(zList);

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}
		
	}

}

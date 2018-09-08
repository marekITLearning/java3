package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G3_Casting {

	public static void main(String[] args) {

		List oList = new ArrayList();
		oList.add("text");

		String s = (String) oList.get(0);


		// Teraz budeme vkladat primitivny int
		List iList = new ArrayList();
		iList.add(new Integer(100));

		int i1 = (int) iList.get(0);
		int i2 = (int) iList.get(0);


		// Do typovo chraneho zoznamu nemozme vkladat nic ine ako typ Zakaznik
		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("770727/1234", "Johhny"));

		// pri vyber hodnoty preto nemusime pouzit explicitny cast
		Zakaznik z = zList.get(0);

	}

}
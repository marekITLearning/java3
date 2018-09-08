package sk.itlearning.java3.e.generics.doc;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G3_Casting {

	public static void main(String[] args) {

		// Urcime si, ze do nezabezpeceneho zoznamu budeme vkladat iba stringy
		List oList = new ArrayList();
		oList.add("text");

		// pri vybere hodnoty zo zonamu ale musime pouzit explicitne pretypovanie
		String s = (String) oList.get(0);


		// Teraz budeme vkladat primitivny int
		List iList = new ArrayList();
		iList.add(100);

		// Stale potrebujeme explicitny cast. Preco?
		// Pretoze nezabezpeceny list akceptuje ako hodnotu iba objekty,
		// nie primitivne typy. Akonahle vlozime primitivny int, nastane AUTOBOXING
		// na typ Integer. Potom pri vybere hodnoty musime pretypovat hodnotu na Integer,
		// ta nasledne bude cez UNBOXING pretypovana na primitivny int,
		// alebo priamo pretypujeme na int
		int i1 = (Integer) oList.get(0);
		int i2 = (int) oList.get(0);


		// Do typovo chraneho zoznamu nemozme vkladat nic ine ako typ Zakaznik
		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("770727/1234", "Johhny"));

		// pri vyber hodnoty preto nemusime pouzit explicitny cast
		Zakaznik z = zList.get(0);

	}

}
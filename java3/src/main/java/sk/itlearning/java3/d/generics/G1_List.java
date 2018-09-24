package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java3.m.zakaznik.Firma;
import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G1_List {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		@SuppressWarnings("rawtypes")
		List oList = new ArrayList();
		oList.add(new Boolean(true));
		oList.add(new Integer(100));
		oList.add("text");
		oList.add(new Firma("ico", "nazov"));

		for (Object i : oList) {
			System.out.println(i);
			if (i instanceof Zakaznik) {
				((Zakaznik)i).getId();
			}
		}

		List<Zakaznik> zList = new ArrayList<Zakaznik>();
		zList.add(new Obcan("770727/1234", "Johhny"));
		zList.add(new Firma("23456789", "Ooogle"));
//		zList.add("");
		// zList.add("string value");

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}


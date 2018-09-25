package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;

import sk.itlearning.java3.m.zakaznik.Firma;
import sk.itlearning.java3.m.zakaznik.Obcan;
import sk.itlearning.java3.m.zakaznik.Zakaznik;

public class G2_List {

	public static void main(String[] args) {

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

		List<Zakaznik> zList = new ArrayList<>();
		zList.add(new Obcan("770727/1234", "Johhny"));
		zList.add(new Firma("23456789", "Ooogle"));
//		zList.add("");
		// zList.add("string value");

		for (Zakaznik i : zList) {
			System.out.println(i.getId());
		}

	}

}


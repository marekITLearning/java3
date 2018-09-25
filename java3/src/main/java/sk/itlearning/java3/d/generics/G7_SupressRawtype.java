package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G7_SupressRawtype {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Muz[] muzi = new Muz[]{new Muz(), new Muz()};
		Zena[] zeny = new Zena[]{new Zena()};
//		List<Muz> listMuzi = new ArrayList<Muz>(Arrays.asList(muzi));
		// List listMuzi = new ArrayList(Arrays.asList(muzi));
		List listZeny = new ArrayList(Arrays.asList(zeny));
		addClovek(listZeny);
		for (Object o : listZeny) {
			System.out.println(o);
		}

	}

	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
	}
}

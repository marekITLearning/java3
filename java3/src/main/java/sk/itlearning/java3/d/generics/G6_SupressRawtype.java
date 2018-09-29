package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G6_SupressRawtype {

	public static void main(String[] args) {

		Zena[] zeny = new Zena[] { new Zena() };

		Muz[] muzi = new Muz[] { new Muz(), new Muz() };
		
		List<Muz> listGenericky = new ArrayList<>(Arrays.asList(muzi));
//		addClovek(listGenericky);
		
		List listObjektov = new ArrayList(Arrays.asList(muzi));
		addClovek(listObjektov);
		
	}

	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
	}
	
}

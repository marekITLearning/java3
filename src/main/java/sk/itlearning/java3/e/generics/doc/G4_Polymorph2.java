package sk.itlearning.java3.e.generics.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G4_Polymorph2 {

	public static void main(String[] args) {

		Muz[] muzi = new Muz[]{new Muz(), new Muz()}; // pole mozme inicializovat takto
		Zena[] zeny = {new Zena(), new Zena()};  // alebo aj takto

		List<Muz> listMuzi = new ArrayList<Muz>(Arrays.asList(muzi));
		List<Zena> listZeny = new ArrayList<Zena>(Arrays.asList(zeny));

		List<Clovek> listLudia = new ArrayList<Clovek>();
		listLudia.add(new Muz());
		listLudia.add(new Zena());

		// Fungovat nebude ani nasledovne
		// addClovek(listMuzi);

		// Hoci pri poliach obdobny kod funguje
		addClovek(muzi);

		// Dovod, preco horeuvedene funguje pre polia je, ze pre polia existuje vynimka ArrayStoreException,
		// ktora sa vyhodi pri pokuse o vlozenie objektu nespravneho typu.

		// Dovod, preco horeuvedene nefunguje pre genericke zoznamy je, ze kompilacia zmaze genericke typy,
		// takze JVM vidi iba List, ktory prijima lubovolny objekt a JVM nema informaciu, akeho typu su prvky
		// v zozname, takze nerozpozna ani pripadnu hrozbu vlozenia nespravneho typu. A preto je to rovno zakazane.

	}

	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
	}

	private static void addClovek(Clovek[] list) {
		list[0] = new Muz();
	}

}


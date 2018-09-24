package sk.itlearning.java3.e.generics.doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G4_Polymorph3 {

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

		// Ak by sme vsak nic nevkladali, tak neexistuje hrozba. Preto existuje moznost zadefinovat
		// metodu, ktora prijme aj genericke podtypy, ale nedovoli v danej metode vklada prvky
		readLudia(listMuzi);

		// Metoda ktora pouziva <? extends SomeInterface> akceptuje dokonca aj abstraktne typy
		// a implementacie rozhrania
		readSerializable(new ArrayList<Clovek>());

		// Dalsia moznost
		addSuperType(new ArrayList<Clovek>());

		// wildcard ? nam dava moznost polymorfnych priradeni, avsak s urcitymi obmedzeniami

		// Napokon este jedna moznost, ako donutit prijat hociktory objekt,
		// ale nie je povolene v metode zapisat do zoznamu vobec nic..
		readAnyType(new ArrayList<Object>());

		// A co metoda ktora ako deklarovany typ prijima ArrayList<Object>?
		// V tomto pripade by metoda akecptovala iba zoznam s generickym typom Object,
		// a povolila by pridavanie do zoznamu

		// Mimochodom parametre List<?> a List<? extends Object> su uplne identicke

	}

	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
	}

	private static void addClovek(Clovek[] list) {
		list[0] = new Muz();
		// ludia[1] = new Zena();
	}

	private static void readLudia(List<? extends Clovek> list) {
		for (Clovek c : list) {
			System.out.println(c);
		}
		// Syntax ? extends Clovek nam nedovoli do zoznamu vkladat, compilacna chyba vyzera takto zvlastne:
		// The method add(capture#2-of ? extends Clovek) in the type List<capture#2-of ? extends Clovek> is not applicable for the arguments (Muz)
		// list.add(new Muz());

	}

	private static void readSerializable(List<? extends Serializable> list) {
		// do nothing
	}

	private static void addSuperType(ArrayList<? super Muz> list) {
		list.add(new Muz());
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}

	private static void readAnyType(ArrayList<?> list) {
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
}


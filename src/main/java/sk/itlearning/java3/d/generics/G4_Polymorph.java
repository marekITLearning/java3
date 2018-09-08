package sk.itlearning.java3.d.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G4_Polymorph {

	public static void main(String[] args) {

		Muz[] muzi = new Muz[]{new Muz(), new Muz()};
		Zena[] zeny = {new Zena(), new Zena()};
		Clovek[] mz = {new Zena(), new Muz()};
		
		List<Muz> listMuzi = new ArrayList<Muz>(Arrays.asList(muzi));

		List<Clovek> listLudia = new ArrayList<Clovek>();
		listLudia.add(new Muz());
		listLudia.add(new Zena());

//		 addClovek(listMuzi);
		addClovek(muzi);
		readLudia(listMuzi);
		readSerializable(new ArrayList<Clovek>());
		addSuperType(new ArrayList<Clovek>());
		readAnyType(new ArrayList<Character>());
		readAnyType2(new ArrayList<Object>());
	}

	private static void addClovek(List<Clovek> list) {
		list.add(new Muz());
		list.add(new Zena());
	}

	private static void addClovek(Clovek[] list) {
		list[0] = new Muz();
//		list[1] = new Zena(); //ArrayStoreException
	}

	private static void readLudia(List<? extends Clovek> list) {
		for (Clovek c : list) {
			System.out.println(c);
		}
//		 list.add(new Muz());
	}

	private static void readSerializable(List<? extends Serializable> list) {
		// do nothing
	}

	private static void addSuperType(ArrayList<? super Muz> list) {
		list.add(new Muz());
//		list.add(new Zena());
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}

	private static void readAnyType(ArrayList<?> list) {
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
	
	private static void readAnyType2(ArrayList<Object> list) {
		// metoda akceptuje genericky typ Muz a akykolvek objekt nadtriedy ku triede Muz
	}
}


abstract class Clovek implements Serializable {
	public abstract void objednatKu();
}

class Muz extends Clovek {
	@Override
	public void objednatKu() {
		System.out.println("Prijata objednavka ku urologovi");
	}
}

class Zena extends Clovek {
	@Override
	public void objednatKu() {
		System.out.println("Prijata objednavka ku gynekologovi");
	}
}

class Lekar {
	public void prijatObjednavku(Clovek c) {
		c.objednatKu();
	}

	public void prijatObjednavku(List<Clovek> list) {
		for (Clovek c : list) {
			prijatObjednavku(c);
		}
	}
}
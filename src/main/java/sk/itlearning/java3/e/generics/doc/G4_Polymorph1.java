package sk.itlearning.java3.e.generics.doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class G4_Polymorph1 {

	public static void main(String[] args) {

		Muz[] muzi = new Muz[]{new Muz(), new Muz()}; // pole mozme inicializovat takto

		Zena[] zeny = {new Zena(), new Zena()};  // alebo aj takto

		// polia funguju polymorfne - do pola vseobecnejsieho typu mozno
		// vkladat polia lubovolneho podtypu
		Clovek[] ludia1 = muzi;
		Clovek[] ludia2 = zeny;

		/* polymorfizmus pri generickych typoch nefunguje!!!
		 * polymorfizmus sa generickeho typu (v hranatych zatvorkach) netyka
		 *
		 * nizsie uvedeny kod je teda zakomentovany, inak by vyhlasil chybu:
		 *
		 * Type mismatch: cannot convert from List<Muz> to List<Clovek>
		 */

		// List<Clovek> listLudia1 = new ArrayList<Muz>();
		// List<Clovek> listLudia2 = listZeny;

		// Horeuvedene nefunguje, ale nasledovny kod je uplne v poriadku,
		// pretoze na samotny vkladany objekt uz polymorfizmus funguje
		List<Clovek> listLudia3 = new ArrayList<Clovek>();
		listLudia3.add(new Muz());
		listLudia3.add(new Zena());

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
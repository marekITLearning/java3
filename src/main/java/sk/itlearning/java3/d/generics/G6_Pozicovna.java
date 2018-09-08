package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;


public class G6_Pozicovna {

	static class Pozicovna<T> {
		private List<T> dostupneNaVypozicanie;

		public Pozicovna(List<T> dostupneNaVypozicanie) {
			this.dostupneNaVypozicanie = dostupneNaVypozicanie;
		}

		public T pozicaj() {
			return dostupneNaVypozicanie.remove(0);
		}

		public void vrat(T t) {
			dostupneNaVypozicanie.add(t);
		}
	}

	static class Auto {
		String typ;
		public Auto(String typ) { this.typ = typ; }
		public String toString() {
			return typ;
		}
	}

	static class Saty {
		String typ;
		public Saty(String typ) { this.typ = typ; }
		public String toString() {
			return typ;
		}
	}

	public static void main(String[] args) {

		List<Auto> listAuto = new ArrayList<Auto>();
		listAuto.add(new Auto("BMW"));
		listAuto.add(new Auto("Audi"));
		
		
		Pozicovna<Auto> pa = new Pozicovna<Auto>(listAuto);
		
		System.out.println(pa.dostupneNaVypozicanie);
		
		Auto x = pa.pozicaj();
		System.out.println(pa.dostupneNaVypozicanie);
		
		System.out.println(x);
		
		List<Saty> listSaty = new ArrayList<Saty>();
		listSaty.add(new Saty("rifle"));
		listSaty.add(new Saty("sako"));
		
		Pozicovna<Saty> ps = new Pozicovna<>(listSaty);
				
		
//		List<Auto> listAuto = new ArrayList<Auto>();
//		listAuto.add(new Auto("BMW"));
//		listAuto.add(new Auto("Audi"));
//
//		Pozicovna<Auto> pa = new Pozicovna<Auto>(listAuto);
//		System.out.println("Dostupne Auta: " + pa.dostupneNaVypozicanie);
//
//		Auto a = pa.pozicaj();
//		System.out.println("Dostupne Auta: " + pa.dostupneNaVypozicanie);
//
//		pa.vrat(a);
//		System.out.println("Dostupne Auta: " + pa.dostupneNaVypozicanie);
//
//
//		List<Saty> listSaty = new ArrayList<Saty>();
//		listSaty.add(new Saty("Svadobne"));
//		listSaty.add(new Saty("Sportove"));
//
//		Pozicovna<Saty> ps = new Pozicovna<Saty>(listSaty);
//		Saty s = ps.pozicaj();
//		ps.vrat(s);
	}

}
package sk.itlearning.java3.d.generics;

import java.util.ArrayList;
import java.util.List;


public class G5_Pozicovna {

	public static void main(String[] args) {
		List<Auto> listAuto = new ArrayList<Auto>();
		listAuto.add(new Auto("BMW"));
		listAuto.add(new Auto("Audi"));
		
		PozicovnaAut pa = new PozicovnaAut(listAuto);
		System.out.println(pa.dostupneNaVypozicanie);
		
		Auto pozicane = pa.pozicaj();
		System.out.println(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
		pa.vrat(pozicane);
		System.out.println(pa.dostupneNaVypozicanie);
		
	}
	
	static class PozicovnaAut {
		private List<Auto> dostupneNaVypozicanie;

		public PozicovnaAut(List<Auto> dostupneNaVypozicanie) {
			this.dostupneNaVypozicanie = dostupneNaVypozicanie;
		}

		public Auto pozicaj() {
			return dostupneNaVypozicanie.remove(0);
		}

		public void vrat(Auto t) {
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

}
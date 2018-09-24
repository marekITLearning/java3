package sk.itlearning.java3.o.clone;

import sk.itlearning.java3.m.zakaznik.Obcan;

public class Main {

	
	public static void main(String[] args) {
	
		Obcan o = new Obcan("1234", "Jozo").setKredit(200.0);
		
		System.out.println(o.getKredit());
		
		Obcan o2 = o.clone();
		
		Obcan o3 = Obcan.clone(o2);
		
	}
	
}

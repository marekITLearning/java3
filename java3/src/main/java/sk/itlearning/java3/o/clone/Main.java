package sk.itlearning.java3.o.clone;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {

		Obcan o = new Obcan("1234", "Jozo");
		o.setKredit(new BigDecimal(100));

		System.out.println(o.getKredit());

//		Obcan o2 = o.clone();
//
//		Obcan o3 = Obcan.clone(o2);

	}

}

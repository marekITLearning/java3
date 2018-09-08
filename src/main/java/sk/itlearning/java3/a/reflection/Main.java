package sk.itlearning.java3.a.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {

		String config = "sk.itlearning.java3.a.reflection.VypocetB";

		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Vypocet v = null;
			try {
				Class<Vypocet> cls = (Class<Vypocet>) Class.forName(config);
				Constructor<Vypocet> con = cls.getConstructor(Integer.class);
				v = con.newInstance(5);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
			}

			if (v != null) {

				System.out.println(v.vypocitaj());
			}
		}

	}

}

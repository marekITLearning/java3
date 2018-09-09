package sk.itlearning.java3.a.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
//				Method[] methods = cls.getMethods();
//				for (Method m : methods) {
//					System.out.println(m.getName());
//					System.out.println(m.invoke(v));
//				}
				Method m = cls.getMethod("vypocitaj");
				System.out.println(m.invoke(v));
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
			}


		}

	}

}

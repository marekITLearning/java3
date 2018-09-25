package sk.itlearning.java3.a.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		String conf = "sk.itlearning.java3.a.reflection.VypocetA";
		
		while (true) {
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				Class<Vypocet> clazz = (Class<Vypocet>) Class.forName(conf);
				Constructor<Vypocet> constructor = clazz.getConstructor(String.class);
				Vypocet v = constructor.newInstance("xy");
				Method m = clazz.getMethod("vypocitaj");
				System.out.println(m.invoke(v));
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}

}

package sk.itlearning.java3.a.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {

		String conf = "sk.itlearning.java3.a.reflection.VypocetA";
		
		try {
			Class<?> c = Class.forName(conf);
			Constructor<?> cc = c.getConstructor(int.class);
			Vypocet v = (Vypocet) cc.newInstance(10);
			Method m = c.getMethod("vypocitaj");
			System.out.println(m.invoke(v));
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}	
	}
		
}

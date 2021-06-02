package sk.itlearning.java3.java3a.a.reflection;

public class Main {

	public static void main(String[] args) {

		Vypocet v1 = new VypocetSposob1(1);

		System.out.println(v1.vypocitaj());

		Vypocet v2 = new VypocetSposob2(1);

		System.out.println(v2.vypocitaj());

//		String conf = "sk.itlearning.java3.a.reflection.VypocetA";		
//		try {
//			Class<?> c = Class.forName(conf);
//			Constructor<?> cc = c.getConstructor(int.class);
//			Vypocet v = (Vypocet) cc.newInstance(10);
//			Method m = c.getMethod("vypocitaj");
//			System.out.println(m.invoke(v));
//		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
	}

}

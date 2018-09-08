package sk.itlearning.java3.d.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import sk.itlearning.java3.m.zakaznik.Obcan;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Obcan> mapaObcanov = new HashMap<>();
		mapaObcanov.put("12345", new Obcan("", "Jano"));
		mapaObcanov.put("12346", new Obcan("", "Miso"));

		Map<Integer, BigDecimal> mapaCisel = new HashMap<>();
		mapaCisel.put(1, BigDecimal.valueOf(10));
		mapaCisel.put(2, BigDecimal.valueOf(20));
		
		MapReader.printAnyMap(mapaCisel);
		
		MapReader.printAnyMap(mapaObcanov);
	}

}

package sk.itlearning.java3.d.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import sk.itlearning.java1.h.zakaznik.Obcan;

public class G8_PrintGeneric {

	public static void main(String[] args) {
		
		Map<String, Obcan> mapaObcanov = new HashMap<>();
		mapaObcanov.put("12345", new Obcan("", "Jano"));
		mapaObcanov.put("12346", new Obcan("", "Miso"));

		Map<Integer, BigDecimal> mapaCisel = new HashMap<>();
		mapaCisel.put(1, BigDecimal.valueOf(10));
		mapaCisel.put(2, BigDecimal.valueOf(20));
		
		printAnyMap(mapaCisel);
		
		printAnyMap(mapaObcanov);
	}

	public static <K, V> void printAnyMap(Map<K, V> mapa) {
		for (K key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}
	
}

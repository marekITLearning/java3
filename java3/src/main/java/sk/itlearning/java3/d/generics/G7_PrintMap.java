package sk.itlearning.java3.d.generics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import sk.itlearning.java1.h.zakaznik.Obcan;

public class G7_PrintMap {

	public static void main(String[] args) {
		
		Map<String, Obcan> mapaObcanov = new HashMap<>();
		mapaObcanov.put("12345", new Obcan("", "Jano"));
		mapaObcanov.put("12346", new Obcan("", "Miso"));

		Map<Integer, BigDecimal> mapaCisel = new HashMap<>();
		mapaCisel.put(1, BigDecimal.valueOf(10));
		mapaCisel.put(2, BigDecimal.valueOf(20));
		
		printMapObcan(mapaObcanov);
		
	}
	
	public static void printMapObcan(Map<String, Obcan> mapa) {
		for (String key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}
	
}

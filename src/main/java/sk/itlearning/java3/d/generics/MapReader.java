package sk.itlearning.java3.d.generics;

import java.math.BigDecimal;
import java.util.Map;

import sk.itlearning.java3.m.zakaznik.Obcan;

public class MapReader {

	public static void printMapObcan(Map<String, Obcan> mapa) {
		for (String key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}
	
	public static void printMapBigDecimal(Map<Integer, BigDecimal> mapa) {
		for (Integer key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}

	public static <K, V> void printAnyMap(Map<K, V> mapa) {
		for (K key : mapa.keySet()) {
			System.out.println(mapa.get(key));
		}
	}
	
}

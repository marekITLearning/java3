package sk.itlearning.java3.java3b.o.json;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sk.itlearning.java3.java3b.n.csv.test.Firma;

public class Main {

	public static void main(String[] args) {

		Reader r = new InputStreamReader(Main.class.getResourceAsStream("firmy.json"));

//		Gson gson = new Gson();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Firma[] firmy = gson.fromJson(r, Firma[].class);
		
		for (Firma f : firmy) {
			f.setAdresa("Nejaka adresa");
		}

		Arrays.asList(firmy).forEach(System.out::println);
		
		System.out.println(gson.toJson(firmy));

	}

}

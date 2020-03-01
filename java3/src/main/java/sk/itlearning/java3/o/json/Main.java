package sk.itlearning.java3.o.json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import sk.itlearning.java3.n.csv.test.Firma;

public class Main {

	public static void main(String[] args) {
		
		InputStream is = Main.class.getResourceAsStream("firmy.json");
		
		Firma[] firmy = new Gson().fromJson(new InputStreamReader(is), Firma[].class);
		
		Arrays.asList(firmy).forEach(System.out::println);
		
		is = Main.class.getResourceAsStream("firmy.json");
		try {
			String firmyAsString = IOUtils.toString(new InputStreamReader(is));
			System.out.println(firmyAsString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		for (Firma f : firmy) {
			f.setTrzby(new BigDecimal(2222222222.0));
		}
		
		try (
			FileWriter fw = new FileWriter("noveFirmy.json");
				) {
			fw.append(new Gson().toJson(firmy));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

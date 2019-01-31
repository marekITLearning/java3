package sk.itlearning.java3.n.csv.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

public class MainJson {

	public static void main(String[] args) {

		InputStream is = MainJson.class.getResourceAsStream("firmy.json");
		
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(is, writer, StandardCharsets.UTF_8.name());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String theJsonFirma = writer.toString();
		
		System.out.println(theJsonFirma);
		
		Firma[] f = new Gson().fromJson(theJsonFirma, Firma[].class);
		
		Arrays.asList(f).forEach(e -> System.out.println(e));
		
//		is = MainJson.class.getResourceAsStream("firmy.json");
//		
//		Firma f2 = new Gson().fromJson(new InputStreamReader(is), Firma.class);
//		
//		System.out.println(f2);
//		
	}

}

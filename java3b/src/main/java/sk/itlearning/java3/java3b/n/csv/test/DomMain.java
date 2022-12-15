package sk.itlearning.java3.java3b.n.csv.test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import sk.itlearning.java3.java3b.n.csv.core.CsvMapping;
import sk.itlearning.java3.java3b.n.csv.core.CsvReaderParams;

public class DomMain {

	public static void main(String[] args) {
		
		CsvReaderParams params = new CsvReaderParams();
		
		params = new CsvReaderParams();
		params.setBatchSize(10);
		params.setCharset(StandardCharsets.UTF_8);
		params.setCsvFile(DomMain.class.getResourceAsStream("domy.csv"));
		params.setCsvSeparator(';');
		params.setSkipLines(1);
		
		params.getMappingList().add(new CsvMapping().setCsvIndex(0).setFieldName("ulica"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(1).setFieldName("cislo"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(2).setFieldName("typ"));
		
		DomCsvImportBean bytCsvImportBean = new DomCsvImportBean();
		
		List<Dom> domy = bytCsvImportBean.getNextBatch(params);
		
		for (Dom f : domy) {
			System.out.println(f);
		}
		
		params = new CsvReaderParams();
		params.setBatchSize(10);
		params.setCharset(StandardCharsets.ISO_8859_1);
		params.setCsvFile(DomMain.class.getResourceAsStream("firmy.csv"));
		params.setCsvSeparator(';');
		params.setSkipLines(1);
		
		params.getMappingList().add(new CsvMapping().setCsvIndex(0).setFieldName("id"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(1).setFieldName("name"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(2).setFieldName("trzby"));
		
		FirmaCsvImportBean firmaCsvImportBean = new FirmaCsvImportBean();
		
		List<Firma> firmy = firmaCsvImportBean.getNextBatch(params);
		
		while (firmy.size() > 0) {
			firmy.forEach(System.out::println);
			firmy = firmaCsvImportBean.getNextBatch(params);
		}
		

		
	}
	
}

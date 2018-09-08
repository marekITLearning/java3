package sk.itlearning.java3.n.csv.model;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import sk.itlearning.java3.n.csv.biz.BytyCsvImportBean;
import sk.itlearning.java3.n.csv.biz.FirmaCsvImportBean;
import sk.itlearning.java3.n.csv.core.CsvMapping;
import sk.itlearning.java3.n.csv.core.CsvReaderParams;

public class Main {

	public static void main(String[] args) {
		
		CsvReaderParams params = new CsvReaderParams();
		params.setBatchSize(10);
		params.setCharset(StandardCharsets.ISO_8859_1);
		params.setCsvFile(new File("C:\\devel\\firmy.csv"));
		params.setCsvSeparator(';');
		params.setSkipLines(1);
		
		params.getMappingList().add(new CsvMapping().setCsvIndex(0).setFieldName("ico"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(1).setFieldName("nazov"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(2).setFieldName("trzby"));
		
		FirmaCsvImportBean firmaCsvImportBean = new FirmaCsvImportBean();
		
		List<Firma> firmy = firmaCsvImportBean.getNextBatch(params);
		
		for (Firma f : firmy) {
			System.out.println(f);
		}
		
		params = new CsvReaderParams();
		params.setBatchSize(10);
		params.setCharset(StandardCharsets.ISO_8859_1);
		params.setCsvFile(new File("C:\\devel\\domy.csv"));
		params.setCsvSeparator(';');
		params.setSkipLines(1);
		
		params.getMappingList().add(new CsvMapping().setCsvIndex(0).setFieldName("ulica"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(1).setFieldName("cislo"));
		params.getMappingList().add(new CsvMapping().setCsvIndex(2).setFieldName("typ"));
		
		BytyCsvImportBean bytCsvImportBean = new BytyCsvImportBean();
		
		List<Byt> byty = bytCsvImportBean.getNextBatch(params);
		
		for (Byt f : byty) {
			System.out.println(f);
		}
		
	}
	
}

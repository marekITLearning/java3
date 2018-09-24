package sk.itlearning.java3.n.csv.biz;

import java.io.FileNotFoundException;
import java.util.List;

import sk.itlearning.java3.n.csv.bean.DomCsvEntity;
import sk.itlearning.java3.n.csv.core.CsvReader;
import sk.itlearning.java3.n.csv.core.CsvReaderParams;
import sk.itlearning.java3.n.csv.model.Dom;

public class DomCsvImportBean {

	private CsvReader<DomCsvEntity, Dom> reader;

	public List<Dom> getNextBatch(CsvReaderParams params) {
		if (reader == null) {
			try {
				reader = new CsvReader<>(DomCsvEntity.class, params);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
		return reader.getNextBatch();
	}

	public void resetReader() {
		reader = null;
	}

}

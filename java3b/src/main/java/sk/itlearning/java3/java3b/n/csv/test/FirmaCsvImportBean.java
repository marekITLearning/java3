package sk.itlearning.java3.java3b.n.csv.test;

import java.io.FileNotFoundException;
import java.util.List;

import sk.itlearning.java3.java3b.n.csv.core.CsvReader;
import sk.itlearning.java3.java3b.n.csv.core.CsvReaderParams;

public class FirmaCsvImportBean {

	private CsvReader<FirmaCsvEntity, Firma> reader;

	public List<Firma> getNextBatch(CsvReaderParams params) {
		if (reader == null) {
			try {
				reader = new CsvReader<>(FirmaCsvEntity.class, params);
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

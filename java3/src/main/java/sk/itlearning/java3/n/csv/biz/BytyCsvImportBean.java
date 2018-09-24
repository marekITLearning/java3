package sk.itlearning.java3.n.csv.biz;

import java.io.FileNotFoundException;
import java.util.List;

import sk.itlearning.java3.n.csv.bean.BytyCsvEntity;
import sk.itlearning.java3.n.csv.core.CsvReader;
import sk.itlearning.java3.n.csv.core.CsvReaderParams;
import sk.itlearning.java3.n.csv.model.Byt;

public class BytyCsvImportBean {

	private CsvReader<BytyCsvEntity, Byt> reader;

	public List<Byt> getNextBatch(CsvReaderParams params) {
		if (reader == null) {
			try {
				reader = new CsvReader<>(BytyCsvEntity.class, params);
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

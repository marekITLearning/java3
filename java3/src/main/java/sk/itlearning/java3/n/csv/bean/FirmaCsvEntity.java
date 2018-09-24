package sk.itlearning.java3.n.csv.bean;

import java.math.BigDecimal;

import sk.itlearning.java3.n.csv.core.CsvEntity;
import sk.itlearning.java3.n.csv.model.Firma;

public class FirmaCsvEntity extends Firma implements CsvEntity<Firma> {

	@Override
	public Firma toModel() {
		Firma modelObject = new Firma();
		modelObject.setNazov(this.getNazov());
		modelObject.setIco(this.getIco());
		modelObject.setTrzby(this.getTrzby());
		return modelObject;
	}
	
	@Override
	public void setNazov(String nazov) {
		super.setNazov(nazov);
	}
	
	@Override
	public void setIco(String ico) {
		super.setIco(ico);
	}
	
	public void setTrzby(String trzby) {
		super.setTrzby(BigDecimal.valueOf(Long.valueOf(trzby)));
	}

}

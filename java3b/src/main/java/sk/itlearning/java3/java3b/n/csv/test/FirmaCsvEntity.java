package sk.itlearning.java3.java3b.n.csv.test;

import java.math.BigDecimal;

import sk.itlearning.java3.java3b.n.csv.core.CsvEntity;

public class FirmaCsvEntity extends Firma implements CsvEntity<Firma> {

	@Override
	public Firma toModel() {
		Firma modelObject = new Firma();
		modelObject.setId(getId());
		modelObject.setName(getName());
		modelObject.setTrzby(getTrzby());
		return modelObject;
	}

	public void setId(String id) {
		super.setId(Integer.valueOf(id));
	}

	public void setName(String name) {
		super.setName(name);
	}

	public void setTrzby(String trzby) {
		super.setTrzby(BigDecimal.valueOf(Double.valueOf(trzby)));
	}

}

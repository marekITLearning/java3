package sk.itlearning.java3.n.csv.bean;

import sk.itlearning.java3.n.csv.core.CsvEntity;
import sk.itlearning.java3.n.csv.model.Dom;

public class DomCsvEntity extends Dom implements CsvEntity<Dom> {

	@Override
	public Dom toModel() {
		Dom modelObject = new Dom();
		modelObject.setCislo(this.getCislo());
		modelObject.setTyp(this.getTyp());
		modelObject.setUlica(this.getUlica());
		return modelObject;
	}
	
	public void setCislo(String cislo) {
		super.setCislo(Integer.valueOf(cislo));
	}
}

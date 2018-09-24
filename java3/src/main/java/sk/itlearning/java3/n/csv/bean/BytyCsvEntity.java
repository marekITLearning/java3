package sk.itlearning.java3.n.csv.bean;

import sk.itlearning.java3.n.csv.core.CsvEntity;
import sk.itlearning.java3.n.csv.model.Byt;

public class BytyCsvEntity extends Byt implements CsvEntity<Byt> {

	@Override
	public Byt toModel() {
		Byt modelObject = new Byt();
		modelObject.setCislo(this.getCislo());
		modelObject.setTyp(this.getTyp());
		modelObject.setUlica(this.getUlica());
		return modelObject;
	}
	
	public void setCislo(String cislo) {
		super.setCislo(Integer.valueOf(cislo));
	}
}

package sk.itlearning.java3.n.csv.model;

import java.math.BigDecimal;

public class Firma {

	private String ico;
	private String nazov;
	private BigDecimal trzby;

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public BigDecimal getTrzby() {
		return trzby;
	}

	public void setTrzby(BigDecimal trzby) {
		this.trzby = trzby;
	}
	
	@Override
	public String toString() {
		return "Firma: " + this.nazov + "  ###  Ico: " + this.getIco() + "  ###  Trzby: " + this.trzby; 
	}

}

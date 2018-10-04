package sk.itlearning.java3.o.clone;

import java.math.BigDecimal;

public class Obcan implements Zakaznik {

	private String rodneCislo;
	
	private String meno;
	
	private BigDecimal kredit;

	public String getRodneCislo() {
		return rodneCislo;
	}
	
	public Obcan(String rodneCislo, String meno) {
		setRodneCislo(rodneCislo);
		setMeno(meno);
	}

	public void setRodneCislo(String rodneCislo) {
		rodneCislo = rodneCislo.replace("/", "");
		long rcc = Long.valueOf(rodneCislo);
		if ( rcc % 11 == 0) {
			this.rodneCislo = rodneCislo;
		} else {
			throw new IllegalArgumentException("Zadali ste neplatne rodne cislo");
		}
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public BigDecimal getKredit() {
		return kredit;
	}

	public void setKredit(BigDecimal kredit) {
		this.kredit = kredit;
	}
	
	@Override
	public String getId() {
		return getRodneCislo();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Obcan) {
			return rodneCislo.equals( ((Obcan)obj).getRodneCislo() );
		}
		return false;
	}

	@Override
	public int hashCode() {
		rodneCislo = rodneCislo.replace("/", "");
		long rcc = Long.valueOf(rodneCislo);
		return Long.valueOf(rcc/11).hashCode();
	}

	@Override
	public String toString() {
		return "Zakaznik; typ Obcan; RC = " + rodneCislo + "; Meno = " + meno;
	}
	
}

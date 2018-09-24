package sk.itlearning.java3.m.zakaznik;

public class Obcan implements Zakaznik {

	private String rc;
	private String meno;
	private Double kredit;

	public Obcan(String rc, String meno) {
		this.setRc(rc);
		this.setMeno(meno);
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	@Override
	public String getId() {
		return rc;
	}

	public Double getKredit() {
		return kredit;
	}

	public Obcan setKredit(Double kredit) {
		this.kredit = kredit;
		return this;
	}
	
	@Override
	public Obcan clone() {
		Obcan newObcan = new Obcan(this.rc, this.meno).setKredit(this.getKredit());
		return newObcan;
	}
	
	public static Obcan clone(Obcan p) {
		return new Obcan(p.rc, p.meno);
	}

}

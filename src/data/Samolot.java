package data;

public class Samolot extends Pojazd {

	private int liczbaPlatow;
	private int iloscSilnikow;

	public int getLiczbaPlatow() {
		return liczbaPlatow;
	}

	public void setLiczbaPlatow(int liczbaPlatow) {
		this.liczbaPlatow = liczbaPlatow;
	}

	public int getIloscSilnikow() {
		return iloscSilnikow;
	}

	public void setIloscSilnikow(int iloscSilnikow) {
		this.iloscSilnikow = iloscSilnikow;
	}

	public Samolot(String marka, String model, double cena, int rok, int liczbaPlatow, int iloscSilnikow) {
		super(marka, model, cena, rok);
		setLiczbaPlatow(liczbaPlatow);
		setIloscSilnikow(iloscSilnikow);
	}

	@Override
	public String toString() {
		return getMarka() + " ; " + getModel() + " ; " + getCena() + " ; " + getRok() + " ; " 
	+ getIloscSilnikow()+" ; "+getLiczbaPlatow();
	}
}

package data;

import java.io.Serializable;
import java.time.LocalDate;

public class Pojazd implements Serializable{
	private static final long serialVersionUID = 2303990704070451652L;
	private double cena;
	private int rok;
	private String marka;
	private String model;
	private LocalDate czasWypozyczenia;
	private LocalDate terminOddania;
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getRok() {
		return rok;
	}
	public void setRok(int rok) {
		this.rok = rok;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getCzasWypozyczenia() {
		return czasWypozyczenia;
	}
	public void setCzasWypozyczenia(LocalDate czasWypozyczenia) {
		this.czasWypozyczenia = czasWypozyczenia;
	}
	public LocalDate getTerminOddania() {
		return terminOddania;
	}
	public void setTerminOddania(LocalDate terminOddania) {
		this.terminOddania = terminOddania;
	}
	public Pojazd(String marka,String model,double cena,int rok){
		setCena(cena);
		setMarka(marka);
		setModel(model);
		setRok(rok);
	}
	
}


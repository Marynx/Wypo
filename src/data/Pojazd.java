package data;

public class Pojazd {
	private double cena;
	private int rok;
	private String marka;
	private String model;
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
	
	public Pojazd(String marka,String model,double cena,int rok){
		setCena(cena);
		setMarka(marka);
		setModel(model);
		setRok(rok);
	}
	
}


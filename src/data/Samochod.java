package data;

public class Samochod extends Pojazd{
	private String typ;
	private String rodzajPaliwa;
	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
 
	public String getRodzajPaliwa() {
		return rodzajPaliwa;
	}

	public void setRodzajPaliwa(String rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}
	public Samochod(String marka, String model, double cena, int rok,String typ,String rodzajPaliwa) {
		super(marka, model, cena, rok);
		setTyp(typ);
		setRodzajPaliwa(rodzajPaliwa);
	}

	@Override
	public String toString() {
		return getMarka()+" ; "+getModel()+" ; "+getCena()+" ; "+getRok()+" ; "+getTyp()+" ; "+getRodzajPaliwa();
	}

	

	

}

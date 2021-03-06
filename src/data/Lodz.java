package data;

public class Lodz extends Pojazd {

	private static final long serialVersionUID = 6520845742996406796L;
	private String naped;

	public String getNaped() {
		return naped;
	}

	public void setNaped(String naped) {
		this.naped = naped;
	}

	public Lodz(String marka, String model, double cena, int rok,String naped) {
		super(marka, model, cena, rok);
		setNaped(naped);
	}

	@Override
	public String toString() {
		return getMarka()+" ; "+getModel()+" ; "+getCena()+" ; "+getRok()+" ; "+getNaped();
	}

}

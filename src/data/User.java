package data;

public class User {
	private String imie;
	private String nazwisko;
	private String nazwa;
	private String haslo;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public User(String imie, String nazwisko, String nazwa, String haslo) {
		setImie(imie);
		setNazwisko(nazwisko);
		setNazwa(nazwa);
		setHaslo(haslo);
	}

	public String toString() {
		return imie + " " + nazwisko + " :" + nazwa;
	}
}

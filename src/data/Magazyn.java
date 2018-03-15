package data;

import java.util.HashMap;
import java.util.Map;

public class Magazyn {
	private Map<String, Pojazd> pojazdy;
	private Map<String,User> uzytkownicy;
	public Magazyn() {
		pojazdy = new HashMap<>();
		uzytkownicy=new HashMap<>();
	}

	public void dodajPojazd(Pojazd pojazd) {
		pojazdy.put(pojazd.getMarka(), pojazd);
	}

	public void dodajSamochod(Samochod sam) {
		dodajPojazd(sam);
	}

	public void dodajLodz(Lodz lodz) {
		dodajPojazd(lodz);
	}

	public void dodajSamolot(Samolot samolot) {
		dodajPojazd(samolot);
	}
	public void dodajUzytkownika(User user){
		uzytkownicy.put(user.getNazwa(), user);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (pojazdy.size() == 0) {
			sb.append("Brak pojazdów");
		} else {
			sb.append("Pojazdy: ");
			for (Pojazd p : pojazdy.values()) {
				sb.append(p);
				sb.append("\n");
			}
		}

		return sb.toString();
	}
	public void printUsers(){
		System.out.println("Uzytkownicy: ");
		for(User u: uzytkownicy.values()){
			System.out.println(u);
		}
	}
}

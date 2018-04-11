package data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Magazyn implements Serializable{
	private static final long serialVersionUID = 3999972370072126245L;
	private Map<String, Pojazd> pojazdy;
	private Map<String,Customer> uzytkownicy;
	public Magazyn() {
		pojazdy = new HashMap<>();
		uzytkownicy=new HashMap<>();
	}

	public Map<String,Pojazd> getPojazdy(){
		return pojazdy;
	}
	public Map<String,Customer> getUsers(){
		return uzytkownicy;
	}
	public boolean check(String check){
		
			if(uzytkownicy.containsKey(check)){
				return true;
			}else{
		return false;
			}
	}
	public void dodajPojazd(Pojazd pojazd) {
		pojazdy.put(pojazd.getMarka(), pojazd);
		
	}
	public void usunPojazd(Pojazd poj){
		if(pojazdy.containsValue(poj)){
			pojazdy.remove(poj.getMarka());
		}
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
	public void dodajUzytkownika(Customer user){
		uzytkownicy.put(user.getNazwa(), user);
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (pojazdy.size() == 0) {
			sb.append("Brak pojazdów");
		} else {
			sb.append("Pojazdy: \n");
			for (Pojazd p : pojazdy.values()) {
				sb.append(p);
				sb.append("\n");
			}
		}

		return sb.toString();
	}
	public void ilosc(){
		System.out.println(pojazdy.size());
	}
	public void printUsers(){
		System.out.println("Uzytkownicy: ");
		for(User u: uzytkownicy.values()){
			System.out.println(u);
		}
	}
}

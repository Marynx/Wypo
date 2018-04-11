package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

	private static final long serialVersionUID = 6780006821121247561L;
	private List <Pojazd> wypozyczone;
	private List <Pojazd> historiaWypozyczen;
	
	public Customer(String imie, String nazwisko, String nazwa, String haslo) {
		super(imie, nazwisko, nazwa, haslo);
		wypozyczone=new ArrayList<>();	
		historiaWypozyczen=new ArrayList<>();
		
	}



	public void wyswietlWypozyczone() {
		if(wypozyczone.size()==0){
			System.out.println("Brak wypozyczonych pojazdow");
		}else{
		for(int i=0;i<wypozyczone.size();i++){
			System.out.println(i+1+". "+wypozyczone.get(i)+" Czas wypozyczenia "
		+wypozyczone.get(i).getCzasWypozyczenia()+" termin oddania "+wypozyczone.get(i).getTerminOddania());
		}
		}
		
	}
	public List<Pojazd> getWypozyczone(){
		return wypozyczone;
	}
	public List <Pojazd> getHistoriaWypozyczen() {
		return historiaWypozyczen;
	}
	
	public void dodajPojazd(Pojazd poj){
		//test
		LocalDate czasWy=LocalDate.now();
		LocalDate termin=czasWy.plusDays(7);
		poj.setCzasWypozyczenia(czasWy);
		poj.setTerminOddania(termin);
		wypozyczone.add(poj);
		
	}
	public void dodajDoHistorii(Pojazd poj){
		historiaWypozyczen.add(poj);
	}
	
	public boolean zwrocPojazd(Pojazd poj){
		boolean result=false;
		if(wypozyczone.remove(poj)){
			result=true;
			dodajDoHistorii(poj);
		}
		return result;
	}

}

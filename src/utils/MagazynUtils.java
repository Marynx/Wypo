package utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import data.Customer;
import data.Lodz;
import data.Magazyn;
import data.Pojazd;
import data.Samochod;
import data.Samolot;

public class MagazynUtils {
public static void printCars(Magazyn mag){
	System.out.println("Dostepne samochody: ");
	wyswietlPojazdy(mag,Samochod.class);
}
public static void printBoats(Magazyn mag){
	System.out.println("Dostepne łodzie: ");
	wyswietlPojazdy(mag,Lodz.class);
}
public static void printPlanes(Magazyn mag){
	System.out.println("Dostepne samoloty: ");
	wyswietlPojazdy(mag,Samolot.class);
}
private static void wyswietlPojazdy(Magazyn mag,Class cl){
	 mag.getPojazdy().values().stream().filter(cl::isInstance).forEach(System.out::println);
}
//tutaj powinno zrobic sie to krocej , sprobowac skrocic
public static void usunLodz(Magazyn mag,Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Lodz.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak łodzi do wypozyczenia");
		return;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Lodz){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz usunac? :");
	
	int b=sc.nextInt();
	if(b>test.size()){
		System.out.println("Brak łodzi o wskazanym id");
		test.clear();
	}else{
	mag.usunPojazd(test.get(b));
	
	test.clear();
	}
	return;
	
}
public static void usunSamochod(Magazyn mag,Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Samochod.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak samochodow do wypozyczenia");
		return;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Samochod){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz usunac? :");
	int b=sc.nextInt();
	mag.usunPojazd(test.get(b));
	
	test.clear();
	
	return;
	
}
public static void usunSamolot(Magazyn mag,Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Samolot.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak samolotow do wypozyczenia");
		return;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Samolot){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz usunac? :");
	int b=sc.nextInt();
	mag.usunPojazd(test.get(b));
	
	test.clear();
	
	return;
	
}
public static Samolot wypozyczSamolot(Magazyn mag, Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Samolot.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak samolotow do wypozyczenia");
		return null;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Samolot){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz wypozyczyc? :");
	int b=sc.nextInt();
	if(b>test.size()){
		System.out.println("brak samolotu o wskazanym ID");
		test.clear();
		return null;
	}
	Samolot sam=(Samolot) test.get(b);
	
	test.clear();
	
	return sam;
}
public static Samochod wypozyczSamochod(Magazyn mag, Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Samochod.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak samochodow do wypozyczenia");
		return null ;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Samochod){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz wypozyczyc? :");
	int b=sc.nextInt();
	if(b>test.size()){
		System.out.println("brak samochodu o wskazanym ID");
		test.clear();
		return null;
	}
	Samochod sam=(Samochod) test.get(b);
	
	test.clear();
	
	return sam;
}
public static Lodz wypozyczLodz(Magazyn mag, Scanner sc){
	Collection<Pojazd> pojazdy=mag.getPojazdy().values();
	Map<Integer,Pojazd> test=new HashMap<>();
	long ilosc= mag.getPojazdy().values().stream().filter(Lodz.class::isInstance).count();
	if(ilosc==0){
		System.out.println("Brak łodzi do wypozyczenia");
		return null;
	}
	int a=1;
	for(Pojazd p: pojazdy){
		if(p instanceof Lodz){
			System.out.println(a+"."+p);
			test.put(a, p);
			a++;
		}
	}
	System.out.println("Ktory pojazd chcesz wypozyczyc? :");
	int b=sc.nextInt();
	if(b>test.size()){
		System.out.println("brak łodzi o wskazanym ID");
		test.clear();
		return null;
	}
	Lodz lodz=(Lodz) test.get(b);
	
	test.clear();
	
	return lodz;
}
public static void oddajPojazd(Customer cus, Scanner sc){
	if(cus.getWypozyczone().size()==0){
		System.out.println("Brak wypozyczonych pojazdow");
		return;
	}
	
	System.out.println("Ktory pojazd chcesz zwrocic?");
	cus.wyswietlWypozyczone();
	int a=sc.nextInt()-1;
	
	Pojazd poj = cus.getWypozyczone().get(a);
	
	if(cus.zwrocPojazd(poj)){
		System.out.println("Zwrocono pojazd");
	}else{
		System.out.println("Podany pojazd nie bylo mozna zwrocic");
	}
}

}

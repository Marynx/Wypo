package utils;

import java.util.Scanner;

import data.Customer;
import data.Lodz;

import data.Samochod;
import data.Samolot;


public class DataReader {


/*public DataReader(){
	sc=new Scanner(System.in);
}*/
	public Samochod createCar(Scanner sc){
		sc.nextLine();
		System.out.println("Podaj marke:");
		String marka=sc.nextLine();
		System.out.println("Podaj model:");
		String model=sc.nextLine();
		System.out.println("Podaj cene:");
		double cena=sc.nextDouble();
		System.out.println("Podaj rok:");
		int rok=sc.nextInt();
		sc.nextLine();
		System.out.println("Podaj typ:");
		String typ=sc.nextLine();
		System.out.println("Podaj rodzaj paliwa:\n1-Benzyna\n2-Diesel\n3-Gaz");
		//System.out.println("1-Benzyna\n 2-Diesel\n 3-Gaz");
		int rodzajPaliwa=sc.nextInt();
		if(rodzajPaliwa>3){
			System.out.println("brak rodzaju napedu o wskazanym ID, sprobuj ponownie: ");
			System.out.println("Podaj rodzaj napedu:\n1-Wisłowy\n2-Żaglowy\n3-Mechaniczny");
			rodzajPaliwa=sc.nextInt();
		}
		String rodzaj=null;
		switch(rodzajPaliwa){
		case 1:
			 rodzaj="Benzyna";
			break;
		case 2:
			rodzaj="Diesel";
			break;
		case 3:
			rodzaj="Gaz";
			break;
		}
		
		return new Samochod(marka,model,cena,rok,typ,rodzaj);
	}
	public Lodz createBoat(Scanner sc){
		sc.nextLine();
		System.out.println("Podaj marke:");
		String marka=sc.nextLine();
		System.out.println("Podaj model:");
		String model=sc.nextLine();
		System.out.println("Podaj cene:");
		double cena=sc.nextDouble();
		System.out.println("Podaj rok:");
		int rok=sc.nextInt();
		sc.nextLine();
		System.out.println("Podaj rodzaj napedu:\n1-Wisłowy\n2-Żaglowy\n3-Mechaniczny");
		int rodzajNapedu=sc.nextInt();
		if(rodzajNapedu>3){
			System.out.println("brak rodzaju napedu o wskazanym ID, sprobuj ponownie: ");
			System.out.println("Podaj rodzaj napedu:\n1-Wisłowy\n2-Żaglowy\n3-Mechaniczny");
			rodzajNapedu=sc.nextInt();
		}
		String rodzaj=null;
		switch(rodzajNapedu){
		case 1:
			 rodzaj="Wisłowy";
			break;
		case 2:
			rodzaj="Żaglowy";
			break;
		case 3:
			rodzaj="Mechaniczny";
			break;
		}
	
		return new Lodz(marka,model,cena,rok,rodzaj);
		
	}
	public Samolot createPlane(Scanner sc)throws NumberFormatException {
		sc.nextLine();
		System.out.println("Podaj marke:");
		String marka=sc.nextLine();
		System.out.println("Podaj model:");
		String model=sc.nextLine();
		double cena=0;
		int rok=0;
		int liczbaPlatow=0;
		int liczbaSilnikow=0;
		//`=boolean error=true;
		//while(error){
		try{
		System.out.println("Podaj cene:");
		/*double*/ cena=sc.nextDouble();
		System.out.println("Podaj rok:");
		/*int*/ rok=sc.nextInt();
		sc.nextLine();
		System.out.println("Podaj liczbe platow:");
		/*int*/ liczbaPlatow=sc.nextInt();
		System.out.println("Podaj liczbe silnikow:");
		/*int*/ liczbaSilnikow=sc.nextInt();
		//error=false;
		}catch(NumberFormatException e){
			sc.nextLine();
			throw e;
			
		}
		//}
		
		return new Samolot(marka,model,cena,rok,liczbaPlatow,liczbaSilnikow);
		
	}
	public Customer createUser(Scanner sc){
		System.out.println("Podaj swoje imie:");
		String imie=sc.nextLine();
		System.out.println("Podaj swoje nazwisko:");
		String nazwisko=sc.nextLine();
		System.out.println("Podaj nazwe uzytkownika:");
		String nazwa=sc.nextLine();
		System.out.println("Podaj haslo:");
		String haslo=sc.nextLine();
		return new Customer(imie,nazwisko,nazwa,haslo);
	}
	public int getInt(Scanner sc)throws NumberFormatException{
		int result=0;
		try{
			result=sc.nextInt();
		}catch(NumberFormatException e){
			throw new NumberFormatException("Liczba wprowadzona w zlej formie");
		}
		finally{
			sc.nextLine();
		}
		
		return result;
				
	}
	
}

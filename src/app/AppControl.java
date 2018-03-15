package app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import data.Lodz;
import data.Magazyn;
import data.Samochod;
import data.Samolot;
import utils.DataReader;

public class AppControl {

	Magazyn magazyn;
	DataReader reader;

	public AppControl() {
		magazyn = new Magazyn();
		reader = new DataReader();
	}

	public void startLoop(int b) {
		Scanner sc = new Scanner(System.in);
		//int b = 0;
		String admin="admin";
		String adminPass="admin";
		String in,pass=null;
		//do{
	
		//try {
			printStartOptions();
			b = sc.nextInt();
			switch (b) {
			case 1:
				userLoop(7);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Podaj login:");
				in=sc.nextLine();
				System.out.println("Podaj haslo:");
				pass=sc.nextLine();
				if(in.equals(admin)&&pass.equals(adminPass)){
					System.out.println("Zostałes zalogowany jako admin");
				adminLoop(7);
				}else{
					System.out.println("nie udalo ci sie zalogowac jako admin");
					
				}
				break;
			case 3:
				addUser();
				break;
			default:
				if(b!=0){
				System.out.println("Brak takiej opcji, wybierz ponownie");
				break;
				}
			}
		//}
		/*catch(InputMismatchException e){
			System.out.println("Podano zle dane, nic nie dodano");
			}*/
		/*catch(NumberFormatException| NoSuchElementException e){
			System.out.println("dziala");
		}*/
		if(b==0){
			System.out.println("papa");
		}else{
			startLoop(b);
		}
		//}while (b != 0);
		
		sc.close();
	}
	public void adminLoop(int b) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//do {
		//try{
			printAdminOptions();
			b = sc.nextInt();
			switch (b) {
			case 1:
				addCar();
				break;
			case 2:
				addBoat();
				break;
			case 3:
				addPlane();
				break;
			case 4:
				System.out.println(magazyn);
				magazyn.printUsers();
				break;
			default:
				if(b!=0){
				System.out.println("Brak takiej opcji, wybierz ponownie");
				break;
				}
			}
		/*}catch(NoSuchElementException e){
			System.out.println("Musisz podac cyfre");
		}*/
		if(b==0){
			return;
		}else{
			adminLoop(b);
		}
		//} while (b != 0);
		
	}
	public void userLoop(int c) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		//int c;
		//do {
		try{
			printUserOptions();
			c = sc.nextInt();
			switch (c) {
			case 1:
				System.out.println("wyswietlenie samochodow");
				break;
			case 2:
				System.out.println("wyswietlenie lodzi");
				break;
			case 3:
				System.out.println("wyswietlenie samolotow");
				break;
			default:
				if(c!=0){
				System.out.println("Brak takiej opcji, wybierz ponownie");
				break;
				}
			}
		}catch(NoSuchElementException e){
			System.out.println("Musisz podac same liczby");
		}
		if(c==0){
			return ;
		}else{
			userLoop(c);
		}
		//} while (c != 0);
	
	}

	public void addCar() {
		Samochod sam = reader.createCar();
		magazyn.dodajSamochod(sam);
	}

	public void addBoat() {
		Lodz lodz = reader.createBoat();
		magazyn.dodajLodz(lodz);
	}

	public void addPlane() {
		Samolot samo = reader.createPlane();
		magazyn.dodajSamolot(samo);
	}
	public void addUser(){
		data.User user=reader.createUser();
		 magazyn.dodajUzytkownika(user);
		
	}

	public void printStartOptions() {
		System.out.println("Wybierz opcje:");
		for (Start o : Start.values()) {
			System.out.println(o);
		}
	}

	public void printUserOptions() {
		System.out.println("Wybierz opcje:");
		for (User o : User.values()) {
			System.out.println(o);
		}
	}

	public void printAdminOptions() {
		System.out.println("Wybierz opcje:");
		for (Admin o : Admin.values()) {
			System.out.println(o);
		}
	}

	public enum Admin {
		EXIT(0, "-Wyjscie"), 
		ADD_CAR(1, "-Dodaj samochod"), 
		ADD_BOAT(2, "-Dodaj lodz"),
		ADD_PLANE(3,"-Dodaj samolot"), 
		TEST(4, "-wyswietl");

		private String description;
		private int value;

		Admin(int val, String desc) {
			this.description = desc;
			this.value = val;
		}

		@Override
		public String toString() {
			return value + " " + description;
		}

	}

	public enum Start {
		EXIT(0, "-Wyjscie"), 
		LOGIN(1, "-Zaloguj się"), 
		ADMIN(2, "-Zaloguj jako admin"),
		SIGN_UP(3,"-Zarejestruj sie");

		private String description;
		private int value;

		Start(int val, String desc) {
			this.description = desc;
			this.value = val;
		}

		@Override
		public String toString() {
			return value + " " + description;
		}
		
		public static Start wybor(int option)throws NoSuchElementException{
			Start result=null;
			try{
				result=Start.values()[option];
			}catch(ArrayIndexOutOfBoundsException e){
				throw new NoSuchElementException("Brak elementu");
			}
			return result;
			
		}

	}

	public enum User {
		EXIT(0, "-Wróć"),
		ADD_CAR(1, "-Wypozycz samochod"), 
		ADD_BOAT(2, "-Wypozycz łódz"), 
		ADD_PLANE(3,"-Wypozycz samolot"),
		TEST(4, "-wyswietl");

		private String description;
		private int value;

		User(int val, String desc) {
			this.description = desc;
			this.value = val;
		}

		@Override
		public String toString() {
			return value + " " + description;
		}

	}
}

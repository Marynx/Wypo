package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import data.Customer;
import data.Lodz;
import data.Magazyn;
import data.Samochod;
import data.Samolot;
import utils.DataReader;
import utils.FileManager;
import utils.MagazynUtils;

public class AppControl {

	private Magazyn magazyn;
	private DataReader reader;
	private Scanner sc;
	private FileManager fm;

	public AppControl() {
		reader = new DataReader();
		fm=new FileManager();
		sc = new Scanner(System.in);
		try{
			magazyn=fm.czytajDaneZMagazynu();
			System.out.println("Wczytano dane magazynu z pliku");
		}catch(ClassNotFoundException | IOException e){
			magazyn=new Magazyn();
			System.out.println("Utworzono nowa baze magazynu");
		}
	}

	public static String zalogowany = null;

	public void startLoop(int b) {

		// int b = 0;
		String admin = "admin";
		String adminPass = "admin";
		String in, pass = null;

		// do{

		try {
			printStartOptions();
			b = reader.getInt(sc);
			switch (b) {
			case 1:
				System.out.println("Podaj login:");
				in = sc.nextLine();
				/*
				 * System.out.println("Podaj haslo:"); pass = sc.nextLine();
				 */

				if (magazyn.check(in)) {
					System.out.println("Podaj haslo:");
					pass = sc.nextLine();
					if (pass.equals(magazyn.getUsers().get(in).getHaslo())) {
						System.out.println("Zalogowales sie jako " + magazyn.getUsers().get(in));
						zalogowany = in;
						userLoop(7);
					}
				} else {
					System.out.println("brak uzytkownika o danej nazwie");
				}

				break;
			case 2:
				System.out.println("Podaj login:");
				in = sc.nextLine();
				System.out.println("Podaj haslo:");
				pass = sc.nextLine();
				if (in.equals(admin) && pass.equals(adminPass)) {
					System.out.println("Zostałes zalogowany jako admin");
					adminLoop(7);
				} else {
					System.out.println("nie udalo ci sie zalogowac jako admin");

				}
				break;
			case 3:
				addUser();
				break;
			default:
				if (b != 0) {
					System.out.println("Brak takiej opcji, wybierz ponownie");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Wprowadz cyfre");
		} catch (NumberFormatException | NoSuchElementException e) {
			System.out.println("dziala");
		} /*
			 * catch(NullPointerException e){
			 * System.out.println("Brak uzytkownikow w bazie"); }
			 */

		if (b == 0) {
			sc.close();
			exit();
		} else {
			startLoop(b);
		}

		// }while (b != 0);

		sc.close();
	}

	public void adminLoop(int b) {

		// do {
		// try{
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
			magazyn.ilosc();
			System.out.println(magazyn);
			magazyn.printUsers();
			break;
		case 5:
			deleteCar();
			break;
		case 6:
			deleteBoat();
			break;
		case 7:
			deletePlane();
			break;
		default:
			if (b != 0) {
				System.out.println("Brak takiej opcji, wybierz ponownie");
				break;
			}
		}
		/*
		 * }catch(InputMismatchException e){
		 * System.out.println("Musisz podac cyfre");
		 * }catch(NumberFormatException e){
		 * System.out.println("Podano zle dane, nic nie dodano"); }
		 */
		if (b == 0) {

			return;
		} else {
			adminLoop(b);
		}
		// } while (b != 0);

	}

	public void userLoop(int c) {

		// int c;
		// do {
		try {
			printUserOptions();
			c = sc.nextInt();
			switch (c) {
			case 1:
				rentCar();
				break;
			case 2:
				rentBoat();
				break;
			case 3:
				rentPlane();
				break;
			case 4:
				wysWypozyczone();
				break;
			case 5:
				oddajPojazd();
				break;
			default:
				if (c != 0) {
					System.out.println("Brak takiej opcji, wybierz ponownie");
					break;
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Musisz podac same liczby");
		}
		if (c == 0) {

			return;
		} else {
			userLoop(c);
		}
		// } while (c != 0);

	}

	public void wyswietlSamochody() {
		MagazynUtils.printCars(magazyn);
	}

	public void wyswietlLodzie() {
		MagazynUtils.printBoats(magazyn);
	}

	public void wyswietlSamoloty() {
		MagazynUtils.printPlanes(magazyn);
	}

	public void addCar() {
		Samochod sam = reader.createCar(sc);
		magazyn.dodajSamochod(sam);
	}

	public void addBoat() {
		Lodz lodz = reader.createBoat(sc);
		magazyn.dodajLodz(lodz);
	}

	public void addPlane() {
		Samolot samo = reader.createPlane(sc);
		magazyn.dodajSamolot(samo);
	}

	public void addUser() {
		Customer cus = reader.createUser(sc);
		magazyn.dodajUzytkownika(cus);

	}

	public void deleteCar() {
		MagazynUtils.usunSamochod(magazyn, sc);
	}

	public void deleteBoat() {
		MagazynUtils.usunLodz(magazyn, sc);
	}

	public void deletePlane() {
		MagazynUtils.usunSamolot(magazyn, sc);
	}

	public void rentPlane() {
		Samolot sam = MagazynUtils.wypozyczSamolot(magazyn, sc);
		if(sam!=null){
		magazyn.getUsers().get(zalogowany).dodajPojazd(sam);
		}
		}

	public void rentCar() {
		Samochod sam = MagazynUtils.wypozyczSamochod(magazyn, sc);
		if(sam!=null){
		magazyn.getUsers().get(zalogowany).dodajPojazd(sam);
		}
		}

	public void rentBoat() {
		Lodz sam = MagazynUtils.wypozyczLodz(magazyn, sc);
		if(sam!=null){
		magazyn.getUsers().get(zalogowany).dodajPojazd(sam);
		}
		}

	public void wysWypozyczone() {
		magazyn.getUsers().get(zalogowany).wyswietlWypozyczone();
	}
	public void oddajPojazd(){
		MagazynUtils.oddajPojazd(magazyn.getUsers().get(zalogowany), sc);
	}
	public void exit(){
		fm.zapisMagazynDoPliku(magazyn);
		System.out.println("Do natępnego !");
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
		EXIT(0, "-Wyjscie"), ADD_CAR(1, "-Dodaj samochod"), ADD_BOAT(2, "-Dodaj lodz"), ADD_PLANE(3,
				"-Dodaj samolot"), TEST(4, "-wyswietl"), DELETE_CAR(5,
						"-Usun samochod"), DELETE_BOAT(6, "-Usun lodz"), DELETE_PLANE(7, "-Usun samolot");

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
		EXIT(0, "-Wyjscie"), LOGIN(1, "-Zaloguj się"), ADMIN(2, "-Zaloguj jako admin"), SIGN_UP(3, "-Zarejestruj sie");

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

		public static Start wybor(int option) throws NoSuchElementException {
			Start result = null;
			try {
				result = Start.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Brak elementu");
			}
			return result;

		}

	}

	public enum User {
		EXIT(0, "-Wróć"), ADD_CAR(1, "-Wypozycz samochod"), ADD_BOAT(2, "-Wypozycz łódz"),
 ADD_PLANE(3,"-Wypozycz samolot"), TEST(4, "-wyswietl wypozyczony pojazd"),RETURN(5,"-Zwroc pojazd");

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

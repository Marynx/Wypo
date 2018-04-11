package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Magazyn;

public class FileManager {
	public static final String FILE_NAME = "wypozyczalnia.txt";

	public void zapisMagazynDoPliku(Magazyn mag) {
		try (
				FileOutputStream fos = new FileOutputStream(FILE_NAME);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
			oos.writeObject(mag);
		} catch (FileNotFoundException e) {
			System.err.println("Nie odnaleziono pliku " + FILE_NAME);
		} catch (IOException e) {
			System.err.println("Błąd podczas zapisu danych do " + FILE_NAME);
		}
	}

	public Magazyn czytajDaneZMagazynu() throws FileNotFoundException, IOException, ClassNotFoundException {
		Magazyn magazyn = null;
		try (FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			magazyn = (Magazyn) ois.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("Nie odnaleziono pliku " + FILE_NAME);
			throw e;
		} catch (IOException e) {
			System.err.println("Blad podczas zapisu do pliku " + FILE_NAME);
			throw e;
		} catch (ClassNotFoundException e) {
			System.err.println("Nieprawidlowy format pliku");
			throw e;
		}
		return magazyn;
	}

}

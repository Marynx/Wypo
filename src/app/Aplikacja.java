package app;

import data.Lodz;
import data.Magazyn;
import data.Samochod;

public class Aplikacja {
	public static int wybor=1;
public static void main(String[] args) {
	/*Samochod s=new Samochod("audi", "trzy", 2, 44, "dss", "no");
	Lodz l=new Lodz("optima", "dwa", 2, 44, "dobry");
	Magazyn m=new Magazyn();
	m.dodajSamochod(s);
	m.dodajLodz(l);
	System.out.println(m);*/
	
	AppControl app=new AppControl();
	app.startLoop(7);
}
}

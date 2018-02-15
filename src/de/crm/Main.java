package de.crm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		//Ausgabe des Textes auf der Console
		System.out.println("----------------------------------------------");
		System.out.println("Johner Institut CRM");
		System.out.println("----------------------------------------------");
		System.out.println("Bitte waelen Sie eine der folgenden Optionen");
		System.out.println("");
		System.out.println("[1] Kunde erfassen");
		System.out.println("[2] Liste aller Kunden ausgeben");
			
		
		//Abfrage der Eingabe
		Scanner scanner = new Scanner(System.in);
		int auswahl = scanner.nextInt();
		
		if(auswahl == 1){
			
			//Abfrage der Eingabe undAusgabe auf der Console
			System.out.println("Bitte den Vor- und Nachnamen mit eingeben:");
			String name = scanner.next();
			
			//Speichern
			try {
				int menge = 0;
				Scanner filescanner = null;
				try {
					filescanner = new Scanner(new File("Kunden.txt"));
					while(filescanner.hasNext() && menge == 0){
						menge ++;
					}
					
				} catch (FileNotFoundException e) {
				}
				
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Kunden.txt", true)));
				if(menge != 0){writer.newLine();}
				writer.write(name);
				writer.close();
				
				System.out.println("Kunde wurde gespeichert. Hier ist die akltuelle Kundenliste:");
				System.out.println("");
		        auswahl = 2;
				
			} catch (FileNotFoundException e) {
				System.out.println("Kunde konnte nicht gespeichert werden!  Hier ist die akltuelle Kundenliste:");
				System.out.println("");
				 auswahl = 2;
			}
			
		}
		
				
		if(auswahl == 2){
			
			//Ausgeben der Namen
			Scanner filescanner = null;
			try {

				filescanner = new Scanner(new File("Kunden.txt"));
				
				int menge = 0;
				while(filescanner.hasNext()){
					System.out.println(filescanner.next());
					menge ++;
				}
				if(menge == 0){
					System.out.println("Enthält keine Einträge!");
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("Datei konnte nicht gefunden werden!");
				e.printStackTrace();
			}
		}
		
		
		
		if(auswahl != 1 && auswahl != 2){
			//Falls der Benutzer Unsinn eingibt
			System.out.println("Das ist keine gültige Eingabe!");
		}
		
		
		scanner.close();
		
		//Schlussnachricht
		System.out.println("");
		System.out.println("Das Programm endet hier, auf Wiedersehen!");
		
	}
	
}
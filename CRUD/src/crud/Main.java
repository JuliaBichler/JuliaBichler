package crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		DBManager db=new DBManager();
		
		System.out.println("Was möchten Sie machen?: Zahl eingeben");
		System.out.println("1	Kunde");
		System.out.println("2	Artikel");
		System.out.println("3	Adresse");
		
		String input = in.readLine();
		
		System.out.println(input);
		
		if(Integer.parseInt(input)==1) {

			System.out.println("1	Kunde anlegen");
			System.out.println("2	Kunde ändern");
			System.out.println("3	Kunde löschen");
			System.out.println("4	Kunde ausgeben");
			
			input = in.readLine();
			
			if(Integer.parseInt(input)==1) {
				DBManager.createKunde();
			}
			else if(Integer.parseInt(input)==2){

				System.out.println("1	Vorangiger Titeln");
				System.out.println("2	Vorname ändern");
				System.out.println("3	Nachname ändern");
				System.out.println("4	Nachgestellten Titel ändern");
			
				BufferedReader inKä = new BufferedReader(new InputStreamReader(System.in));
				String inputKä = inKä.readLine();
				
				if(Integer.parseInt(inputKä)==1) {DBManager.updateKundeTitelV();}
				else if(Integer.parseInt(inputKä)==2) {DBManager.updateVorname();}
				else if(Integer.parseInt(inputKä)==3) {DBManager.updateNachname();}
				else if(Integer.parseInt(inputKä)==4) {DBManager.updateKundeTitelN();}
				else {System.out.println("Error 404: Fehler bei Kundenänderung");}
			}
			else if(Integer.parseInt(input)==3) {DBManager.deleteKunde();}
			else if(Integer.parseInt(input)==4) {DBManager.readKunde();}
			else {System.out.println("Error 404: Not found");}
		}
		else if(Integer.parseInt(input)==2) {
			System.out.println("1	Artikel anlegen");
			System.out.println("2	Artikel ändern");
			System.out.println("3	Artikel löschen");
			System.out.println("4	Artikel ausgeben");
			
			input = in.readLine();
			
			if(Integer.parseInt(input)==1) {DBManager.createArtikel();}
			else if(Integer.parseInt(input)==2) {
				
			}
			else if(Integer.parseInt(input)==3) {DBManager.deleteArtikel();}
			else if(Integer.parseInt(input)==4) {DBManager.readArtikel();}
			else {System.out.println("Error 404: Bei den Artikeln");}
		}
		else if(Integer.parseInt(input)==3) {
			System.out.println("1	Adresse ändern");
			System.out.println("2	Adresse ausgeben");
			
			input = in.readLine();
			
			if(Integer.parseInt(input)==1) {
				System.out.println("1	Straße ändern");
				System.out.println("2	PLZ ändern");
				System.out.println("3	Stadt ändern");
				System.out.println("4	Hausnummer ändern");
				
				if(Integer.parseInt(input)==1) {DBManager.updateAdresseSTR();}
				else if(Integer.parseInt(input)==2) {DBManager.updateAdressePLZ();}
				else if(Integer.parseInt(input)==3) {DBManager.updateAdresseStadt();}
				else if(Integer.parseInt(input)==4) {DBManager.updateAdresseHNR();}
				else {System.out.println("Error 404: Bei Änderungen der Adresse");}
			}
			else if(Integer.parseInt(input)==2) {DBManager.readAdresse();}
			else {System.out.println("Error 404: Bei den Adressen");}
		}
		else {System.out.println("Error 404: Not found");}
	}
}

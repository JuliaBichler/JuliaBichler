package crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		DBManager db=new DBManager();
		
		System.out.println("Was m�chten Sie machen?: Zahl eingeben");
		System.out.println("1	Kunde");
		System.out.println("2	Artikel");
		System.out.println("3	Adresse");
		
		String input = in.readLine();
		
		System.out.println(input);
		
		if(Integer.parseInt(input)==1) {

			System.out.println("1	Kunde anlegen");
			System.out.println("2	Kunde �ndern");
			System.out.println("3	Kunde l�schen");
			System.out.println("4	Kunde ausgeben");
			
			input = in.readLine();
			
			if(Integer.parseInt(input)==1) {
				DBManager.createKunde();
			}
			else if(Integer.parseInt(input)==2){

				System.out.println("1	Vorangiger Titeln");
				System.out.println("2	Vorname �ndern");
				System.out.println("3	Nachname �ndern");
				System.out.println("4	Nachgestellten Titel �ndern");
			
				BufferedReader inK� = new BufferedReader(new InputStreamReader(System.in));
				String inputK� = inK�.readLine();
				
				if(Integer.parseInt(inputK�)==1) {DBManager.updateKundeTitelV();}
				else if(Integer.parseInt(inputK�)==2) {DBManager.updateVorname();}
				else if(Integer.parseInt(inputK�)==3) {DBManager.updateNachname();}
				else if(Integer.parseInt(inputK�)==4) {DBManager.updateKundeTitelN();}
				else {System.out.println("Error 404: Fehler bei Kunden�nderung");}
			}
			else if(Integer.parseInt(input)==3) {DBManager.deleteKunde();}
			else if(Integer.parseInt(input)==4) {DBManager.readKunde();}
			else {System.out.println("Error 404: Not found");}
		}
		else if(Integer.parseInt(input)==2) {
			System.out.println("1	Artikel anlegen");
			System.out.println("2	Artikel �ndern");
			System.out.println("3	Artikel l�schen");
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
			System.out.println("1	Adresse �ndern");
			System.out.println("2	Adresse ausgeben");
			
			input = in.readLine();
			
			if(Integer.parseInt(input)==1) {
				System.out.println("1	Stra�e �ndern");
				System.out.println("2	PLZ �ndern");
				System.out.println("3	Stadt �ndern");
				System.out.println("4	Hausnummer �ndern");
				
				if(Integer.parseInt(input)==1) {DBManager.updateAdresseSTR();}
				else if(Integer.parseInt(input)==2) {DBManager.updateAdressePLZ();}
				else if(Integer.parseInt(input)==3) {DBManager.updateAdresseStadt();}
				else if(Integer.parseInt(input)==4) {DBManager.updateAdresseHNR();}
				else {System.out.println("Error 404: Bei �nderungen der Adresse");}
			}
			else if(Integer.parseInt(input)==2) {DBManager.readAdresse();}
			else {System.out.println("Error 404: Bei den Adressen");}
		}
		else {System.out.println("Error 404: Not found");}
	}
}

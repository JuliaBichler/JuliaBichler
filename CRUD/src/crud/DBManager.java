package crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBManager {
	
	static Connection conn;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static String input;
	
	public DBManager() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/infidb", "postgres", "1234");
	}
	public static enum bestellung
	{
		kunden_ID,
		adresse_rechnung_id,
		adresse_liefer_id
	}
	
	/*----------------------------------------------------------------------------------*/
	
	public static void createKunde() throws SQLException, IOException
	{
		System.out.println("Vorangestellter Titel:");
		String titelV = in.readLine();
		System.out.println("Vorname:");
		String firstname = in.readLine();
		System.out.println("Nachname:");
		String lastname = in.readLine();
		System.out.println("Nachgestellter Titel:");
		String titelN = in.readLine();
		

		String sql = "INSERT INTO kunde (titelV, vorname, nachname, titelN) VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, titelV);
		stmt.setString(2, firstname);
		stmt.setString(3, lastname);
		stmt.setString(4, titelN);
		
		stmt.execute();
		stmt.close();
		System.out.println("Kunde angelegt");
		DBManager.createAdresse();
	}
	
	public static void readKunde() throws SQLException, IOException {
		
		System.out.println("Welchen Kunden möchen Sie ansehen: kundenid:");
		input = in.readLine();

		System.out.printf("%-15s %-15s \t%s \t%s \t%s\n","ID","titelV", "firstname","lastname","titelN");
		String sql = "SELECT kunden_ID, titelV, vorname, nachname, titelN FROM kunde where kunden_ID = "+input;
		PreparedStatement prtstmt = conn.prepareStatement(sql);
		ResultSet rg = prtstmt.executeQuery();	
		//ResultSet rg1 = prtstmt.executeQuery();	
		
		while(rg.next()) {
			String ID =rg.getString("kunden_ID");
			String titelV = rg.getString("titelV");
			String firstname = rg.getString("vorname");
			String lastname = rg.getString("nachname");
			String titelN = rg.getString("titelN");
			System.out.printf("%-15s %-15s \t%s \t%-15s \t%s\n",ID,titelV, firstname,lastname,titelN);
		}
		prtstmt.close();
		rg.close();
	}
	
	public static void getKunden(int[] id) throws SQLException {
		
		System.out.printf("%-15s %-15s \t%s \t%s \t%s\n","ID","titelV", "firstname","lastname","titelN");
		for (int i = 0; i < id.length; i++) {
			String sql = "SELECT * FROM kunde where kunden_ID = "+id[i];
			PreparedStatement prtstmt = conn.prepareStatement(sql);
			ResultSet rg = prtstmt.executeQuery();
			
			while(rg.next()) {
				String ID =rg.getString("kunden_ID");
				String titelV = rg.getString("titelV");
				String firstname = rg.getString("vorname");
				String lastname = rg.getString("nachname");
				String titelN = rg.getString("titelN");
				System.out.printf("%-15s %-15s \t%s \t\t%s \t%-10s\n",ID,titelV, firstname,lastname,titelN);
			}
			prtstmt.close();
			rg.close();
		}
	}
	
	public static void deleteKunde() throws SQLException, IOException{
		System.out.println("Welchen Kunden möchen Sie löschen, kundenid:");
		input = in.readLine();
		String sql = "DELETE FROM kunde WHERE kunden_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Kunde wurde entfernt");
	}
	
	public static void updateKundeTitelV() throws SQLException, IOException {
		
		System.out.println("Neuer vorangestellter Titel:");
		String inputTV = in.readLine();
		System.out.println("Kundenid:");
		String inputID = in.readLine();
		String sql = "UPDATE kunde SET titelV='"+inputTV+"' WHERE kunden_ID = "+ inputID;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("TitelV für "+inputID+" wurde geändert");
	}
	
	public static void updateKundeTitelN() throws SQLException, IOException {
		System.out.println("Neuer nachgestellter Titel:");
		String titel = in.readLine();
		System.out.println("Kundenid:");
		String inputID = in.readLine();
		String sql = "UPDATE kunde SET titelN='"+titel+"' WHERE kunden_ID = "+ inputID;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("TitelN für "+inputID+" wurde geändert");
	}
	
	public static void updateVorname() throws SQLException, IOException {
		System.out.println("Neuer Vorname:");
		String vorname = in.readLine();
		System.out.println("Kundenid:");
		String inputID = in.readLine();
		String sql = "UPDATE kunde SET vorname='"+vorname+"' WHERE kunden_ID = "+ inputID;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Vorname für "+inputID+" wurde geändert");
	}
	
	public static void updateNachname() throws SQLException, IOException {
		System.out.println("Neuer Nachname:");
		String nachname = in.readLine();
		System.out.println("Kundenid:");
		String inputID = in.readLine();
		String sql = "UPDATE kunde SET nachname='"+nachname+"' WHERE kunden_ID = "+ inputID;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Nachname für "+inputID+" wurde geändert");
	}
	
	/*----------------------------------------------------------------------------------*/
	
	public static void createArtikel() throws SQLException, IOException
	{
		System.out.println("Artikelname:");
		input = in.readLine();
		System.out.println("Preis");
		String input1 = in.readLine();
		String sql = "INSERT INTO artikel (name,preis) VALUES (?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, input);
		stmt.setString(2, input1);
		
		stmt.execute();
		stmt.close();
		System.out.println("Artikel angelegt");	
	}
	
	public static void readArtikel() throws SQLException, IOException {
		
		System.out.println("Welcher Artikel soll gelöscht werden?");
		input = in.readLine();

		System.out.printf("%-15s %-15s \t%s\n","ID","Name", "Preis");
		String sql = "SELECT artikel_ID, name, preis FROM artikel where artikel_ID = "+input;
		PreparedStatement prtstmt = conn.prepareStatement(sql);
		ResultSet rg = prtstmt.executeQuery();
		
		while(rg.next()) {
			String ID =rg.getString("artikel_ID");
			String name = rg.getString("name");
			String preis = rg.getString("preis");
			System.out.printf("%-15s %-15s \t%s€\n",ID,name, preis);
		}
		prtstmt.close();
		rg.close();
	}
	
	public static void getArtikel(int[] id) throws SQLException {
		
		System.out.printf("%-15s %-15s \t%s\n","ID","Name", "Preis");
		for (int i = 0; i < id.length; i++) {
			String sql = "SELECT artikel_ID, name, preis FROM artikel where artikel_ID = "+id[i];
			PreparedStatement prtstmt = conn.prepareStatement(sql);
			ResultSet rg = prtstmt.executeQuery();
			
			while(rg.next()) {
				String ID =rg.getString("artikel_ID");
				String name = rg.getString("name");
				String preis = rg.getString("preis");
				System.out.printf("%-15s %-15s \t%s€\n",ID,name, preis);
			}
			prtstmt.close();
			rg.close();
		}
	}
	
	public static void deleteArtikel() throws SQLException, IOException{
		System.out.println("Welcher Artikel soll gelöscht werden?");
		input = in.readLine();
		String sql = "DELETE FROM artikel WHERE artikel_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		stmt.close();
		System.out.println("Artikel wurde entfernt");
	}
	
	public static void updateArtikelName(int artikelid, String name) throws SQLException {
		String sql = "UPDATE artikel SET name='"+name+"' WHERE artikel_ID = "+ artikelid;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Artikelname für "+artikelid+" wurde geändert");
	}
	
	public static void updateArtikelPreis(int artikelid, int preis) throws SQLException {
		String sql = "UPDATE artikel SET preis='"+preis+"' WHERE artikel_ID = "+ artikelid;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Artikelpreis für "+artikelid+" wurde geändert");
		
	}
	
	/*----------------------------------------------------------------------------------*/
	
	public static void createAdresse() throws SQLException, IOException
	{
		System.out.println("Stadt:");
		String city = in.readLine();
		System.out.println("Postleitzahl:");
		String plz = in.readLine();
		System.out.println("Straße:");
		String street = in.readLine();
		System.out.println("Hausnummer:");
		String hausnr = in.readLine();
		
		String sql = "INSERT INTO adresse (hausnr,stadt,plz,strasse) VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, hausnr);
		stmt.setString(2, city);
		stmt.setString(3, plz);
		stmt.setString(4, street);
		
		stmt.execute();
		stmt.close();
		System.out.println("Adresse angelegt");	
	}
	
	public static void readAdresse() throws SQLException, IOException {
		
		System.out.println("Artikelid:");
		input = in.readLine();


		System.out.printf("%-5s %-5s \t%15s \t%s \t%15s\n","ID","HNR", "Stadt"," Plz", "Strasse");
		String sql = "SELECT adresse_ID, hausnr, stadt, plz, strasse FROM adresse where adresse_ID = "+input;
		PreparedStatement prtstmt = conn.prepareStatement(sql);
		ResultSet rg = prtstmt.executeQuery();
		
		while(rg.next()) {
			String ID =rg.getString("adresse_ID");
			String name = rg.getString("hausnr");
			String stadt = rg.getString("stadt");
			String plz = rg.getString("plz");
			String strasse = rg.getString("strasse");
			System.out.printf("%-5s %-5s \t%15s \t%s \t%15s\n",ID,name, stadt, plz, strasse);
		}
		prtstmt.close();
		rg.close();
	}
	
	public static void getAdresse(int[] id) throws SQLException {
		
		System.out.printf("%-5s %-5s \t%15s \t%s \t%15s\n","ID","HNR", "Stadt"," Plz", "Strasse");
		for (int i = 0; i < id.length; i++) {
			String sql = "SELECT * FROM adresse where adresse_ID = "+id[i];
			PreparedStatement prtstmt = conn.prepareStatement(sql);
			ResultSet rg = prtstmt.executeQuery();
			
			while(rg.next()) {
				String ID =rg.getString("adresse_ID");
				String name = rg.getString("hausnr");
				String stadt = rg.getString("stadt");
				String plz = rg.getString("plz");
				String strasse = rg.getString("strasse");
				System.out.printf("%-5s %-5s \t%15s \t%s \t%15s\n",ID,name, stadt, plz, strasse);
			}
			prtstmt.close();
			rg.close();
		}
	}

	public static void deleteAdresse(int adressid) throws SQLException{
		String sql = "DELETE FROM adresse WHERE adresse_ID = "+ adressid;

		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		stmt.close();
		System.out.println("Adresse wurde entfernt");
	}
	
	public static void updateAdresseHNR() throws SQLException, IOException {
		
		System.out.println("Adressid:");
		input = in.readLine();
		System.out.println("Hausnummer:");
		String input1 = in.readLine();
		String sql = "UPDATE adresse SET hausnr='"+input1+"' WHERE adresse_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public static void updateAdresseStadt() throws SQLException, IOException {
		
		System.out.println("Adressid:");
		input = in.readLine();
		System.out.println("Stadt:");
		String input1 = in.readLine();

		String sql = "UPDATE adresse SET stadt='"+input1+"' WHERE adresse_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();

	}
	
	public static void updateAdressePLZ() throws SQLException, IOException {
		
		System.out.println("Adressid:");
		input = in.readLine();
		System.out.println("PLZ:");
		String input1 = in.readLine();
		
		String sql = "UPDATE adresse SET plz='"+input1+"' WHERE adresse_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();

	}
	
	public static void updateAdresseSTR() throws SQLException, IOException {
		
		System.out.println("Adressid:");
		input = in.readLine();
		System.out.println("Straße:");
		String input1 = in.readLine();
		
		String sql = "UPDATE adresse SET strasse='"+input1+"' WHERE adresse_ID = "+ input;

		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		System.out.println("Strasse für "+input+" wurde geändert");
	}
	
	/*-----------------------------------------------------------------------------------*/

	public void createBestellung(int kunde_id, int adresse_rechnung_id, int adresse_liefer_id) throws SQLException
	  {
	    String sql = "INSERT INTO bestellung(kunde_id, adresse_rechnung_id, adresse_liefer_id) VALUES(?,?,?)";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,kunde_id);
	    stmt.setInt(2,adresse_rechnung_id);
	    stmt.setInt(3,adresse_liefer_id);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }
	  
	public void deleteBestellung(int id) throws SQLException
	  {
	    String sql = "DELETE FROM bestellung WHERE bestell_id=?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,id);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }
	  
	public ArrayList<Bestellung> getBestellung()throws SQLException
	  {
	    ArrayList<Bestellung> bestellungen = new ArrayList<>();
	    
	    String sql = "SELECT * FROM bestellung";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();
	    
	    System.out.printf("| %20s | %20s | %20s | %20s |\n","bestell_id", "kunde_id", "adresse_rechnung_id", "adresse_liefer_id");
	    
	    while(rs.next())
	    {
	      int id = rs.getInt("bestell_id");
	      int kunde_id = rs.getInt("kunde_id");
	      int adresse_rechnung_id = rs.getInt("adresse_rechnung_id");
	      int adresse_liefer_id = rs.getInt("adresse_liefer_id");

	      
	      
	      System.out.printf("| %20s | %20s | %20s | %20s |\n",id, kunde_id, adresse_rechnung_id, adresse_liefer_id);
	      
	      Bestellung a = new Bestellung(id,kunde_id,adresse_rechnung_id,adresse_liefer_id);
	      bestellungen.add(a);
	    }
	    
	    rs.close();
	    stmt.close();
	    return bestellungen;
	  }
	  
	public void updateBestellung(bestellung bestellungEnum, int value, int adresse_id)throws SQLException
	  {
	    String sql = "UPDATE bestellung SET "+bestellungEnum+" = ? WHERE bestell_id=?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,value);
	    stmt.setInt(2,adresse_id);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }
		
			  
	/*-----------------------------------------------------------------------------------*/

	public void addArtikeltoBestellung(int bestell_id, int artikel_id, int menge) throws SQLException
	  {
	    String sql = "INSERT INTO bestellung_artikel(bestell_id, artikel_id, menge) VALUES(?,?,?)";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,bestell_id);
	    stmt.setInt(2,artikel_id);
	    stmt.setInt(3,menge);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }
			  
	public void deleteArtikelfromBestellung(int bestell_id, int artikel_id) throws SQLException
	  {
	    String sql = "DELETE FROM bestellung_artikel WHERE bestell_id=? AND artikel_id=?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,bestell_id);
	    stmt.setInt(2,artikel_id);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }
			  
	public ArrayList<Bestellung_Artikel> getArtikelBestellung()throws SQLException
	  {
	    ArrayList<Bestellung_Artikel> artikelbestellungen = new ArrayList<>();
	    
	    String sql = "SELECT * FROM Bestellung_Artikel";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();
	    
	    System.out.printf("| %20s | %20s | %20s |\n","bestell_id", "artikel_id", "menge");
	    
	    while(rs.next())
	    {
	      int bestell_id = rs.getInt("bestell_id");
	      int artikel_id = rs.getInt("artikel_id");
	      int menge = rs.getInt("menge");

	System.out.printf("| %20s | %20s | %20s |\n",bestell_id, artikel_id, menge);
	      
	      Bestellung_Artikel a = new Bestellung_Artikel(bestell_id,artikel_id,menge);
	      artikelbestellungen.add(a);
	    }
	    
	    rs.close();
	    stmt.close();
	    return artikelbestellungen;
	  }
			  
	public void updateBestellungArtikelMenge(int value, int bestell_id, int artikel_id)throws SQLException
	  {
	    String sql = "UPDATE bestellung_artikel SET menge = ? WHERE bestell_id=? AND artikel_id=?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1,value);
	    stmt.setInt(2,bestell_id);
	    stmt.setInt(3,artikel_id);
	    
	    stmt.executeUpdate();
	    stmt.close();
	  }

	public static void bestellungErstellen() throws IOException
	  {
	    int kunden_id=0;
	    int adresse_rechnung_id=0;
	    int adresse_liefer_id;
	    
	    Scanner scan = new Scanner(System.in);
	    
	    do
	    { 
	      try
	      {
	        System.out.print("Kunden ID: "); kunden_id = scan.nextInt();
	        System.out.print("Liefer-Adresse ID: "); adresse_rechnung_id = scan.nextInt();
	        System.out.print("Liefer-Rechnung ID: "); adresse_liefer_id = scan.nextInt();
	      }catch(InputMismatchException e)
	      {
	        System.out.println("Fehler! Bitte versuchen Sie es erneut");
	        scan.next();
	        continue;
	      }
	      System.out.flush(); 
	      break;
	    }while(true);
	    
	    try
	    {
	      DBManager db=new DBManager();
	      db.createBestellung(kunden_id, adresse_rechnung_id, adresse_liefer_id);
	      conn.close();
	      
	    } catch (ClassNotFoundException | SQLException e)
	    {
	      System.out.println("Fehler Bestellung konnte nicht gespeichert werden");
	    }
	    
	    scan.close();
	  }

	public static void bestellungBearbeiten() throws IOException
	  {
	    String id;
	    int value=0;
	    DBManager.bestellung bestellungEnum = null;
	    
	    Scanner scan = new Scanner(System.in);
	    
	    do
	    {

	      System.out.println("Bestellung Bearbeiten");
	      
	      System.out.print("Bestell_iD: ");
	      id = scan.next();
	      
	      
	      try
	      {

	    	System.out.print("Attribut angeben (kunde_id, adresse_rechnung_id, adresse_liefer_id): ");
	        bestellungEnum = DBManager.bestellung.valueOf(scan.next().toUpperCase());
	        System.out.print("Neuer Wert: ");
	        value = scan.nextInt();
	        
	      }
	      catch(IllegalArgumentException e)
	      {
	        System.out.println("Falsche Angabe");
	        continue;
	      }
	      catch(InputMismatchException a)
	      {
	        System.out.println("Fehlerhafte Eingabe. Eingabe ist eine Zahl.");
	        scan.next();
	        continue;
	      }
	      
	      System.out.flush(); 
	    }while(!id.matches("[0-9]+") || bestellungEnum==null);
	    
	    try
	    {
	      DBManager db=new DBManager();
	      db.updateBestellung(bestellungEnum, value, Integer.valueOf(id));
	      conn.close();
	      
	    } catch (ClassNotFoundException | SQLException e)
	    {
	      System.out.println("Fehler beim Bearbeiten aufgetreten.");
	    }
	    scan.close();
	  }
	
	public static void artikeltoBestellung() throws IOException
	  {
	    int bestell_id=0;
	    int artikel_id=0;
	    int menge=0;
	    
	    Scanner scan = new Scanner(System.in);
	    
	    do
	    {

	      System.out.println("Artikel zu Bestellung hinzufügen");
	     
	      try
	      {
	        System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
	        System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
	        System.out.print("Menge: "); menge = scan.nextInt();
	      }catch(InputMismatchException e)
	      {
	        System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
	        scan.next();
	        continue;
	      }
	      System.out.flush(); 
	      break;
	    }while(true);
	    
	    try
	    {
	      DBManager db=new DBManager();
	      db.addArtikeltoBestellung(bestell_id, artikel_id, menge);
	      conn.close();
	      
	    } catch (ClassNotFoundException | SQLException e)
	    {
	      System.out.println("Fehler beim Erstellen aufgetreten.");
	      e.printStackTrace();
	    }
	    
	    scan.close();
	  }

	public static void bestellungArtikelLöschen() throws IOException
	  {
		String selector;
	    int bestell_id=0;
	    int artikel_id=0;
	    Scanner scan = new Scanner(System.in);
	    
	    do
	    {

	      System.out.println("Artikel von Bestellung löschen");
	      selector=scan.next();
	      try
	      {
	        System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
	        System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
	      }catch(InputMismatchException e)
	      {
	        System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
	        scan.next();
	        continue;
	      }
	      System.out.flush(); 
	      break;
	    }while(!selector.matches("[0-9]+"));
	    
	    try
	    {
	      DBManager db=new DBManager();
	      db.deleteArtikelfromBestellung(bestell_id, artikel_id);
	      conn.close();
	      
	    } catch (ClassNotFoundException | SQLException e)
	    {
	      System.out.println("Fehler beim Löschen aufgetreten.");
	      e.printStackTrace();
	    }
	    
	    scan.close();
	  }
			 
	public static void bestellungArtikelBearbeiten() throws IOException
	  {
	    String selector;
	    int bestell_id=0;
	    int artikel_id=0;
	    int value=0;
	    
	    Scanner scan = new Scanner(System.in);
	    
	    do
	    {
	      System.out.println("--------------------------------------");
	      System.out.println("Artikel von Bestellung bearbeiten");
	      System.out.println("--------------------------------------");
	      
	      System.out.print("Infos zu Bestellungen/Bestellten Artikeln mit Befehl \"show\" | \"w\" um Fortzufahren: ");
	      selector = scan.next();

	      
	      try
	      {
	        System.out.print("Bestell ID: "); bestell_id = scan.nextInt();
	        System.out.print("Artikel ID: "); artikel_id = scan.nextInt();
	        System.out.print("Neue Menge: "); value = scan.nextInt();
	      }catch(InputMismatchException e)
	      {
	        System.out.println("Fehlerhafte Eingabe. Es dürfen nur Zahlen eingegeben werden");
	        scan.next();
	        continue;
	      }
	      System.out.flush(); 
	      break;
	    }while(!selector.matches("[0-9]+"));
	    
	    try
	    {
	      DBManager db=new DBManager();
	      db.updateBestellungArtikelMenge(value, bestell_id, artikel_id);
	      conn.close();
	      
	    } catch (ClassNotFoundException | SQLException e)
	    {
	      System.out.println("Fehler beim bearbeiten aufgetreten.");
	      e.printStackTrace();
	    }
	    
	    scan.close();
	  }	
			  
			

	
	

}

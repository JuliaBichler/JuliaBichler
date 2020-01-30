package crud;

public class Adresse 
{
	private int adresse_id;
	private String stadt;
	private String strasse;
	private String hausnr;
	private int plz;
	
	public Adresse(int adresse_id, String stadt, String strasse, String hnr, int plz) 
	{
		this.adresse_id = adresse_id;
		this.stadt = stadt;
		this.strasse = strasse;
		this.hausnr = hnr;
		this.plz = plz;
	}
	
	public int getAdresse_id(){return adresse_id;}
	public void setAdresse_id(int adresse_id){this.adresse_id = adresse_id;}
	public String getStadt(){return stadt;}
	public void setStadt(String stadt){this.stadt = stadt;}
	public String getStrasse(){return strasse;}
	public void setStrasse(String strasse){this.strasse = strasse;}
	public String getHnr(){return hausnr;}
	public void setHnr(String hnr){this.hausnr = hnr;}
	public int getPlz(){return plz;}
	public void setPlz(int plz){this.plz = plz;}
}

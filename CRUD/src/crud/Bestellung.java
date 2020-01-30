package crud;

public class Bestellung {

	
	private int bestell_id;
	private int kunden_id;
	private int adresse_rechnung_id;
	private int adresse_liefer_id;
	
	public Bestellung(int bestell_id,int kunden_id,int adresse_rechnung_id,int adresse_liefer_id) {
		this.bestell_id = bestell_id;
		this.kunden_id = kunden_id;
		this.adresse_rechnung_id = adresse_rechnung_id;
		this.adresse_liefer_id = adresse_liefer_id;
	}
	
	public void setAdresse_liefer_id(int adresse_liefer_id) {
		this.adresse_liefer_id = adresse_liefer_id;
	}
	public void setAdresse_rechnung_id(int adresse_rechnung_id) {
		this.adresse_rechnung_id = adresse_rechnung_id;
	}
	public void setBestell_id(int bestell_id) {
		this.bestell_id = bestell_id;
	}
	public void setKunden_id(int kunden_id) {
		this.kunden_id = kunden_id;
	}
	public int getAdresse_liefer_id() {
		return adresse_liefer_id;
	}
	public int getAdresse_rechnung_id() {
		return adresse_rechnung_id;
	}
	public int getBestell_id() {
		return bestell_id;
	}
	public int getKunden_id() {
		return kunden_id;
	}
}

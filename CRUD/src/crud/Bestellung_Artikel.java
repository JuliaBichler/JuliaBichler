package crud;

public class Bestellung_Artikel {

	private int bestell_id;
	private int artikel_id;
	private int menge;
	
	public Bestellung_Artikel(int bestell_id, int artikel_id, int menge) {
		this.bestell_id=bestell_id;
		this.artikel_id=artikel_id;
		this.menge=menge;
	}
	
	public void setArtikel_id(int artikel_id) {
		this.artikel_id = artikel_id;
	}
	public void setBestell_id(int bestell_id) {
		this.bestell_id = bestell_id;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	public int getArtikel_id() {
		return artikel_id;
	}
	public int getBestell_id() {
		return bestell_id;
	}
	public int getMenge() {
		return menge;
	}
}

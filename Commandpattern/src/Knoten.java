public class Knoten {
	
	private static String data;
	private static String menge;
	private Knoten next;

	public Knoten(String data, String menge, Knoten next) {
		Knoten.data = data;
		Knoten.menge = menge;
		this.next = next;
	}
	
	public static String getData() {
		return data;
	}

	public void setData(String data) {
		Knoten.data = data;
	}
	
	public Knoten getNext() {
		return next;
	}
	
	public static String getMenge() {
		return menge;
	}
	
	public void setMenge(String menge) {
		Knoten.menge = menge;
	}
}

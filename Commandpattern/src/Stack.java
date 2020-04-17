public class Stack{
	
	private Knoten obersterKnoten = null;

	public void push(String name, String menge) {
		Knoten knoten = new Knoten(name,menge,obersterKnoten);
		obersterKnoten = knoten;
	}
	
	public void pop() {
		String daten = obersterKnoten.getData();	
		String menge = obersterKnoten.getMenge();
		
		obersterKnoten = obersterKnoten.getNext();
		System.out.println("Letzte Aktion "+daten+" "+menge+" wurde rückgängig gemacht");
	}
}

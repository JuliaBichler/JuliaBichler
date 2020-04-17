/*
 * Stack Tutorial
 * http://www.codeadventurer.de/?p=2388
 */
public class Main {

	public static void main(String[] args) {
		Lager l = new Lager();
		
		Auftrag einlagern = new Einlagern(l);
		Auftrag auslagern = new Auslagern(l);
		
		Eingabe eingabe=new Eingabe();
		eingabe.register("ein", einlagern);
		eingabe.register("aus", auslagern);
		
		eingabe.execute("ein");
		eingabe.execute("ein");
		eingabe.undo();
		eingabe.execute("aus");
		eingabe.redo();
		
	}

}

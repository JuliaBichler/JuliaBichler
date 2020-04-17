import java.util.HashMap;
import java.util.Scanner;

public class Eingabe {

	private String name;
	private String menge;
	Stack stack = new Stack();
	private String ln;
	private String lm;
	Auftrag lcommand;
	
	private final HashMap<String, Auftrag> commandMap = new HashMap<>();
    
    public void register(String commandName, Auftrag command) {
        commandMap.put(commandName, command);
    } 
    
    public void execute(String commandName) {
        Auftrag command = commandMap.get(commandName);
        lcommand=command;
        if (command == null) {
            throw new IllegalStateException("Kein Befehl bekannt mit:" + commandName);
        }
        eingabe();
        command.execute(name, menge);
        stack.push(name, menge);
    }
    
    public void undo() {
    	ln=Knoten.getData();
    	lm=Knoten.getMenge();
    	stack.pop();
    }
    
    public void redo() {
    	lcommand.execute(ln, lm);
    	System.out.println("Folgender Artikel "+ln+" "+lm+" wurde wieder hinzugefügt");
    }
    
    public void eingabe() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Artikelbezeichnung: ");
        this.name = sc.next();
        System.out.println("Menge: ");
        this.menge = sc.next();
    }
}

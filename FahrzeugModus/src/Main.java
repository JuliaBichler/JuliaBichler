enum Pedal {
    LOW,
    MEDIUM,
    HIGH
}

public class Main {
	
    public static void main(String[] args) {
    	
    Fahrzeug fahrzeug = new Fahrzeug();
    fahrzeug.pedal(Pedal.LOW);
    fahrzeug.pedal(Pedal.HIGH);
    }
}

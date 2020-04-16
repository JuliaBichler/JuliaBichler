public class Fahrzeug {

    private IFahrzeug nachricht;
    private IFahrzeug display;
    private Pedal pedal;

    public Fahrzeug(){
        this.nachricht = new Nachricht();
        this.display = new Display();
    }

    public void pedal(Pedal p){
        switch(p) {
            case LOW:
                setPedalstellung(p);
                nachricht.reset();
                display.reset();
                System.out.println("Pedal: "+p);
                break;

            case MEDIUM:
                setPedalstellung(p);
                nachricht.reset();
                display.reset();
                System.out.println("Pedal: "+p);
                break;

            case HIGH:
                setPedalstellung(p);
                System.out.println("Pedal: "+p);
                nachricht.warn();
                display.warn();
                break;
        }
    }

    public void getPedalstellung(){
        System.out.println(this.pedal);
    }

    public void setPedalstellung(Pedal p){
        this.pedal = p;
    }
}

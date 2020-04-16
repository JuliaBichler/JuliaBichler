public class Display implements IFahrzeug {

    private String displaytext;
    private String textfarbe;

    public Display(){
        this.displaytext = "Keine Fehler";
        this.textfarbe = "GRÜN";
    }
    public void reset(){
        setDisplaytext("Keine Fehler");
        setTextfarbe("GRÜN");
        System.out.println(displaytext);
    }
    public void warn(){
        setTextfarbe("ROT");
        setDisplaytext("DREHZAHL ZU HOCH, BITTE GESCHWINDIGKEIT VERRINGERN");
        System.out.println(displaytext);
    }

    public String getDisplaytext() {
        return displaytext;
    }

    public void setDisplaytext(String displaytext) {
        this.displaytext = displaytext;
    }

    public String getTextfarbe() {
        return textfarbe;
    }

    public void setTextfarbe(String textfarbe) {
        this.textfarbe = textfarbe;
    }
}

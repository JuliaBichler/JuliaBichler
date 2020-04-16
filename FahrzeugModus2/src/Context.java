public class Context {

    private Modus sportmodus;
    private Modus standardmodus;

    private float v;
    private int kW;
    private boolean isTurbo;


    public Context(){
        sportmodus = new Sportmodus();
        standardmodus = new Standardmodus();
    }

    private void executeSportmodus(){
        sportmodus.gangwechsel();
    }
    private void executeStandardmodus(){
        standardmodus.gangwechsel();
    }


    public void setGeschwindigkeit(float v){
        this.v = v;

        if(this.v>=120){
            System.out.println("120 km/h erreicht");
            executeSportmodus();
        }else{
            System.out.println("unter 120km/h");
            executeStandardmodus();
        }
    }
    public void setKW(int kw){
        this.kW = kw;

        if(this.kW>=50){
            System.out.println("50 kW wurden erreicht");
            executeSportmodus();
        }else{
            System.out.println("Unterhalb von 50 kW");
            executeStandardmodus();
        }
    }

    public void setTurbo(boolean t){
        this.isTurbo = t;
        if(this.isTurbo){
            System.out.println("Turbolader aktiviert");
            executeSportmodus();
        }else{
            System.out.println("Turbolader deaktiviert");
            executeStandardmodus();
        }
    }


}

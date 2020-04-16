public class Nachricht implements IFahrzeug{

    private int lautst‰rke; // zwischen 0-100; standardm‰ﬂig auf 30

    public Nachricht(){
        this.lautst‰rke = 30;
    }
    public void reset(){
        setLautst‰rke(30);
        System.out.println("---");

    }

    public void warn(){
        setLautst‰rke(100);
        System.out.println("PIIIIEEEEEEEEP");
    }

    public int getLautst‰rke() {
        return lautst‰rke;
    }

    public void setLautst‰rke(int lautst‰rke) {
        this.lautst‰rke = lautst‰rke;
    }

}

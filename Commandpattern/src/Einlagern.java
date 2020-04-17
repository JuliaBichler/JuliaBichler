public class Einlagern implements Auftrag {
	private final Lager l;

    public Einlagern(Lager l) {
        this.l = l;
    }

    @Override
    public void execute(String name, String menge) {
        l.einlagern(name, menge);
        
    }
}

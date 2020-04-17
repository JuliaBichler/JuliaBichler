public class Auslagern implements Auftrag{
	private final Lager l;

    public Auslagern(Lager l) {
        this.l = l;
    }

    @Override
    public void execute(String name, String menge) {
        l.auslagern(name, menge);
    }
}

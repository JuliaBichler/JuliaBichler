public class Ausgabe implements IState {
	
	public Ausgabe() {
		// TODO Auto-generated constructor stub
	}

	public void goNext(Context context) {
		
		System.out.println("Vielen Dank für ihren Einkauf");
		System.out.println("Vergessen Sie nicht ihr Wechselgeld!");
		
		context.setState(new Warten());
	}
}

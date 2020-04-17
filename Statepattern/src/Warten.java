public class Warten implements IState {
		
	public void goNext(Context context) {
		
		System.out.println("Warten auf Eingabe:");
		context.setState(new Wählen());
	}
}

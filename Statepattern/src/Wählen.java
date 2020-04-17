import java.util.Scanner;

public class Wählen implements IState{
	
	static int max=10;
	static int min=0;
	
	private static Scanner input = new Scanner(System.in);
	private static int wahl=0;
	
	public Wählen() {
		// TODO Auto-generated constructor stub
	}

	public void goNext(Context context) {
		
		setWahl(input.nextInt());
		
		if(wahl==getRandomNumber()) {
			System.out.println("Auswahl leider nicht möglich!");
			context.setState(new Warten());
		}
		else
		{
			context.setState(new Ausgabe());
		}
	}

	public static int getWahl() {
		return wahl;
	}

	public static void setWahl(int wahl) {
		Wählen.wahl = wahl;
	}
	
	public static double getRandomNumber(){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    System.out.println(x);
	    return x;
	}
}

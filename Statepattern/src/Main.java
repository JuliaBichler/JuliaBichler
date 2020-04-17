public class Main {

	public static void main(String[] args) {
		Context con = new Context();
		con.setState(new Warten());
		while(true) {
			con.advance();
		}
	}
}

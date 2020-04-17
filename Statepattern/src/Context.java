public class Context {
	
	IState state;
	
	public void setState(IState state) {
		this.state = state;
	}
	
	public void advance() {
		state.goNext(this);
	}
}

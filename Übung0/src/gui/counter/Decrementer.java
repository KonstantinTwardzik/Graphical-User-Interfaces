package gui.counter;


public class Decrementer {
	private int counter;
	
	public Decrementer (int counter) {
		this.counter = counter;
	}
	
	public void decrement () {
		counter--;
	}
	
	public int getValue () {
		return counter;
	}

}

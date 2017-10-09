import gui.counter.*;

public class main {

	public static void main (String[] args) {
		//Initialization
		int number = 5;
		Incrementer incrementing = new Incrementer(number);
		Decrementer decrementing = new Decrementer(number);
		
		
		//Testing
		System.out.println(number);
		
		incrementing.increment();
		incrementing.increment();
		number = incrementing.getValue();
		System.out.println(number);
		
		decrementing.decrement();
		number = decrementing.getValue();
		System.out.println(number);
		
	}

}

// Funktioniert noch nicht richtig, aber egal!

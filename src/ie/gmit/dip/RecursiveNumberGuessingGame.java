package ie.gmit.dip;

public class RecursiveNumberGuessingGame {
	
	public void menu() {
		System.out.println("####################################################");
		System.out.println("########## Recursive Number Guessing Game ##########");
		System.out.println("####################################################");
	}
	
	

	public void guess(int number, int min, int max) {
		int guess = (int) (min + max) / 2;

		// automate guess
		if (guess == number) {
			// Correct
			System.out.println("Guessed " + guess + " correctly...!");
			return;
		} else if (guess > number) {
			// Number is over
			System.out.println("Guessed too high... " + guess);
			max = guess - 1;
		} else {
			// Number is under
			System.out.println("Guessed too low... " + guess);
			min = guess + 1;
		}
		guess(number, min, max);
	}

}

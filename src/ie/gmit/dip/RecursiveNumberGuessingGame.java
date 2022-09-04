package ie.gmit.dip;

import java.util.Scanner;

public class RecursiveNumberGuessingGame {
	private Scanner sc;
	private int MAX_RANGE;
	private int MIN_RANGE;
	private int number;
	int counter;

	public void menu() throws InterruptedException {
		System.out.println("####################################################");
		System.out.println("########## Recursive Number Guessing Game ##########");
		System.out.println("####################################################");
		this.rules();
		this.start();
	}

	private void rules() {
		System.out.println("###################### Rules #######################");
		System.out.println("The computer has to guess your number correctly...");
		System.out.println("You have to provide the following:");
		System.out.println("1) The lowest number within a range of numbers");
		System.out.println("3) The highest number within a range of numbers");
		System.out.println("The computer will find the number as fast as possible by using the binary logarithm (log2 n)\n");
	}

	public void start() throws InterruptedException {
		sc = new Scanner(System.in);

		System.out.println("[>] Provide the computer with the lowest number to search from e.g. 1");
		MIN_RANGE = sc.nextInt(); // min number range
		System.out.println("[>] Provide the computer with the highest number to search to e.g. 1500000");
		MAX_RANGE = sc.nextInt(); // max number range
		System.out.println("[>] Enter the number you have chosen between your specified range of " + MIN_RANGE + " and "
				+ MAX_RANGE);
		number = sc.nextInt(); // user assigned number
		this.guess(number, MIN_RANGE, MAX_RANGE);
	}

	public void guess(int number, int min, int max) throws InterruptedException {
		int guess = (int) (min + max) / 2;

		// Logic check to ensure user enters number within the provided range
		if (number > MIN_RANGE && number < MAX_RANGE) {
			if (guess > MIN_RANGE && guess < MAX_RANGE) {
				// automate guess
				if (guess == number) {
					// Correct
					System.out.println("Computer guessed your number " + guess + " correctly with just " + counter
							+ " guesses...!");
					System.out.println("Exiting...");
					Thread.sleep(4000);
					return;
				} else if (guess > number) {
					// Number is over
					System.out.println("Computer guessed too high... " + guess);
					counter++;
					max = guess - 1;
				} else if (guess < number) {
					// Number is under
					System.out.println("Computer guessed too low... " + guess);
					counter++;
					min = guess + 1;
				}
			}
			guess(number, min, max);
			counter++;
		} else {
			System.out.println("Invalid Number Given... " + number + " is not within the range of " + MIN_RANGE + " and " + MAX_RANGE);
			System.out.println("Exiting...");
			Thread.sleep(4000);
		}
	}

}

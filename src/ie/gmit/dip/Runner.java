package ie.gmit.dip;
public class Runner {
	public static void main(String[] args) {

		RecursiveNumberGuessingGame rgg = new RecursiveNumberGuessingGame();
		rgg.menu();
		
		int number = 767;
		rgg.guess(number,  0,  1000);
	}
}

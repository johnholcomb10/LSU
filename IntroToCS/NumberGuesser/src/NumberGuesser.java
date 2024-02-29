import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

	public static void main(String args []) {
		Random randomNumber = new Random();
		Scanner numberScanner = new Scanner(System.in);
		
		int randomInt = randomNumber.nextInt(1000) + 1;
		int sentinel = 1;
		System.out.println("Guess a number between 0 and 1000:");
		
		
		while (sentinel == 1) {
			
			boolean intCheck = numberScanner.hasNextInt();
			boolean strCheck = numberScanner.hasNextLine();
			
			if(intCheck == true) {
				int numberGuess = numberScanner.nextInt();
				
				int guessAccuracy = randomInt - numberGuess;
				
				if(guessAccuracy <= -100 || guessAccuracy >= 100) {
					System.out.println("Cold!");
				} else if ((guessAccuracy > -100 && guessAccuracy <= -50) || (guessAccuracy >= 50 && guessAccuracy < 100)) {
					System.out.println("Warm!");				
				} else if ((guessAccuracy > -50 && guessAccuracy < 0) || (guessAccuracy < 50 && guessAccuracy > 0)) {
					System.out.println("Hot!");
				} else {
					System.out.println("You got It!\nThinking of a number...\nGot it! Guess the number!");
				}
			} else if(strCheck == true) {
				String miscString = numberScanner.next();
				if(miscString.contains("done")) {
					System.out.println("Goodbye!");
					sentinel--;
				} else {
					System.out.println("Invalid input!");
				}
			}
		}
		numberScanner.close();
		return;
	}	
}

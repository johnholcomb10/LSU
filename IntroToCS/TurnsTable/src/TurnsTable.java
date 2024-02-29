import java.util.Random;
import java.util.Scanner;
public class TurnsTable {
	
	public static void main(String args []) {
		
		Random computerRandom = new Random();
		Scanner inputNumber = new Scanner(System.in);
		System.out.println("Enter a new number between 0 and 1000 for me to find:");
		
		boolean inputInt = inputNumber.hasNextInt();
		int sentinel = 1;
		
		while(sentinel == 1) {	
			if(inputInt == true) {	
				boolean numberMatch = false;
				int computerGuess;
				int upperLimit = 1000;
				int lowerLimit = 1;
				int userNumber = inputNumber.nextInt();
				
				while(numberMatch == false) {	
					computerGuess = computerRandom.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
							
					if(computerGuess > userNumber) {
						upperLimit = computerGuess;
						System.out.printf("I guessed %d and it was too high!\n", computerGuess);
					} else if(computerGuess < userNumber){
						lowerLimit = computerGuess;	
						System.out.printf("I guessed %d and it was too low!\n", computerGuess);
					} else {			
					System.out.printf("I guessed %d and got it right!", computerGuess);
					numberMatch = true;
					}
				}
				
				//sentinel--;	
			} else {	
				System.out.println("Invalid input");
			}
		}
		
		inputNumber.close();
		return;
		
	}
	
}

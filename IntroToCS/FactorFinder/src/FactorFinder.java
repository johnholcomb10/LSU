import java.util.Scanner;

public class FactorFinder {

	public static void main(String[] args) {
		
		Scanner inputInt = new Scanner(System.in);
		System.out.println("Please enter a number to factor:");
		
		int sentinel = 0;
		
		while(sentinel == 0) {
			boolean intCheck = inputInt.hasNextInt();
			if(intCheck == true) {
				int number = inputInt.nextInt();
				if(number > 0) {
					int i;
					int divisor = 1;
					
					for(i = 1; i <= Math.sqrt(number); i++) {
						if(number%i == 0) {
							divisor = number/i;
							System.out.printf("%d has factors %d and %d.\n", number, i, divisor);
						}
					}
					sentinel++;
				} else {
					System.out.println("Number must be greater than zero! Try again:");			
				}
			} else {
				System.out.println("Not an integer! Try again:");
				inputInt.nextLine();
			}
		}
		
	inputInt.close();
	return;
	
	}
	
}

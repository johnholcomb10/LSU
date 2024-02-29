import java.util.Scanner;
public class Primes {
	//Primes.java - Calculates whether or not a number is prime
	public static void main(String[] args) {


		int x = 2; //A prime is divisible by 1 and itself, so we start at 2
		int number = -1; //Store the number to check; -1 indicates we have not gotten a correct # yet
		System.out.println("[*]Please enter in a number:"); //Prompt the user
		System.out.print("[>]");
		Scanner primeScan = new Scanner(System.in);//Make a new scanner
		do {
			if(primeScan.hasNextInt()) { //If user entered a number, we read it
				number = primeScan.nextInt();// store input
			}
			else {
				primeScan.nextLine(); //Discard incorrect entry from scanner
				System.out.println("[!]Please enter a number!");//Inform user
			}
		} while (number == -1);
		
		boolean isPrime = true; //We assume a number is prime until we find a divisor
		while(number > x && isPrime) { //We keep checking numbers until we reach the number or have found that the number is NOT prime
			if(number % x == 0) {
				isPrime = false;
			}
			x++;
		}
		String primeMessage = (isPrime) ? "" : "NOT";
		System.out.println("[*]The number " + number + " is "+ primeMessage + " prime");

	}

}

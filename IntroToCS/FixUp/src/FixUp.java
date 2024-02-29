import java.util.Scanner;
public class FixUp {
	
	Scanner qScan = new Scanner(System.in);
	
	public static void main(String[] args) {		
		
		System.out.println("[*]Please enter how long the presentation was (25-50 minutes)");
		int upperBound = 50;
		int lowerBound = 25;
		int length = secondMethod(upperBound, lowerBound);
		
		System.out.println("[*]Please enter how good you thought the presentation was (1-10)");
		upperBound = 10;
		lowerBound = 1;
		int good = secondMethod(upperBound, lowerBound);
		
		System.out.println("[*]Please enter how many times the presentation made you laugh");
		upperBound = Integer.MAX_VALUE;
		lowerBound = 0;
		int laughs = secondMethod(upperBound, lowerBound);
		
		System.out.printf("[*]Feedback Received! The presentation was %d minutes, was a %d/10, and made you laugh %d times", length, good, laughs);
		
	}
	
	/*
	 * secondMethod - Checks input for integer in acceptable range and assigns to variable
	 * @param number - scanner input
	 * @param upperBound - Upper bound for requested input
	 * @param lowerBound - Lower bound for requested input
	 * @return - Value of requested input
	 */
	
	public static int secondMethod(int upperBound, int lowerBound) {
		Scanner qScan = new Scanner(System.in);
		boolean done = false;
		int number = 0;
		
		do {
		if(qScan.hasNextInt()) {
			number = qScan.nextInt();
			if(number<lowerBound || number>upperBound) {
				System.out.printf("Please enter a number between %d and %d", lowerBound, upperBound);
			} else {
				done = true;
				int feedback = number;
				qScan.close();
				return feedback;
			}
		} else {
				System.out.println("[!]Please enter a number\n");
			}
		} while (!done);
		
		int feedback = number;
		qScan.close();
		return feedback;
	}

}

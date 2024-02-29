import java.util.Scanner;
public class Conds {

	/*
	 * Conds - Showcases basic if statement behavior based on user input
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter in a number");
		
		if(scan.hasNextInt()) {
			int val = scan.nextInt();
			if(val < 0) {
				System.out.println("You entered a negative number!");
				
			}
			else if (val < 10) {
				System.out.println("You entered a positive number!");
			}
			else {
				System.out.println("You entered a BIG number!");
			}
		}
		else {
			System.out.println("ERROR! A number was not entered!");
		}
	}

}

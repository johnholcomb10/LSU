import java.util.Scanner;
public class Loops {

	public static void main(String[] args) {

		
		Scanner myScan = new Scanner(System.in);
		System.out.println("[*] Please enter your initial amount");
		double amount, target, growth, initial = 0;
		int years = 0;
		do {
			if(myScan.hasNextDouble()) {
				initial = myScan.nextDouble();
			}
			else {
				myScan.nextLine();
				System.out.println("[!]Error: Did not enter a decimal amount!");
			}
		} while (initial == 0);
		//initial = 150.0;
		amount = initial;
		target = amount * 2;
		growth = 0.025;
		
		while (amount < target) {
			amount *= (1+ growth);
			years++;
			System.out.printf("[*]The year is %d, and we have %.2f\n", years, amount);
		}
		
		System.out.printf("[*]To take $%.2f to $%.2f at %.1f%% growth per year, it would take %d years\n",initial,target,(growth * 100),years);
		

	}

}

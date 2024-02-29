import java.util.Scanner;
public class SumCalculator {

	public static void main(String[] args) {
		double principle, rate, timeIntervals;
		
		Scanner userInp = new Scanner(System.in);
		System.out.println("Welcome to the Sum Calculator!");
		System.out.println("Please enter the principle:");
		principle = userInp.nextDouble();
		System.out.println("Please enter the rate:");
		rate = userInp.nextDouble();
		System.out.println("Please enter the number of time intervals:");
		timeIntervals = userInp.nextDouble();
		System.out.printf("Calculating...\nThe sum is $%,.2f!", Calc(principle, rate, timeIntervals));
		userInp.close();
	}
	
	public static double Calc(double principle, double rate, double timeIntervals) {
		double sum = 0;
		for(double i = 1; i <= timeIntervals; i++ ) {
			sum += (principle * (Math.pow(rate, i)));
		}
		return sum;
	}
	
}

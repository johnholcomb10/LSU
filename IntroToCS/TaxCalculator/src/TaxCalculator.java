import java.util.Scanner;
public class TaxCalculator {

	public static void main(String[] args) {
		Scanner incomeScanner = new Scanner(System.in);
		System.out.println("Please enter in your taxable income");
		double taxesOwed = 0;
		boolean check = incomeScanner.hasNextInt();
		
		if(check == true) {
			int income = incomeScanner.nextInt();
			
			if(income >= 0) {
				if (income <= 12500) {
					taxesOwed = income * 0.02;
				} else if(income <= 50000) {
					taxesOwed = income * 0.02 + (income - 12500) * 0.02;
				} else {
					taxesOwed = income * 0.02 + (income - 12500) * 0.02 + (income - 50000) * 0.02;
				}
			} else {
				System.out.println("Not a valid income!");
			}
			
			System.out.println("Your income is $" + income + ", and your state taxes are $" + taxesOwed + ", so your net income is $" + (income - taxesOwed) + ".");
		} else {
			System.out.println("Not an integer!");
		}
		
		incomeScanner.close();
		return;
	}
}
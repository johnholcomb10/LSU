
public class ATMDriver {

	public static void main(String[] args) {


		ATM myAtm = new ATM();
		ATM secondAtm = new ATM(2,2,2,2,2);
		myAtm.SetVerbose(true);
		secondAtm.SetVerbose(true);
		
		System.out.printf("[*]ATM 1 has $%.2f\n", myAtm.getMoneyAmount());
		System.out.printf("[*]ATM 2 has $%.2f\n", secondAtm.getMoneyAmount());
		
		myAtm.Withdraw(37);
		secondAtm.Withdraw(12);
		System.out.printf("[*]ATM 1 has $%.2f\n", myAtm.getMoneyAmount());
		System.out.printf("[*]ATM 2 has $%.2f\n", secondAtm.getMoneyAmount());
		
		while(myAtm.Withdraw(3)) {
			//System.out.println(myAtm.getMoneyAmount());
		}
		System.out.println(myAtm.getMoneyAmount());
		

	}

}

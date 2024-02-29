
public class ATM {
	private int TotalMoney;
	private int Hundreds;
	private int Twenties;
	private int Tens;
	private int Fives;
	private int Ones;
	private boolean verbose;
	/* 
	 * ATM - Constructor for ATM object using pre-set values
	 */
	public ATM() {
		Hundreds = 10;
		Twenties = 70;
		Tens = 90;
		Fives = 35;
		Ones = 50;
		verbose = false;
		UpdateMoney();
	}
	/*
	 * ATM - Constructor which lets us set each of the different values for bills
	 */
	public ATM(int Hundreds, int Twenties, int Tens, int Fives, int Ones) {
		this.Hundreds = Hundreds;
		this.Twenties = Twenties;
		this.Tens = Tens;
		this.Fives = Fives;
		this.Ones = Ones;
		verbose = false;
		UpdateMoney();
	}
	
	/*
	 * UpdateMoney - Utility internal method that updates the total money value by counting the bills
	 */
	private void UpdateMoney() {
		TotalMoney = (100*Hundreds) + (20*Twenties) + (10*Tens) + (5*Fives) + Ones;
	}
	/*
	 * Withdraw - Simulates withdrawing money from an ATM. the ATM must have the appropriate bills to break change
	 * @param amount - The amount of money to withdraw
	 * @return - whether or not the withdrawal succeeeded
	 */
	public boolean Withdraw(int amount) {
		
		int HNeeded, TwNeeded,TenNeeded, FNeeded, Oneeded;
		if(verbose) {System.out.printf("[*]Withdraw request: %d\n", amount);}
		HNeeded = amount / 100; //Find out how many hundreds would satisfy the request
		HNeeded = Math.min(HNeeded, Hundreds); // We can't give out more hundreds than we have!
		amount -= HNeeded*100; // Reduces the amount left by the # of hundreds we gave
		
		
		TwNeeded = amount / 20;
		TwNeeded = Math.min(TwNeeded, Twenties);
		amount -= TwNeeded*20;
		
		TenNeeded = amount / 10;
		TenNeeded = Math.min(TenNeeded, Tens);
		amount -= TenNeeded*10;
		
		FNeeded = amount / 5;
		FNeeded = Math.min(FNeeded, Fives);
		amount -= FNeeded*5;
		
		Oneeded = amount / 1;
		Oneeded = Math.min(Oneeded, Ones);
		amount -= Oneeded*1;
		
		if(amount != 0) {
			if(verbose) {
				System.out.printf("[!]Unable to withdraw %d!\n", amount);
				System.out.printf("[*]Needed %d hundreds, %d Twenties, %d Tens, %d Fives, and %d Ones\n", amount / 100,amount / 20,amount / 10,amount / 5,amount / 1);
				System.out.printf("[*]ATM has %d hundreds, %d Twenties, %d Tens, %d Fives, and %d Ones\n", Hundreds,Twenties,Tens,Fives,Ones);
			}
			return false; //If amount is greater than 0 than we cannot satisfy the withdraw request
		}
		
		
		//Use imagination that the atm is spitting money
		Hundreds -= HNeeded;
		Twenties -= TwNeeded;
		Tens     -= TenNeeded;
		Fives    -= FNeeded;
		Ones     -= Oneeded;
		UpdateMoney();
		if(verbose) {
			System.out.printf("[*]Dispensing %d hundreds, %d Twenties, %d Tens, %d Fives, and %d Ones\n", HNeeded,TwNeeded,TenNeeded,FNeeded,Oneeded);
		}
		return true;
	}
	/*
	 * getMoneyAmount - Gets the TotalMoney member
	 * @return - The total money value in the atm
	 */
	public double getMoneyAmount() {
		return TotalMoney;
	}
	/**
	 * SetVerbose - Sets the verbosity of the ATM
	 * @param verbose - The state to set the verbosity to (true - on; false - off)
	 * @return - The old state of verbosity
	 */
	public boolean SetVerbose(boolean verbose) {
		boolean oldval = this.verbose;
		this.verbose = verbose;
		return oldval;
	}
	public boolean GetVerbose() {
		return this.verbose;
	}
	
}

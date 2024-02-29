
public class CreditCard {

	private double balance;
	private double limit;
	private double interest_rate;
	private String cardholder;
	
	public CreditCard(double lim, String name) {
		this.balance = 0;
		this.limit = lim;
		this.cardholder = name;
		this.interest_rate = 22.3;
	}
	
	public CreditCard(double lim, String name, double interest) {
		this.balance = 0;
		this.limit = lim;
		this.cardholder = name;
		this.interest_rate = interest;
	}
	
	public double GetBalance() {
		return this.balance;
	}
	
	public double GetLimit() {
		return this.limit;
	}
	public double GetAvailableCredit() {
		return (limit - balance);
	}
	public double GetAPY() {
		return this.interest_rate;
	}
	public String GetCardholder() {
		return this.cardholder;
	}
	
	public double MonthlyInterest() {
		return this.interest_rate / 12.0;
	}
	
	public boolean Charge(double amount) {
		amount += balance;
		if(amount > limit) {
			return false;
		}
		balance = amount;
		return true;
	}
	
	public boolean Pay(double amount) {
		balance -= amount;
		return true;
	}
	
	public double AccrueInterest() {
		if(balance <= 0.0) {
			return balance;
		}
		balance = balance * (1 + (this.MonthlyInterest()/100.0));
		balance = Math.round(balance * 100.0) / 100.0;
		
		return balance;
	}
}

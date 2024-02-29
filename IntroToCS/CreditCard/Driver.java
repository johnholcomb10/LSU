
public class Driver {

	public static void main(String[] args) {

		CreditCard baseCard = new CreditCard(2000,"Mandy");
		RewardsCard RCard = new RewardsCard(6000,"Bobby", 19.8);
		StudentCard SCard = new StudentCard("Dave");
		EliteRewardsCard ECard = new EliteRewardsCard("Sir Kimmeth Olegaurd III");
		
		CreditCard newCard = new CreditCard(10000, "Test", 33.2);
		
		PrintCardInfo(baseCard);
		PrintCardInfo(newCard);
		PrintCardInfo(RCard);
		PrintCardInfo(SCard);
		PrintCardInfo(ECard);

	}
	
	public static void PrintCardInfo(CreditCard c) {
		System.out.printf("[*]%s's card has a limit of $%.2f, a balance of $%,.2f, and an annual interest rate of %.2f%%\n", c.GetCardholder(), c.GetLimit(), c.GetBalance(), c.GetAPY());
	}

}

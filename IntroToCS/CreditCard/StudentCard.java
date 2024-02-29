
public class StudentCard extends CreditCard {
	int numMissed;
	
	public StudentCard(String name) {
		super(3000,name,29.7); // new CreditCard(3000,name,29.7)
		numMissed = 0;
	}
	
	public double AccrueInterest() {
		if (this.GetBalance() > 0) {
			numMissed++;
		}
		
		if(numMissed >= 4) {
			return super.AccrueInterest();
		}
		else {
			return this.GetBalance();
		}
	}

}

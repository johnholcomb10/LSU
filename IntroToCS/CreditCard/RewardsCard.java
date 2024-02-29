
public class RewardsCard extends CreditCard {

	private double rewardPoints;
	protected double points_per_dollar;
	
	public RewardsCard(double lim, String name) {
		super(lim,name);
		rewardPoints = 0;
		points_per_dollar = 1.0;
	}
	public RewardsCard(double lim, String name, double interest) {
		super(lim,name,interest);
		rewardPoints = 0;
		points_per_dollar = 1.0;
	}
	
	public double GetRewardPoints() {
		return this.rewardPoints;
	}
	
	public boolean Charge(double amount) {
		if(!super.Charge(amount)) {
			return false;
		}
		rewardPoints += amount * points_per_dollar;
		return true;
	}
}

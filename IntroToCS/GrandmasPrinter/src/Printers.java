
public class Printers {

	public static void main(String[] args) {
		final double VOLUME_OF_MOON = 21958000000.0; // In Km^3
		final double VOLUME_OF_PURSE = 0.00038861; // m^3
		final double SHRINK_RAY_CONVERSION_RATIO = 364.37;
		
		double energy_needed_for_shrink_ray = (Math.pow(VOLUME_OF_MOON,0.5))/ (SHRINK_RAY_CONVERSION_RATIO * VOLUME_OF_PURSE);
		
		System.out.printf("The volume of the moon is %.4e ",VOLUME_OF_MOON);
		System.out.printf(", while the volume of the purse is %f\n",VOLUME_OF_PURSE);
		System.out.printf("The energy needed for the shrink ray is %.0f\n", energy_needed_for_shrink_ray);
				
		final double SELL_VALUE_OF_MOON = 324154.23; // in USD
		final double COST_PER_ENERGY = 0.252; // USD/kW
		final double G_CUT_OF_PROFIT = 0.31415; // Don't worry who G is sweety
		final double G_FEE_SENIOR_DISCOUNT = 40000; 
		
		double energy_cost = energy_needed_for_shrink_ray * COST_PER_ENERGY;
		double profit = (SELL_VALUE_OF_MOON - (energy_cost));
		double grannys_profit = profit - ((profit * G_CUT_OF_PROFIT) + G_FEE_SENIOR_DISCOUNT);
		double Gs_profit = (profit * G_CUT_OF_PROFIT) + G_FEE_SENIOR_DISCOUNT;
		
		System.out.printf("\tEnergy Cost\t %+(10.2f $\n", energy_cost);
		System.out.printf("\tProfit\t\t %+(10.2f $\n", profit);
		System.out.printf("\tGrandma's Share\t %+(10.2f $\n", grannys_profit);
		System.out.printf("\tG's Share\t %+(10.2f $\n", Gs_profit);
		
		System.out.printf("Changing the purse size now makes a profit of %+(10.2f $\n", grannys_profit);
	}
}

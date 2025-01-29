
public class Currency {

	private String Currency_Name;
	@SuppressWarnings("unused")
	private double Exchange_Rate;
	private double Amount;
	
	private final double DOLLARS_TO_CREDITS = 53.4;
	private final double BLEGHTHERS_TO_CREDITS = 2.3;
	private final double SMORGOS_TO_CREDITS = 1276.32;
	
	/*
	 * Currency - Constructor
	 */
	
	public Currency(double amount, String currencyName) {
		Currency_Name = currencyName;
		Exchange_Rate = GetRate(GetName());
		Amount = amount;
	}
	
	/*
	 * GetName - Gets the currency's name
	 * @return - The currency's name
	 */
	
	public String GetName() {
		return Currency_Name;
	}
	
	/*
	 * GetRate - Gets the exchange rate for the currency
	 * @param - The name of the currency
	 * @return - The currency's exchange rate
	 */
	
	public double GetRate(String name) {
		double rate;
		if(name.equals("Dollars")) {
			rate = DOLLARS_TO_CREDITS;
		} else if (name.equals("Bleghthers")) {
			rate = BLEGHTHERS_TO_CREDITS;
		} else {
			rate = SMORGOS_TO_CREDITS;
		}
		return rate;
	}
	
	/*
	 * GetAmount - Gets the local currency amount
	 * @return - The currency's local amount
	 */
	
	public double GetAmount() {
		return Amount;
	}
	
	/*
	 * SetAmount - Sets the local currency amount
	 * @param - The amount of currency
	 * @return - The currency's local amount
	 */
	
	public void SetAmount(double amount) {
		Amount = amount;
	}
	
	/*
	 * GetRate - Returns the total credit value of the currency
	 * @return - The total credit value of the currency
	 */
	
	public double GetCreditValue() {
		double CreditValue = GetAmount() * GetRate(GetName());
		return CreditValue;
	}
	
	/*
	 * GetRate - Takes another Currency object and returns how much of the other currency the current currency can buy.	
	 * @param - The currency being converted to 
	 * @return - How much of other currency that local currency can buy
	 */
	
	public double CheckExchange(String convertTo) {
		double Exchange = GetAmount() * GetRate(GetName()) / GetRate(convertTo);
		return Exchange;
	}
	
}

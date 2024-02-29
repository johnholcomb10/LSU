
public class Exchange {

	public static void main(String[] args) {
		
		Currency obj1 = new Currency(27.00, "Dollars");
		Currency obj2 = new Currency(2931.00, "Bleghthers");
		Currency obj3 = new Currency(3.00, "Smorgos");
		
		System.out.printf("%f %s are worth %f credits\n", obj3.GetAmount(), obj3.GetName(), obj3.GetCreditValue());
		System.out.printf("%s\n", obj2.GetName());
		System.out.printf("With %f Dollars, you can buy %f Smorgos\n", obj1.GetAmount(), obj1.CheckExchange("Smorgos"));
		System.out.printf("With %f Blegthers, you can buy %f Dollars\n", obj2.GetAmount(), obj2.CheckExchange("Dollars"));
		System.out.printf("%f Dollars, %f Bleghters, and %f Smorgos are worth: %f Credits\n", obj1.GetAmount(), obj2.GetAmount(), obj3.GetAmount(), (obj1.GetCreditValue() + obj2.GetCreditValue() + obj3.GetCreditValue()));
		System.out.printf("If we converted everything to dollars, we would have %f Dollars\n", (obj1.CheckExchange("Dollars")) + obj2.CheckExchange("Dollars") + obj3.CheckExchange("Dollars"));
	}
	
}

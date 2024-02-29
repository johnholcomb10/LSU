
public class PizzaDriver {

	public static void main(String[] args) {

		
		
		Pizza pepper = new Pizza(Pizza.PIZZASIZES.MEDIUM);
		pepper.AddTopping("Pepperoni");
		pepper.Slice(8);
		pepper.SetName("Pepperoni");
		System.out.printf("[*]A Medium \"%s\" pizza with %s as toppings will cost %.2f. Comes with %d slices\n", pepper.GetName(), pepper.GetToppings(),pepper.GetPrice(), pepper.GetSlices());
		
		
		Pizza huttin = new Pizza(Pizza.PIZZASIZES.HUT,12);
		huttin.AddTopping("Pepperoni");
		huttin.AddTopping("Green Pepper");
		huttin.AddTopping("Mushroom");
		huttin.AddTopping("Salami");
		huttin.SetName("The Out Hutter");
		if(huttin.AddTopping("Papa's Secret Sauce")) {
			System.out.println("[!]Uh oh papa added his secret sauce! (He shouldn't)");
		}
		
		if(huttin.Slice(6)) {
			System.out.println("[!]Uh oh you can unslice a pizza!");
		}
		
		System.out.printf("[*]A Hut-sized \"%s\" pizza with %s as toppings will cost %.2f. Comes with %d slices\n", huttin.GetName(), huttin.GetToppings(), huttin.GetPrice(), huttin.GetSlices());

		Pizza Objectively_Bad = new Pizza(Pizza.PIZZASIZES.SMALL,24);
		Objectively_Bad.SetName("Totally Real Pizza Ordered by Normal Humans");
		Objectively_Bad.AddTopping("Black Olives");
		Objectively_Bad.AddTopping("Pineapple");
		Objectively_Bad.AddTopping("Anchovies");
		
		System.out.printf("[*]A Small-sized \"%s\" pizza with %s as toppings will cost %.2f. Comes with %d slices\n", Objectively_Bad.GetName(), Objectively_Bad.GetToppings(), Objectively_Bad.GetPrice(), Objectively_Bad.GetSlices());
		
		Pizza Bland = new Pizza(Pizza.PIZZASIZES.LARGE);
		Bland.SetName("Who Needs a Raise?");
		System.out.printf("[*]A Large \"%s\" pizza with %s as toppings will cost %.2f. Comes with %d slices\n", Bland.GetName(), Bland.GetToppings(),Bland.GetPrice(), Bland.GetSlices());
		
	}

}
//Student Name: John Holcomb
//Student ID: 890963950

public class Cake {

	private String flavor;
	private int tiers;
	private double price;
	
	public Cake(String cakeFlavor, int Tiers) {
		flavor = cakeFlavor;
		tiers = Tiers;
	}
	
	public static void main(String[] args) {
		
		Cake birthdayCake = new Cake("Caramel", 1);
		birthdayCake.setPrice(30.50);
		
		Cake weddingCake = new Cake("Vanilla", 4);
		weddingCake.setPrice(299.99);
		
		Cake graduationCake = new Cake("Carrot", 2);
		graduationCake.setPrice(47.75);
		
		birthdayCake.printCard();
		weddingCake.printCard();
		graduationCake.printCard();
		
		double totalSales = birthdayCake.getPrice() + weddingCake.getPrice() + graduationCake.getPrice();
		System.out.printf("Total cake sales \t\t$%.2f\n", totalSales);
	}
	
	public void setPrice(double cakePrice) {
		price = cakePrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void printCard() {
		System.out.printf("A %d tiers %s cake \t\t$%.2f\n", tiers, flavor, price);
	}
		
}



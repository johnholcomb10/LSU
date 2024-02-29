import java.util.Scanner;
public class Donation {

	/*
	 * Donation - Showcases the switch statement
	 * Note the difference between using break statements and not
	 * Default case is not required, but without it the entirety of the switch is skipped
	 */
	public static void main(String[] args) {

		
		Scanner donationScanner = new Scanner(System.in);
		System.out.println("What is your donation tier? [Diamond, Platinum, Gold, Silver, Bronze]");
		String donationTier = donationScanner.next();
  	  
		switch(donationTier) {
	  		case "Diamond" : System.out.println("Shine bright like a Diamond, sponsor!"); break;
	  		case "Platinum": System.out.println("You rock Platinum sponsor!"); break;
	  		case "Gold"    : System.out.println("Stay cold, our sponsor of gold!"); break;
	  		case "Silver"  : System.out.println("Your donation is greatly appreciated"); break;
	  		case "Bronze"  : System.out.println("You did the minimum and we appreciate that!"); break;
	  					 	 
	  	default: System.out.println("Thanks for looking at our program");
	  }
  	  
  	  	switch(donationTier) {
  	  		case "Diamond" : System.out.println("You receive a High-Quality Hoodie!");
  	  		case "Platinum": System.out.println("You receive a Perfectly Fitting Beanie!");
  	  		case "Gold"    : System.out.println("You receive a logo'd notebook!");
  	  		case "Silver"  : System.out.println("You receive a stack of post-cards!");
  	  		case "Bronze"  : System.out.println("You receive a bag of candy!");
  	  					 	 System.out.print("And ");
  	  	default: System.out.println("You receive a nice Sticker!");
  	  }

	}

}

import java.util.Scanner;

public class AceOfSpades {
	public static void main(String[] args) {
		
		Scanner cardScanner = new Scanner(System.in);
		System.out.println("Please enter in the 2-letter card code:");
		String cardInput = cardScanner.nextLine();
		String value = null;
		String suit = null;
		
		switch(cardInput.substring(0,1)) {
			case "K" : value = "King"; break;
			case "Q" : value = "Queen"; break;
			case "J" : value = "Jack"; break;
			case "9" : value = "Nine"; break;
			case "8" : value = "Eight"; break;
			case "7" : value = "Seven"; break;
			case "6" : value = "Six"; break;
			case "5" : value = "Five"; break;
			case "4" : value = "Four"; break;
			case "3" : value = "Three"; break;
			case "2" : value = "Two"; break;
			case "A" : value = "Ace"; break;
			
			default:System.out.println("Error - Card not recognized!");
					cardScanner.close();
					return;
		}
		
		switch(cardInput.substring(1, 2)) {
			case "H" : suit = "Hearts"; break;
			case "D" : suit = "Diamonds"; break;
			case "C" : suit = "Clubs"; break;
			case "S" : suit = "Spades"; break;
			
			default:System.out.println("Error - Card not recognized!");
					cardScanner.close();
					return;
		}
		
		System.out.printf("That card is the %s of %s.", value, suit);
		cardScanner.close();
		return;
	}
}

import java.util.Scanner;
public class vowels {


	public static void main(String[] args) {
		String inpt;
		Scanner myScan = new Scanner(System.in);
		System.out.println("[*]Welcome to vowel counter! Please enter a word!");
		inpt = myScan.next();
		int vowels = 0;
		int upperCase = 0;

		for(int i = 0; i < inpt.length(); i++) {
			char letter = inpt.charAt(i);
			boolean b1 = Character.isUpperCase(letter);
			
			if(b1 == true) {
				upperCase++;
			}
			String charStr = "" + letter;
			String letterUp = charStr.toUpperCase();
			if(letterUp.contains("A") || letterUp.contains("E") || letterUp.contains("I") || letterUp.contains("O") || letterUp.contains("U")) {
				vowels++;
			}
		
		
		

	}
		System.out.printf("[*]The word %s has %d vowels in it! It also has %d uppercase letters.\n",inpt,vowels,upperCase);

		myScan.close();
}
}	
	
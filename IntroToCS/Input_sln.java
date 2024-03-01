import java.util.Scanner; // Scanner needs to be imported before its used in our code
public class Input_sln {

	
	public static void SLN(String[] args) {
		String name; // declare a variable to store the input name
		Scanner inputScanner = new Scanner(System.in); // Make a new input Scanner variables. Because Scanner is a class we need the new keyword before it
		//By using System.in, we tell the scanner to read from the terminal to get its input
		System.out.println("Hello! What is your name?"); // Prompt the user to enter in their name
		name = inputScanner.next(); //Causes the scanner to grab the next token from the input
		//A token is a group of text with a space after it
		//"The quick Brown fox..." has the tokens "The" "quick" "Brown" "fox...", in that order
		//In this example, since we call Scanner.next(), only the first token entered is returned, leaving the remaining tokens in the "queue"
		//To let the user input their full name, we need to change the line to Scanner.nextLine();

		System.out.println("Hello " + name + ", nice to meet you!"); // Outputs the name we read back to the user
		System.out.println("How old are you?"); // Prompt the user to enter in their age
		int age = inputScanner.nextInt();// Grabs the next token and try to interpret it as an int
		//If the token is NOT an integer (say a string or a double), then the previous line will crash!
		//For our purposes, we would want to change it to Scanner.nextDouble() or Scanner.nextLine() to allow a user to enter a decimal age

		final double MILLISECONDS_TO_YEARS = 0.00000000003169; //Declare a constant to convert miliseconds to years, since we don't
		// want random numbers floating around in our code right? :)
		System.out.println(age + "? I am about " + (int)(System.currentTimeMillis() * MILLISECONDS_TO_YEARS) + " years old!"); // Prints the user's and computer's age
		//This is calculated by getting the number of miliseconds since the Epoch (Jan 1, 1970) and converting that value into year
		System.out.println("Goodbye!");
		inputScanner.close(); // It is a good habit to close a scanner after we are done with it
		//Our computer keeps track of which programs are accessing a certain resource, so we may deny another program or
		//another part of our code from accessing System.in if we do not close it!
	}
}


public class Solution {
	public static void SLN(String[] args) {
		int x = 10; //Initialize x to 10
		int y = 3; //Initialize y to 3
		System.out.println("x: " + x + " y: " + y); // Prints "x: " followed by the value for x, followed by " y: ", followed by the value of y
		x++; //Increment x by 1
		y--; //Decrement y by 1
		System.out.println("x: " + x + " y: " + y); // Prints the new values of x and y
		x += 3; // shorthand for x = x + 3
		y = y + 3; // increase y by 3 and store the new value in y
		System.out.println("x: " + x + " y: " + y); // prints the new values of x and y
		System.out.println("x + y = " + x + y); // Due to an issue in the order of operations, it converts x to a string, then concatenates it, giving the result of "145" instead of 19
		//To fix this we would write System.out.println("x + y = " + (x + y));
		//This adds x and y prior to converting them to a string and concatenating the result
		
		int result1, result2, result3; // declare some new variables
		result1 = x / y; //integer division cuts off the decimal value
		result2 = x % y; // modulus division
		result3 = x * y; // multiplication
		System.out.println("x: " + x + " y: " + y); // re-print the values of x and y
		System.out.println("result 1: " + result1 + ", 2: " + result2 + ", 3: " + result3); // outputs the results of x/y, x%y, x*y;
		System.out.println("x > y?: " + (x > y) + " x < y?: " + (x < y)); //prints boolean (true/false) values for some comparisons

	}
}

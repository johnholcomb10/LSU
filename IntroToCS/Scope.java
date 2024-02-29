
public class Scope {

	static int numMethods = 0;// Global variable is defined with static int
	
	public static void main(String[] args) {

		numMethods++;
		int x,y,z;
		x = 3;
		y = 2;
		z = 1;
		
		System.out.println("[*]M1: " + firstMethod(x,z));
		System.out.println("[*]M1: " + firstMethod(y,z));
		System.out.println("[*]M2: " + secondMethod(x,y));
		System.out.println("[*]M1: " + firstMethod(z,z));
		System.out.println("[*]M2: " + secondMethod(z,x));
		System.out.println("[*]M1: " + firstMethod(y,y));

		System.out.println("[*]There were " + numMethods + " methods called");
	}
	
	
	public static int firstMethod(int num1, int num2) {
		numMethods++;
		return num1 + num2;
	}
	
	public static int secondMethod(int num1, int num2) {
		numMethods++;
		return num1 - num2;
	}
	/*
	public static int badScope() {
		numMethods++;
		return x + y;
	}*/
}

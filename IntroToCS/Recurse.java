
public class Recurse {

	public static void main(String[] args) {
		int base, power;
		base = 5;
		power = 10;
		System.out.printf("[*]%d to the %d power is %d\n",base,power,power(base,power) );

	}

	
	public static int power(int base, int pow) {
		if(pow == 1) {
			return base;
		}
		
		if(pow % 2 ==0) {
			return power(base, pow / 2) * power(base, pow / 2);
		}
		else {
			return power(base, pow / 2) * power(base, (pow / 2) + 1);
		}
		
	}
	
}

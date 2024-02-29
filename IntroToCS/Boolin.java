
public class Boolin {
/*
 * Boolin - Showcases boolean logic
 * Includes Combinations of boolean variables using the Logical operators:
 * And (&&), Or (||), and XOR (^)
 */
	public static void main(String[] args) {
		boolean TBool1 = true, TBool2 = true;		
		boolean FBool1 = false, FBool2 = false;
		
		System.out.println("true and true: " + (TBool1 && TBool2));
		System.out.println("true and false: " + (TBool1 && FBool1));
		System.out.println("false and true: " + (FBool1 && TBool1));
		System.out.println("false and false: " + (FBool1 && FBool2));
		System.out.println("----------------");
		System.out.println("true or true: " + (TBool1 || TBool2));
		System.out.println("true or false: " + (TBool1 || FBool1));
		System.out.println("false or true: " + (FBool1 || TBool1));
		System.out.println("false or false: " + (FBool1 || FBool2));
		System.out.println("----------------");
		System.out.println("true or true: " + (TBool1 ^ TBool2));
		System.out.println("true or false: " + (TBool1 ^ FBool1));
		System.out.println("false or true: " + (FBool1 ^ TBool1));
		System.out.println("false or false: " + (FBool1 ^ FBool2));
		System.out.println("----------------");
		//Note the discrepancies between comparing strings using == and .equals methods
		String str1 = "Hello, World!";
		String str2 = "Oops I did it again!";
		
		System.out.println("str1 == str2? " + (str1 == str2));
		str2 = "Hello, " + "World!";
		System.out.println("str1 == str2? " + (str1 == str2));
		
		
		String str3 = new String("Hello, World!");
		System.out.println("str1 == str3? " + (str1 == str3));
		
		System.out.println("str1.equals(str3)? " + str1.equals(str3));
		
		

	}

}

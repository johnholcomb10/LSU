import java.util.Arrays;
import java.util.Scanner;
public class ArrayPlayground {

	public static void main(String[] args) {
		int numsArray[] = {0,1,2,3,4,5,6,7,8,9};
		Scanner numScan = new Scanner(System.in);
		int index, value;
		System.out.println("[*]Enter an index, followed by a number to modify the array at that location or a non-number to end");
		printArray(numsArray);
		boolean done = false;
		boolean numCheck = numScan.hasNextInt();
		if(numCheck == true) {
			while (done == false) {
					while(numScan.hasNextInt()) {
						index = numScan.nextInt();
						if(numScan.hasNextInt()) {
							value = numScan.nextInt();
							System.out.printf("Attempting to set index %d to value %d.\n", index, value);
							modifyArray(numsArray, index, value);
							printArray(numsArray);
						}
					}						
				numScan.close();
			}
		} else {
			if(numScan.hasNextLine() == true) {
				System.out.println("Non-int found! Closing program!");
				printArray(numsArray);
				done = true;
			}
		}
	}
	
	public static boolean modifyArray(int numsArray[], int index, int value) {
		if(index >= 0 && index < numsArray.length) {
		numsArray[index] = value;
		return true;
		}
		System.out.println("Index not valid!");
		return false;
	}
	
	public static void printArray(int currentArray[]) {
				System.out.println("The array currently is: " + Arrays.toString(currentArray));
	}
}

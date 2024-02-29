import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class ArrayGen{
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int size, min, max;
		
		System.out.println("Please enter a positive size for the array");
		if(scan.hasNextInt()) {
			size = scan.nextInt();
			int nums[] = new int[size];
			System.out.println("Please enter the minimum value");
			if(scan.hasNextInt()) {
				min = scan.nextInt();
				System.out.println("Please enter the maximum value");
				if(scan.hasNextInt()) {
					max = scan.nextInt();
					Randomize(nums, size, min, max);
					System.out.printf("[*]The sum of the array is %d", SumArray(nums));
				}
			}
		}						
		scan.close();
		return;
		
	}
	
	public static void Randomize(int[] arr, int size, int min, int max) {
		
		Random rand = new Random();
		int nums[] = new int[size];
		for(int i = 0; i < nums.length; i++) {
			arr[i] = rand.nextInt(min, max) + 1;
		}
		System.out.println("The array currently is: " + Arrays.toString(arr));
		return;
		
	}
	
	public static int SumArray(int arr[]) {
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
		
	}
	
	
}

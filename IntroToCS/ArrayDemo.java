import java.util.Random;
public class ArrayDemo {

	@SuppressWarnings("unused")
	static final int SIZE = 1000;
	static long SEED = System.currentTimeMillis();
	public static void main(String[] args) {

		int nums[] = {4,5,6,3,20,26,6,11,10,21}; //Used  dice to generate numbers
		//int nums [] = {7, 18, 4, 4, 5, 10, 13, 11, 19, 11};
		//int test[] = {3,5,2,8,7,1};
		int[] usage = nums;
		printArray(usage);
		BubbleSort(usage, false);
		printArray(usage);
		
		int number = 15;
		int num2 = 5;
		System.out.printf("[*]Value %d is at position %d\n", number, BinarySearch(usage,number,0,usage.length-1, false));
		System.out.printf("[*]Value %d is at position %d\n", num2, BinarySearch(usage,num2,0,usage.length-1, false));		
		
	}
	/*
	* printArray - Prints out the given array
	* @param arr - The array to be printed
	*/
	public static void printArray(int arr[]) {
		System.out.print("[*]Array: [");
		for(int i =0; i < arr.length - 1; i++) {
			System.out.printf("%d, ", arr[i]);
		}
		System.out.printf("%d", arr[arr.length - 1]);
		System.out.print("]\n");
		
	}

	/**
	 * BubbleSort - Sorts the given integer array from low to high using the Bubble Sort Algorithm
	 * @param arr - The array to sort
	 * @param verbose - True to print out state & diagnostic info, false for silent
	 */
	public static void BubbleSort(int arr[], boolean verbose) {
		int passes = 0;
		boolean swap_occured = false;
		do { //The do while loop handles passes
			passes++;
			swap_occured = false; // We only terminate after we've gone through a pass without swapping any elements
			for(int i = 0; i< arr.length-1; i++ ) { //We go from 0 to length-1 since we look at both the current and next index
				if(arr[i] > arr[i+1]) {//Check if the current element is greater than the next element
					int temp = arr[i]; //To swap 2 array elements we need a temp variable so we can keep the value
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swap_occured = true;
				}
			}
			if(verbose) {printArray(arr);}
		}while (swap_occured);		
		if(verbose) {System.out.printf("[*]Passes %d\n",passes);}
	}
	/**
	 * InitArray - takes an array and fill it with random values
	 * @param arr - the array to initialize
	 * 
	 */
	public static void initArray(int arr[]) {
		Random rand = new Random(SEED);
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(0,100001);
		}
	}
	/**
	 * LinearSearch - performs a linear search inside an array
	 * @param arr - The array to search
	 * @param search - the value to search for
	 * @return - the position inside the array that search was found, or -1 if search is not found
	 */
	public static int LinearSearch(int arr[], int search) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == search) {
				return i;
			}
		}	
		return -1;
	}
	/**
	 * SmartLinearSearch - Improved linear search that is smarter. NOTE: this only works if the array is already sorted (low -> high)
	 * @param arr - The array to search
	 * @param search - the value to search for
	 * @return - the position inside the array that search was found, or -1 if search is not found
	 */
	public static int SmartLinearSearch(int arr[], int search) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == search) {
				return i;
			}
			if(arr[i] > search) {
				return -1;
			}
		}
		
		return -1;
	}
	/**
	 * Binary search - Performs an in-place binary search on an array using recursion NOTE: this only works if the array is already sorted (low -> high)
	 * @param arr - the array to search
	 * @param search - the value to search for
	 * @param low - the lowest (left most) index to include
	 * @param high - the highest (right most) index to include
	 * @param verbose - True to print out state & diagnostic info, false for silent
	 * @return - the position inside the array that search was found, or -1 if search is not found
	 */
	public static int BinarySearch(int arr[], int search, int low, int high, boolean verbose) {
				
		int mid;
		if(verbose) {System.out.printf("[*]Searching for %d from %d to %d\n", search, low, high);}
		//if high == low, then we are looking at a single index, meaning either we found the search value or not
		if(high == low) {
			if (arr[high] == search) {
				return high;
			}
			else {
				return -1;
			}
		}
		//If we only have 2 items left (high - low == 1), then check if either are a match
		if(high - low == 1) {
			if(arr[low] == search) {
				return low;
			}
			else if (arr[high] == search) {
				return high;
			}
			else {
				return -1;
			}
		}
		
		mid = (int) Math.ceil((high + low) / 2.0); //middle index calculation
		int element = arr[mid]; //check if the element at the middle index is the search value
		if(element == search) {
			return mid;
		} //Otherwise, compare the value of the middle to the search value, and check the appropriate side of the array
		else if (element > search) {
			return BinarySearch(arr,search,low, mid, verbose);
		}
		else { // element < search
			 return BinarySearch(arr,search,mid,high, verbose);
		}				
		
		
	}
}

import java.util.Random;
import java.util.Scanner;
public class SortingAlgorithms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arraySize = scanner.nextInt();
        scanner.close();
        int nums[] = new int[arraySize];
        Random random = new Random(1001);
        for(int i = 0; i < arraySize; i++) {
            nums[i] = random.nextInt();
        }
        System.out.printf("Bubble Sort: %d (ms.)\n", BubbleSort(nums));
        System.out.printf("Bubble Sort (SC): %d (ms.)\n", BubbleSortSC(nums));
        System.out.printf("Selection Sort: %d (ms.)\n", SelectionSort(nums));
        System.out.printf("Insertion Sort: %d (ms.)\n", InsertionSort(nums));
    }

    public static int BubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < arr.length-1; i++) {
        	for(int j = 0; j < arr.length-i-1; j++) {
	        	if(arr[j] > arr[j+1]){
		        	int temp = arr[j];
		        	arr[j] = arr[j+1];
		        	arr[j+1] = temp;
	        	}
        	}
        }
        
        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int BubbleSortSC(int[] arr) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < arr.length-1; i++){
	        boolean swap = false;
	        for(int j = 0; j < arr.length-i-1; j++){
		        if(arr[j] > arr[j+1]) {
			        int temp = arr[j];
			        arr[j] = arr[j+1];
			        arr[j+1] = temp;
			        swap = true;
		        }
		    }
	        if(!swap){
	        break;
	        }
        }
        
        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int SelectionSort(int[] arr) {
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < arr.length - 1; i++){
	        int minIndex = i;
	        for (int j = i + 1; j < arr.length; j++) {
		        if (arr[j] < arr[minIndex]) {
		        	minIndex = j;
		        }
		    }
	        int smallerNumber = arr[minIndex];
	        arr[minIndex] = arr[i];
	        arr[i] = smallerNumber;
        }
        
        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int InsertionSort(int[] arr) {
        long start = System.currentTimeMillis();
        
        for (int i = 1; i < arr.length; i++)
        {
	        int key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && arr[j] > key) {
		        arr[j + 1] = arr[j];
		        j = j - 1;
	        }
	        arr[j + 1] = key;
        } 
        
        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }
}

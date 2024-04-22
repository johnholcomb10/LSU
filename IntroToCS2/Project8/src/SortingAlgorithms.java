import java.util.Random;
import java.util.Scanner;
public class SortingAlgorithms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arraySize = scanner.nextInt();
        int nums[] = new int[arraySize];
        Random random = new Random(1001);
        for(int i = 0; i < arraySize; i++) {
            nums[i] = random.next();
        }
        System.out.printf("Bubble Sort: %d (ms.)", BubbleSort());
        System.out.printf("Bubble Sort (SC): %d (ms.)", BubbleSort());
        System.out.printf("Selection Sort: %d (ms.)", BubbleSort());
        System.out.printf("Insertion Sort: %d (ms.)", BubbleSort());
    }

    public static int BubbleSort() {
        long start = System.currentTimeMillis();
        
        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int BubbleSortCS() {
        long start = System.currentTimeMillis();

        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int SelectionSort() {
        long start = System.currentTimeMillis();

        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }

    public static int InsertionSort() {
        long start = System.currentTimeMillis();

        long elapsed = System.currentTimeMillis() - start;
        return (int)(long)elapsed;
    }
}

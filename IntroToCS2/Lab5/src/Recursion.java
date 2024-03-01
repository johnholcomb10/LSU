import java.util.ArrayList;

public class Recursion {

    public static void main(String[] args){
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(5);
        sortedList.add(10);
        sortedList.add(20);
        sortedList.add(30);
        sortedList.add(40);
        int target = 20;
        int first = 0;
        int last = sortedList.size();
        int result = recursiveBinarySearch(sortedList, target, first, last);
        if (result != -1) {
        System.out.println("Element " + target + " found at index " + result);
        } else {
        System.out.println("Element " + target + " not found in the list");
        }
    }

    public static int recursiveBinarySearch(ArrayList<Integer> array, int target, int first, int last){
        int mid = (last) / 2;
        if(target == array.get(mid)){
            return mid;
        } else if (target < array.get(mid)) {
            last = mid - 1;
            return recursiveBinarySearch(array, target, first, last);
        } else if (target > array.get(mid)) {
            first = mid + 1;
            return recursiveBinarySearch(array, target, first, last);
        } else {
            return -1;
        }
    }

}

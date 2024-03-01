public class LinkedListDriver {
    public static void main(String[] args){
        LinkedList<Integer> intList = new LinkedList<>();
        LinkedList<Double> doubleList = new LinkedList<>();
        LinkedList<String> stringList = new LinkedList<>();
        doubleList.insert(1000.00);
        doubleList.insert(350.40);
        doubleList.insert(199.99);
        intList.insert(5);
        intList.insert(200);
        intList.insert(390);
        stringList.insert("1351");
        stringList.insert("CSC");
        stringList.insert("6");
        doubleList.print();
        intList.print();
        stringList.print();
    }
}

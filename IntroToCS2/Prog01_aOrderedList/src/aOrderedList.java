import java.util.*;
public class aOrderedList implements Comparable<Car>{
	
	final int SIZEINCREMENTS = 20;
	private Car[] oList;
	private int listSize;
	private int numObjects;
	
	public aOrderedList() {
		oList = new Car[SIZEINCREMENTS];
		listSize = SIZEINCREMENTS;
		numObjects = 0;
	}
	
	public void add(Car newCar) {
		oList[numObjects] = newCar;
		numObjects++;
		Collections.sort(oList);
	}
}

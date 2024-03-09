import java.util.*;
public class aOrderedList{
	
	final int SIZEINCREMENTS = 20;
	private ArrayList<Car> oList;
	private int listSize;
	private int numObjects;
	
	public aOrderedList() {
		oList = new ArrayList<>(SIZEINCREMENTS);
		listSize = SIZEINCREMENTS;
		numObjects = 0;
	}
	
	public void add(Car newCar) {
		oList.add(numObjects, newCar);
		numObjects++;
		Collections.sort(oList);
	}

	public int size() {
		return listSize;
	}

	public Car get(int index) {
		return oList.get(index);
	}

	public boolean isEmpty() {
		if(numObjects == 0){
			return true;
		}
		return false;
	}

	public void remove(int index) {
		oList.remove(index);
		for(int i = (index + 1); i<oList.size();i++){
			oList.
		}
		numObjects--;
	}

}

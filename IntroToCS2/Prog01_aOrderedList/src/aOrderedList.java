import java.util.*;
public class aOrderedList{
	
	final int SIZEINCREMENTS = 20;
	private Car[] oList;
	private int listSize;
	private int numObjects;
	private int curr;
	
	public aOrderedList() {
		oList = new Car[SIZEINCREMENTS];
		listSize = SIZEINCREMENTS;
		numObjects = 0;
	}
	
	public void add(Car newObject) {
		if(numObjects == listSize) {
			Car[] newOList = Arrays.copyOf(oList, listSize + SIZEINCREMENTS);
			oList = newOList;
			listSize += SIZEINCREMENTS;
		}
		oList[numObjects] = newObject;
		numObjects++;
		//Arrays.sort(oList);
	}

	public String toString() {
		String arrayString = "";
		for(Car car : oList){
			arrayString.concat("[" + car.toString() + "]\n");
		}
		return arrayString;
	}

	public int size() {
		return numObjects;
	}

	public Car get(int index) {
		return oList[index];
	}

	public boolean isEmpty() {
		return numObjects == 0;
	}

	public void remove(int index) {
		for(int i = index;i < numObjects - 1;i++){
			oList[i] = oList[i+1];
		}
		oList[numObjects - 1] = null;
		numObjects--;
	}
	
	public void reset() {
		curr = 0;
	}

	public Car next() {
		curr++;
		return oList[curr];
	}

	public boolean hasNext() {
		if(curr < numObjects) {
			return true;
		}
		return false;
	}

	public void remove() {
		remove(curr);
	}
}

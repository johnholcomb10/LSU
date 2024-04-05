import java.util.*;

/**
* The ordered list, which contains the array of cars and controls the adding, sorting, and removing of cars from the array
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

public class aOrderedList{
	
	final int SIZEINCREMENTS = 20;
	private Car[] oList;
	//array of car objects
	private int listSize;
	//available spaces in array
	private int numObjects;
	//number of current objects in array
	private int curr;
	//location of pointer in array
	
    /**
* Contructor for ordered list
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public aOrderedList() {
		oList = new Car[SIZEINCREMENTS];
		listSize = SIZEINCREMENTS;
		numObjects = 0;
	}

	    /**
* Adds car from input file to ordered list
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public void add(Car newObject) {
		if(numObjects == listSize) {
			Car[] newOList = Arrays.copyOf(oList, listSize + SIZEINCREMENTS);
			oList = newOList;
			listSize += SIZEINCREMENTS;
		}
		oList[numObjects] = newObject;
		numObjects++;
		Arrays.sort(oList, Comparator.nullsLast(Comparator.naturalOrder())); 
	}

	    /**
* Prints list of cars into a string
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public String toString() {
		String arrayString = "";
		//printable string for array of cars
		for(int i = 0; i < size(); i++){
			arrayString += "[" + get(i).toString() + "]\n";
		}
		return arrayString;
	}

	    /**
* Returns size of list

* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public int size() {
		return numObjects;
	}

	    /**
* Returns value of specific index in list
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public Car get(int index) {
		return oList[index];
	}

	    /**
* Returns if list is empty or not
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public boolean isEmpty() {
		return numObjects == 0;
	}

	    /**
* Removes desired object from list and shifts other objects into new proper spot
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public void remove(int index) {
		for(int i = index;i < numObjects - 1;i++){
			oList[i] = oList[i+1];
		}
		oList[numObjects - 1] = null;
		numObjects--;
	}

	    /**
* Resets the "next" pointer to beginning of list
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public void reset() {
		curr = 0;
	}

	    /**
* Sets pointer to next space
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public Car next() {
		curr++;
		return oList[curr];
	}

    /**
* Checks if next pointer can exist
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public boolean hasNext() {
		if(curr < numObjects) {
			return true;
		}
		return false;
	}

	    /**
* Removes object located at pointer

* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public void remove() {
		remove(curr);
	}
}

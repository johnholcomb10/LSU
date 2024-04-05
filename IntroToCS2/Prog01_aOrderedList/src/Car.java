
/**
* Car class, which creates the car objects with their respective attributes and compares different car objects.
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

public class Car implements Comparable<Car> {
	
	private String make;
	private int year, price;
	//initial attributes of each car object

	    /**
* Constructor for car
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public Car(String Make, int Year, int Price) {
		make = Make;
		year = Year;
		price = Price;
	}

	    /**
* Returns make of car
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public String getMake() {
		return make;
	}

	    /**
* Returns year of car
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public int getYear() {
		return year;
	}

	    /**
* Returns price of car
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public int getPrice() {
		return price;
	}

	    /**
* Compares two car objects based firstly on make, secondly on year
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/
	
	public int compareTo(Car other) {
		if (make.compareTo(other.make) != 0) {
			return make.compareTo(other.make);
		}
		return -1 * Integer.compare(year, other.year);
	}

	    /**
* Returns car object's attributes as a string
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public String toString() {
		return "Make: " + make + ", Year: " + year + ", Price: " + price;
	}
	
}

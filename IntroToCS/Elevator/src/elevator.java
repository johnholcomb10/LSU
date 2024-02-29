import java.util.Scanner;
public class elevator {
	
	public static void main(String[] args) {
		
		System.out.println("Please enter what floor you would like to go to:");
		Scanner floorScanner = new Scanner(System.in);
		String floorInput = floorScanner.next();
		floorScanner.close();
		String floor = null;
		
		if(floorInput.equals("13")) {
			System.out.println("Floor 13 does not exist!");
			return;
		}
		if(floorInput.equals("G")) {
			floor = "0";
		} else if(floorInput.contains("B")) {
			floor = "-" + floorInput.substring(1);
		} else {
			floor = floorInput;
		}
		
		int floorInt = Integer.parseInt(floor);
		if(floorInt > 13) {
			floorInt = floorInt - 1;
		
		}
		System.out.println("Button " + floorInput + " was pressed, controller go to floor: " + floorInt);
	}
}
	

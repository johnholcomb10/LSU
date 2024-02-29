import java.util.Random;

public class ChadPredictor {

	public static void main(String args []) {
		
		Random randomNumber = new Random();
		int stepsToRoom = 25;
		String chadBehavior = null;
		int disturbances = 0;
		int cycles = 0;
		
		while (stepsToRoom > 0) {
			
			int randomInt = randomNumber.nextInt(100);
			if(randomInt < 15) {
				stepsToRoom -= 2;
				chadBehavior = "took 2 steps forward";
			} else if (randomInt < 50) {
				stepsToRoom --;
				chadBehavior = "took 1 step forward";
			} else if (randomInt < 75) {
				stepsToRoom ++;
				chadBehavior = "took 1 step backward";
			} else if (randomInt < 90) {
				chadBehavior = "stumbled around";
			} else {
				disturbances ++;
				chadBehavior = "swayed side to side and caused a disturbance";
			}
			
			System.out.printf("CHAD %s, and is %d steps away.\n", chadBehavior, stepsToRoom);
			cycles ++;
		}
		
		String raTalk = "";
		if (disturbances < 5) {
			raTalk = "not ";
		}
				
		System.out.printf("CHAD made it to his dorm in %d cycles, caused %d disturbances, and will %shave a talk with his RA tomorrow.", cycles, disturbances, raTalk);
	}
	
}
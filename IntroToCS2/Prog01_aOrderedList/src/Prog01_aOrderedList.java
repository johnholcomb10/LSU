import java.util.*;
import java.io.*;

/**
* This class contains the main method for the whole program and handles the input file, the add/delete operations, and the creation of the final sorted file.
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

public class Prog01_aOrderedList {
	
    /**
* Main method, controls operation of program
*
* CSC 1351 Programming Project No 1
* Section 2
*
* @author John Holcomb
* @since 3/17/24
*
*/

	public static void main(String[] args) {
		aOrderedList newAOrderedList = new aOrderedList();
        //list of cars

		try {
            Scanner fileScanner = getInputScanner();
            //scans file for addition and deletion commands and initial list of cars
            System.out.print("[*]File input found!\n\n");
            
			while(fileScanner.hasNextLine()) {
				String[] parts = fileScanner.nextLine().split(",");
                //separates each line of the input file for its attributes
				if(parts.length == 4) {
                    if(parts[0].equalsIgnoreCase("A")) {
                        Car car = new Car(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                        newAOrderedList.add(car);
                    } 
                } else if(parts.length == 3) {
                    if(parts[0].equalsIgnoreCase("D")) {
                        for(int i = 0; i < newAOrderedList.size(); i++) {
                            if(newAOrderedList.get(i).getMake().equals(parts[1])) {
                                if(newAOrderedList.get(i).getYear() == Integer.parseInt(parts[2])) {
                                    newAOrderedList.remove(i);
                                }
                            }
                        }
                    }
                }
			}
            fileScanner.close();
        } catch (FileNotFoundException e) {
			if(e.getMessage().equals("c")) {
				System.out.println("[*]Program execution cancelled.");
				System.exit(0);
			}
            System.out.println("[!]File not found: " + e.getMessage());
		}

        try {
            Scanner outputFileScanner = new Scanner(System.in);
            System.out.print("[*]Enter the filename for the text output file:\n[>]output.txt\n");

            String userPrompt = "C:\\Users\\johnt\\OneDrive\\Documents\\GitHub\\LSU\\IntroToCS2\\Prog01_aOrderedList\\src\\output.txt";//outputFileScanner.nextLine();
            PrintWriter outputPrintWriter = getOutputFile(userPrompt);
            //printwriter that creates output file and prints sorted list of cars.

            outputPrintWriter.print(newAOrderedList.toString());
            outputPrintWriter.close();
            outputFileScanner.close();
            System.out.print("[*]Data has been written to the file successfully.\n\n");
            return;
        } catch (FileNotFoundException e) {
            if(e.getMessage().equals("c")) {
                System.out.println("[*]Program execution cancelled.");
                System.exit(0);
            }
            System.err.println("[!]An error occurred while writing to the file: " + e.getMessage());
        }
	}

        /**
    * Input scanner that prompts user for input file
    *
    * CSC 1351 Programming Project No 1
    * Section 2
    *
    * @author John Holcomb
    * @since 3/17/24
    *
    */

	public static Scanner getInputScanner() throws FileNotFoundException {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("[*]Enter the filename of the text input file:\n[>]");
            String fileName = scanner.nextLine();

            File file = new File(fileName);
            //the input file

            scanner.close();
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            Scanner userChoice = new Scanner(System.in);
            System.out.print("[!]Invalid input! Would you like to continue? (Y/N)\n[>]");
            String userResponse = userChoice.nextLine();
            if (userResponse.equalsIgnoreCase("Y")) {
                userChoice.close();
                return getInputScanner();
            } else if (userResponse.equalsIgnoreCase("N")) {
                userChoice.close();
                throw new FileNotFoundException("c");
            } else {
                userChoice.close();
                return getInputScanner();
            }
        }
    }

            /**
    * Printwriter that accepts user preference for file name and writes final sorted car list to file
    *
    * CSC 1351 Programming Project No 1
    * Section 2
    *
    * @author John Holcomb
    * @since 3/17/24
    *
    */

	public static PrintWriter getOutputFile(String userPrompt) throws FileNotFoundException {
        PrintWriter printWriter;
        //writes file of sorted list
 
        try {
            printWriter = new PrintWriter(userPrompt);
            return printWriter;
        } catch (FileNotFoundException e) {
            System.out.println("Invalid input! Would you like to continue? (Y/N)");
            Scanner userChoice = new Scanner(System.in);

            if (userChoice.nextLine().equalsIgnoreCase("N")) {
                userChoice.close();
                throw new FileNotFoundException("c");
            } else if (userChoice.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Enter the filename for the text output file: ");
                Scanner newOutput = new Scanner(System.in);
                newOutput.close();
                return getOutputFile(newOutput.nextLine());
            } else {
                userChoice.close();
                return getOutputFile(userChoice.nextLine());
            }
        }
		
	}
}
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
            
			while(fileScanner.hasNextLine()) {
				String[] parts = fileScanner.nextLine().split(",");
                //separates each line of the input file for its attributes
				
				if(parts[0].equals("A")) {
					Car car = new Car(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
					newAOrderedList.add(car);
				} else if(parts[1].equals("D")) {
					for(int i = 0; i < newAOrderedList.size(); i++) {
                        if(newAOrderedList.get(i).getMake().equals(parts[1])) {
                            if(newAOrderedList.get(i).getYear() == Integer.parseInt(parts[2])) {
                                newAOrderedList.remove(i);
                            }
                        }
                    }
				}
			}
            fileScanner.close();
        } catch (FileNotFoundException e) {
			if(e.getMessage().equals("c")) {
				System.out.print("Program execution cancelled.");
				System.exit(0);
			}
            System.out.println("File not found: " + e.getMessage());
		}

		try {
            PrintWriter outputPrintWriter = getOutputFile();
            //printwriter that creates output file and prints sorted list of cars.
            outputPrintWriter.print(newAOrderedList.toString());
            outputPrintWriter.close();
            System.out.println("Data has been written to the file successfully.");
        } catch (FileNotFoundException e) {
			if(e.getMessage().equals("c")) {
				System.out.print("Program execution cancelled.");
				System.exit(0);
			}
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
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
		Scanner scanner = new Scanner(System.in);
        //scans for user console input
        String fileName;
        //name of file
        File file;
        //the input file
 
        while (true) {
            System.out.print("Enter the filename of the text input file: ");
            fileName = scanner.nextLine();
            if (fileName.equalsIgnoreCase("cancel")) {
				scanner.close();
                throw new FileNotFoundException("c");
            }
 
            file = new File(fileName);
            if (file.exists()) {
                System.out.println("Input file found!");
				scanner.close();
                return new Scanner(file);
            } else {
                System.out.println("The file entered is incorrect. Please reenter a corrected value or type 'cancel' to cancel program execution.");
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

	public static PrintWriter getOutputFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
        //scans for user console input
        PrintWriter printWriter = null;
        //writes file of sorted list
        boolean validFilename = false;
        //boolean to check status of file scan
 
        while (!validFilename) {
            System.out.print("Enter the filename for the text output file: ");
            String filename = scanner.nextLine();
 
            try {
                printWriter = new PrintWriter(filename);
                validFilename = true;
            } catch (FileNotFoundException e) {
                System.out.println("Invalid filename. Please enter a valid filename or type 'cancel' to exit.");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("cancel")) {
					scanner.close();
					printWriter.close();
                    throw new FileNotFoundException("c");
                }
            }
        }
		scanner.close();
        return printWriter;
	}
}
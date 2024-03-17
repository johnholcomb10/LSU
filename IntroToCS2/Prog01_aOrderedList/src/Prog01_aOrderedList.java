import java.util.*;
import java.io.*;

public class Prog01_aOrderedList {
	
	public static void main(String[] args) {
		aOrderedList newAOrderedList = new aOrderedList();

		try {
            Scanner fileScanner = getInputScanner();
            
			while(fileScanner.hasNextLine()) {
				String[] parts = fileScanner.nextLine().split(",");
				
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

	public static Scanner getInputScanner() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
        String fileName;
        File file;
 
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

	public static PrintWriter getOutputFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = null;
        boolean validFilename = false;
 
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
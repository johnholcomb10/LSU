import java.util.*;
import java.io.*;
public class Prog01_aOrderedList {
	
	public static void main(String[] args) {
		boolean hasFile;
		Scanner fileInput = new Scanner(System.in);
		
		System.out.println("Enter input filename, or type \"done\" to cancel the program:");
		
		try{
			Scanner reader = getInputFile(fileInput.next());
			hasFile = true;
			fileInput.close();
		} catch (Exception FileNotFoundException) {
			System.out.println("File not found! Try again!\nEnter input filename, or type \"done\" to cancel the program: ");
		}
	}

public static Scanner getInputFile(String fileName) throws FileNotFoundException {
	if(fileName.toLowerCase().equals("done")) {
		System.out.println();
		System.exit(0);
	}
	File readFile = new File(fileName);
	Scanner reader = new Scanner(readFile);
	return reader;
}

}
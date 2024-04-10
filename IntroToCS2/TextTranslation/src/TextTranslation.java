import java.io.*;
import java.util.*;
/*
* This class contains the main method for the whole program and handles the input file, the mapping of keys, and translate user input.
*
* CSC 1351 Lab 6
7
* Section 2
*
* @author John Holcomb
* @since 4/5/24
*
*/
public class TextTranslation {
    /*
	* Main method, controls operation of program
	*
	* CSC 1351 Lab 6
	* Section 2
	*
	* @author John Holcomb
	* @since 4/5/24
	*
	*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //map for abbreviations
        HashMap<String, String> map = new HashMap<>();
        
        File readFile = new File("C:\\Users\\johnt\\OneDrive\\Documents\\GitHub\\LSU\\IntroToCS2\\TextTranslation\\src\\acronyms.txt");
		Scanner scan = null;
		try {
			//scanner that reads input file
			scan = new Scanner(readFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//splits each line of file by comma and maps the abbreviation to the unabbreviated statement
        while(scan.hasNextLine()) {
            String[] thisLine = scan.nextLine().split(",");
            if (thisLine.length == 2) {
            	map.put(thisLine[0].toLowerCase(), thisLine[1].toLowerCase());
            }
        }
        scan.close();

        System.out.println("Enter abbreviated text: ");
        String userInput = scanner.nextLine();
        
        //final unabbreviated input
        String translatedText = "";
        String[] words = userInput.toLowerCase().split("\\s+");
        //hashmap lookup for each word of input
        for(String word : words) {
            if(map.containsKey(word)) {
                word = map.get(word);
            }
            translatedText += (word + " ");
        }
        System.out.println(translatedText);

        scanner.close();
    }
}

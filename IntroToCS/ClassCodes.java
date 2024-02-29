import java.util.Scanner;
public class ClassCodes {

	//ClassCodes - Showcase usage and value of methods
	public static void main(String[] args) {
		Scanner classScan = new Scanner(System.in);
		System.out.println("Please enter you course code");
		String classCode = classScan.nextLine();
		
		String letter = GetLetterCode(classCode);
		System.out.printf("A course with code %s is in the %s department\n", letter, GetDepartmentName(letter));
		
	}
	
	
	
	/**
	 * GetLetterCode - Return the leters from a course code provided
	 * @param className - Course code as a string
	 * @return - THe letter portion of the course code (E.x. "CSC")
	 */
	public static String GetLetterCode(String className) {
		int spacePos = className.indexOf(' ');
		String shortName = className.substring(0,spacePos);
		return shortName;
	}
	/**
	 * GetDepartmentName - Matches the letter code to the full department name
	 * @param dptCode - letter code for department
	 * @return - Department name if found, Empty String otherwise
	 */
	public static String GetDepartmentName(String dptCode) {
		
		switch(dptCode.toUpperCase()) {
		case "CSC": return "Computer Science";
		case "ECON": return "Economics"; 
		case "LA": return "Landscape Architecture";
		case "MC": return "Mass Comminication";
		case "HNRS": return "Honors";
		default: return "";
		}
	}

}

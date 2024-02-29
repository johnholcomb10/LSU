import java.util.Scanner;
public class gradecalculator {

	public static void main(String[] args) {
		
		Scanner gradeScanner = new Scanner(System.in);
		String letter = null;
		System.out.println("Please enter in your grade:");
		boolean check = gradeScanner.hasNextInt();
		
		
		//System.out.println(check);
		
		if(check == true) {		
		int grade = gradeScanner.nextInt();
			if(grade > 100) {
				System.out.println("Grade is illegal!");
				gradeScanner.close();
				return;
				}
				else if(grade < 0) {
				System.out.println("Grade is illegal!");
				gradeScanner.close();
				return;				
				}
				else if(grade >= 90) {
				letter = "A";
				}
				else if (grade >= 80) {
				letter = "B";
				}
				else if (grade >= 70) {
				letter = "C";
				}
				else if (grade >= 60) {
				letter = "D";
				}
				else {
				letter = "F";
			}
			
			if(grade % 10 == 0) {
				if(grade == 100) {
				System.out.println("Congratulations!");	
				letter = letter + "+";
					} else {
					letter = letter + "-";
					}
				}
				else if(grade % 10 == 1) {
				letter = letter + "-";
				}
				else if(grade % 10 == 2) {
				letter = letter + "-";
				}
				else if(grade % 10 == 7) {
				letter = letter + "+";
				}
				else if(grade % 10 == 8) {
				letter = letter + "+";
				}
				else if(grade % 10 == 9) {
				letter = letter + "+";
			}
		
		System.out.println("With a grade of " + grade + ", you would receive a " + letter);
		}
		
		if(check != true) {
			System.out.println("Not an integer!");
			gradeScanner.close();
			return;
		}

		gradeScanner.close();
	}

}
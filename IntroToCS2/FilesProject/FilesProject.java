//Student Name: John Holcomb
//LSU ID: 890963950
//Lab Section: CSC 1351-2 Rm 2326

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FilesProject {

	public static void main(String[] args) throws FileNotFoundException{
		
		Random rand = new Random();
		PrintWriter newFile = new PrintWriter ("calculations.txt");
		
		for(int i = 0; i < 1000; i++) {	
			newFile.println(rand.nextInt(1001));
		}
		newFile.close();
		
		System.out.printf("The average of the numbers in the file is: %.2f", calcAvg("calculations.txt"));
		
	}
	
	public static double calcAvg(String filename) throws FileNotFoundException {
		
		File readFile = new File(filename);
		Scanner scan = new Scanner(readFile);
		double total = 0;
		double count = 0;
		while(scan.hasNextInt()) {
			total = total + scan.nextInt();
			count++;
		}
		scan.close();
		return total/count;
		
	}
	
}

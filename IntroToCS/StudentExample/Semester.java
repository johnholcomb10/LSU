
public class Semester {

	int Semester_Year;
	String Semester_Name;
	
	public Semester(int year, String name) {
		Semester_Year = year;
		Semester_Name = name;
	}
	
	public static Semester GetCurrentSemester() {
		return new Semester(2023, "Fall");
	}
}

import java.util.ArrayList;
public class Student {
	private String name; 
	private String email_address; 
	private long id_num; 
	private String Classification; //freshmen, Sophmore, etc.
	private String Major;
	
	private ArrayList<Course> current_courses;
	
	//boolean fullTime;
	private int current_hours;
	private int total_hours;
	private double GPA;
	private double Tuition;
	
	private int age;
	private boolean virtual;
	
	private static long last_Id = 8900000;
	
	//Campus
	
	public Student(String name) {
		this.name = name;
		email_address = GenerateEmail(name);
		id_num = GenerateId();
		Major = "Undecided";
		current_courses = new ArrayList<Course>();
		total_hours = 0;
		UpdateClassification();
		
	}
	
	public String GetName() {
		return this.name;
	}
	
	public String GetEmail() {
		return this.email_address;
	}
	
	public long GetID() {
		return this.id_num;
	}
	
	public String GetMajor() {
		return this.Major;
	}
	
	public String GetClassification() {
		return this.Classification;
	}
	
	public String SetMajor(String newMajor) {
		String oldval = this.Major;
		Major = newMajor;
		return oldval;
	}
	
	public String UpdateClassification() {
		String oldval = this.Classification;
		if(total_hours > 90) {
			Classification = "Senior";
		}
		else if(total_hours > 60) {
			Classification = "Junior";
		}
		else if(total_hours > 30) {
			Classification = "Sophomore";
		}
		else {
			Classification = "Freshman";
		}
		return oldval;
	}
	
	
	public boolean Equals(Object other) {
		return false;
	}
	
	private static String GenerateEmail(String Name) {
		return "";
	}
	
	private static long GenerateId() {
		long idVal = Student.last_Id;
		Student.last_Id++;
		return idVal;
	}
}

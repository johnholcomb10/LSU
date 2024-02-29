
public class Course {
	private int capacity;
	private int enrollment;
	private String courseName;
	private String courseID;
	
	//String semester_name;
	//int semester_year;
	Semester semester;
	
	private Student roster[];
	
	public Course(int capacity) {
		this.capacity = capacity;
		courseID = "";
		courseName = "";
		enrollment = 0;
		roster = new Student[capacity];
		semester = Semester.GetCurrentSemester();
	}
	
	public Course(int capacity, String id) {
		this.capacity = capacity;
		courseID = id;
		courseName = "";
		enrollment = 0;
		roster = new Student[capacity];
		semester = Semester.GetCurrentSemester();
	}
	
	public Course(int capacity, String id, String name) {
		this.capacity = capacity;
		courseID = id;
		courseName = name;
		enrollment = 0;
		roster = new Student[capacity];
		semester = Semester.GetCurrentSemester();
	}
	public Course(int capacity, String id, String name, Semester sem) {
		this.capacity = capacity;
		courseID = id;
		courseName = name;
		enrollment = 0;
		roster = new Student[capacity];
		semester = sem;
	}

	public String GetId() {
		return this.courseID;
	}
	
	public String GetName() {
		return this.courseName;
	}
	public int GetCapacity() {
		return this.capacity;
	}
	
	public Semester GetSemester() {
		return this.semester;
	}
	
	public String SetId(String id) {
		String oldval = this.courseID;
		this.courseID = id;
		return oldval;
	}
	
	public String SetCourseName(String name) {
		String oldval = this.courseName;
		this.courseName = name;
		return oldval;
	}
	
	public Semester SetSemester(Semester sem) {
		Semester oldval = this.semester;
		semester = sem;
		return oldval;
	}
	
	public int SetCapacity(int newCapacity) {
		if(newCapacity < this.capacity) {
			return -1;
		}
		int oldval = this.capacity;
		capacity = newCapacity;
		//Copy Array with new size
		
		return oldval;
		
	}
	
	public boolean EnrollStudent(Student newStudent) {
		
		if(enrollment == capacity) {
			return false;
		}
		
		roster[enrollment] = newStudent;
		enrollment++;
		
		return true;
	}
	
	public Student Withdraw(Student wstudent) {
		
		int place = 0;
		//Search for student - done
		while(!roster[place].Equals(wstudent) && place < enrollment) {
			place++;
		}
		if (place >= enrollment) {
			return null;
		}
		//Remove from array
		//Update array by shifting
		for(int i = place; i < enrollment; i++) {
			roster[i] = roster[i+1];
		}
		enrollment--;
		roster[enrollment] = null;		
		
		return wstudent;
	}
	
	
	
	
}

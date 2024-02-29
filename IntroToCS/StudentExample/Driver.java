
public class Driver {

	public static void main(String[] args) {
		CourseDriver();
		StudentDriver();

	}
	
	public static void CourseDriver() {
		System.out.println("[*]Starting Course Driver...");
		Course c1 = new Course(30,"CSC 4210","Intro to Computer Things");
		Semester sem1 = new Semester(2022, "Fall");
		c1.SetSemester(sem1);
		Course c2 = new Course(70,"CSC 4103","Operating Systems");	
		c2.SetSemester(sem1);
		Course c3 = new Course(80,"CSC 2259","Discrete Structures");
		c3.SetSemester(sem1);
		
		System.out.printf("[*]%s - %s has a capacity of %d students\n",c1.GetId(),c1.GetName(),c1.GetCapacity());
		System.out.printf("[*]%s - %s has a capacity of %d students\n",c2.GetId(),c2.GetName(),c2.GetCapacity());
		System.out.printf("[*]%s - %s has a capacity of %d students\n",c3.GetId(),c3.GetName(),c3.GetCapacity());
		
	}

	public static void StudentDriver() {
		Student bob = new Student("bob");
		
		
		
	}
	
}

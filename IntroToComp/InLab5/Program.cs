using System;
using System.Reflection.Metadata;

// Student objects
class Student
{
    // Auto-property for student's name
    // Read and modify from outside of class
    public string Name { get; set;}

    // Auto-property for course hours completed
    // Read from outside class, modified only within class
    public int CHcompleted { get; private set;}

    // Auto-property for student's classification
    // Read from outside class, modified only within class
    public decimal GPA { get; private set; }

    // Auto-property for student's classification
    // Read-only from inside and outside of class
    public int Classification {
        
        // Determine student's classification based on number of hours completed
        get
        {
            // Freshman
            if (CHcompleted < 30){
                return 2;
            }
            // Sophomore
            else if (CHcompleted < 60)
            {
                return 2;
            }
            // Junior
            else if (CHcompleted < 90)
            {
                return 3;
            }
            // Senior
            else
            {
                return 4;
            }
        }
    }

    // Static Variable that stores the highest GPA among all students
    // Belongs to class, not individual objects
    static decimal highGPA = 0.0m;

    // Read outside of class, modify only within class
    static public decimal HighestGPA
    {
        get
        {
            // Return highest GPA among all students
            return highGPA;
        }

        private set
        {
            // Update only if new GPA is higher
            if (value > highGPA)
            {
                highGPA = value;
            }
        }
    }

    // Student object constructor, can be accessed outside of class
    public Student (string Name, decimal GPA, int CHcompleted)
    {
        this.Name = Name;
        this.GPA = GPA;
        this.CHcompleted = CHcompleted;

        // If updated GPA is higher, set HighestGPA to updated GPA
        HighestGPA = Math.Max(GPA, HighestGPA);
    }

    //
    public void Update (int CourseCH, decimal CourseGrade)
    {
        // Determine GPA
        GPA = ((GPA * CHcompleted) + CourseGrade * CourseCH) / (CHcompleted * CourseCH);

        // Add new course hours to total
        CHcompleted += CourseCH;

        // Set new highest GPA
        // If updated GPA is higher, set HighestGPA to updated GPA
        HighestGPA = Math.Max(GPA, HighestGPA);
    }
}

// Main class
class Program
{
    static void Main (string[] args)
    {
        // Create new student object S
        Student S = new Student("Bob", 3.2M, 45);

        // Change name of student S
        S.Name = "Jane";

        // Display student's GPA, credit hours, classification
        Console.WriteLine("GPA: {0}, CJ: {1}, Rank: {2}", S.GPA, S.CHcompleted, S.Classification);

        // Update student S with new course
        S.Update(3, 4.1M);

        // Create new student object S2
        Student S2 = new Student("John", 4.1M, 60);

        // Display GPA and highest GPA among all students
        Console.WriteLine("Bob GPA: {0}, High GPA: {1}", S.GPA, Student.HighestGPA);
    }
}
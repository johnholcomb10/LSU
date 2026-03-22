using System;
using System.Security.Cryptography;

// Course Offering object class
public class CourseOffering
{
    // Initialize variables
    // Can be read outside of class, modified only within class
    public string CourseTitle { get; private set; }
    public string CourseNumber { get; private set; }
    public string Semester { get; private set; }
    public int SecNum { get; private set; }
    public int CreditHours { get; private set; }
    public string Schedule { get; private set; }
    public string Instructor { get; private set; }
    public int MaxEnrollment { get; private set; }
    public int CurrentEnrollment { get; private set; }
    public string Status { get; private set; }

    // Course Offering constructor
    // MaxEnrollment, Current Enrollment, and Status are optional arguments
    public CourseOffering (string CourseTitle, string CourseNumber, string Semester, int SecNum, int CreditHours, string Schedule, string Instructor, int MaxEnrollment = 50, int CurrentEnrollment = 0, string Status = "active")
    {
        // Set object variables equal to constructor arguments
        this.CourseTitle = CourseTitle;
        this.CourseNumber = CourseNumber;
        this.Semester = Semester;
        this.SecNum = SecNum;
        this.CreditHours = CreditHours;
        this.Schedule = Schedule;
        this.Instructor = Instructor;
        this.MaxEnrollment = MaxEnrollment;
        this.CurrentEnrollment = CurrentEnrollment;
        this.Status = Status;
    }

    // Modify class enrollment
    // Returns true if successful, false if unsuccessful
    public Boolean ChangeMaxEnrollment (int amount)
    {
        // Determine if new max enrollment is allowable
        if ((MaxEnrollment + amount) >= CurrentEnrollment)
        {
            // Max Enrollment >= Current Enrollment: Change Max Enrollment
            MaxEnrollment += amount;
            return true;
        }
        // Max Enrollment < Current Enrollment: Set Max Enrollment equal to Current Enrollment
        MaxEnrollment = CurrentEnrollment;
        return false;
    }

    // Cancel class
    public void CancelClass ()
    {
        // Eliminate enrollment and set status to cancelled
        MaxEnrollment = 0;
        CurrentEnrollment = 0;
        Status = "Cancelled";
    }

    static void Main (string[] args)
    {
        // course1 initialization
        CourseOffering course1 = new CourseOffering("course1", "ABC101", "Spring 2026", 1, 3, "MWF 12:30-1:20", "Professor", 20, 10, "Active");

        // Display course1 information
        Console.WriteLine($"{course1.CourseTitle}\n{course1.CourseNumber} section {course1.SecNum} ({course1.CreditHours})\n{course1.Schedule}\n{course1.Instructor}\n{course1.CurrentEnrollment} out of {course1.MaxEnrollment} enrolled\n{course1.Status}\n");

        // Attempt max enrollment change on course1
        Boolean firstCourse1ChangeMax = course1.ChangeMaxEnrollment(5);
        if (firstCourse1ChangeMax)
        {
            // Max enrollment change successful
            Console.WriteLine($"Change to {course1.CourseTitle} max enrollment was successful.\nCurrent Enrollment: {course1.CurrentEnrollment}\nMax Enrollment: {course1.MaxEnrollment}\n");
        }
        else
        {
            // // Max enrollment change unsuccessful
            Console.WriteLine($"Change to {course1.CourseTitle} max enrollment was unsuccessful. Set max enrollment to current enrollment.\nCurrent Enrollment: {course1.CurrentEnrollment}\nMax Enrollment: {course1.MaxEnrollment}\n");
        }

        // Attempt max enrollment change on course1
        Boolean secondCourse1ChangeMax = course1.ChangeMaxEnrollment(-25);
        if (secondCourse1ChangeMax)
        {
            // Max enrollment change successful
            Console.WriteLine($"Change to {course1.CourseTitle} max enrollment was successful.\nCurrent Enrollment: {course1.CurrentEnrollment}\nMax Enrollment: {course1.MaxEnrollment}\n");
        }
        else
        {
            // Max enrollment change unsuccessful
            Console.WriteLine($"Change to {course1.CourseTitle} max enrollment was unsuccessful. Set max enrollment to current enrollment.\nCurrent Enrollment: {course1.CurrentEnrollment}\nMax Enrollment: {course1.MaxEnrollment}\n");
        }

        // Cancel class
        course1.CancelClass();
        Console.WriteLine($"{course1.CourseTitle} status changed to {course1.Status}.");
    }
}
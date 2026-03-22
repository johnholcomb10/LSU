using System;

// User object class
public class User
{
    // Initialize User object variables
    // All can be read outside of class
    // All can be modified outside of class except for UserName, DateTimeCreated. and NumberUsersCreated
    private static int numberUsersCreated;
    public string UserName { get; private set; }
    public DateTime DateTimeCreated { get; private set; }
    public static int NumberUsersCreated { get; private set; }
    public string Firstname { get; set; }
    public string Lastname { get; set; }
    public string Email { get; set; }
    public string Cell { get; set; }
    public string SecurityQuestion { get; set; }
    public string SecurityAnswer { get; set; }
    public bool Active { get; set; }
    public string HomePhone { get; set; }
    public string Address { get; set; }
    public string SecondSecurityQuestion { get; set; }
    public string SecondSecurityAnswer { get; set; }

    // User object constructor
    // Takes username argument
    public User(string newUserName)
    {
        UserName = newUserName;
        DateTimeCreated = DateTime.Now;
        NumberUsersCreated++;
    }
}

// Main program class
public class Program
{
    // Main method
    static void Main(string[] args)
    {
        // Create new user
        User user1 = new User("user1");

        // Set attributes for user object
        user1.HomePhone = "1112223333";
        user1.Address = "123 ABC Road, Anytown, USA 12345";
        user1.SecondSecurityQuestion = "What is your name?";
        user1.SecondSecurityAnswer = "user1";
        
        // Display user information
        Console.Write("User: {0}\nHome Phone: {1}\nAddress: {2}\nSecond Security Question: {3}\nSecond Security Answer: {4}", user1.UserName, user1.HomePhone, user1.Address, user1.SecondSecurityQuestion, user1.SecondSecurityAnswer);
    }
}

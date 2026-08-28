using System;

class Program
{
    static void Main(string[] args)
    {
        // Get user input
        Console.WriteLine("Enter a date:");
        string dateTimeString = Console.ReadLine();

        // Determine month from input datetime
        DateTime d = DateTime.Parse(dateTimeString);
        int month = d.Month;

        // Determine number of days in given month
        int numberOfDays;
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numberOfDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDays = 30;
                break;
            case 2:
                // Calculate whether given date is during Leap Year
                if ((d.Year % 4 == 0) && ((d.Year % 100 != 0) || (d.Year % 400 == 0)))
                {
                    // Is Leap Year
                    numberOfDays = 29;
                }
                else
                {
                    // Is not Leap Year
                    numberOfDays = 28;
                }
                break;
            default:
                Console.WriteLine("Invalid month.");
                return;
        }

        // Print out number of days in month
        Console.WriteLine($"This month has {numberOfDays} days.");
    }
}
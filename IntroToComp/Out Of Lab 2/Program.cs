using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main(string[] args)
    {
        // Get inputs from user
        Console.WriteLine("Enter first date: ");
        string firstDateInput = Console.ReadLine();

        Console.WriteLine("Enter second date: ");
        string secondDateInput = Console.ReadLine();

        Console.WriteLine("Enter string: ");
        string inputString = Console.ReadLine().ToUpper();

        // Parse user inputs for dates
        DateTime firstDateTime, secondDateTime;
        if (DateTime.TryParse(firstDateInput, out firstDateTime))
        {
            // continue to Date 2 input
            if (DateTime.TryParse(secondDateInput, out secondDateTime))
            {
                // continue to rest of program
            }
            else
            {
                // Invalid datetime input
                Console.WriteLine("Error in datetimes!");
                return;
            }
        }
        else
        {
            // Invalid datetime input
            Console.WriteLine("Error in datetimes!");
            return;
        }

        // Check which date is earlier
        int dateComparison = DateTime.Compare(firstDateTime, secondDateTime);
        if (dateComparison < 0)
        {
            Console.WriteLine("Date 1 is before Date 2.");
        }
        else if (dateComparison > 0)
        {
            Console.WriteLine("Date 2 is before Date 1.");
        }
        else
        {
            Console.WriteLine("Date 1 and Date 2 are on the same date.");
        }

        // Find difference between dates and print in terms of minutes
        double dateDifferenceSeconds = Math.Abs((firstDateTime - secondDateTime).TotalSeconds);
        Console.WriteLine($"Difference in minutes: {(dateDifferenceSeconds / 60):n2}");

        // Determine whether the first date is during a leap year
        if (DateTime.IsLeapYear(firstDateTime.Year))
        {
            Console.WriteLine("Is Leap Year? True");
        }
        else
        {
            Console.WriteLine("Is Leap Year? False");
        }

        // Replace ^ with LSU and eliminate any substrings between two brackets
        inputString = inputString.Replace("^", "LSU");
        inputString = Regex.Replace(inputString, @"\[.*?\]", "");
        Console.WriteLine($"String: {inputString}");
    }
}
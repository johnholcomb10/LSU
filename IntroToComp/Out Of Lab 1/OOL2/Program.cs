using System;

class Program
{
    static void Main(string[] args)
    {
        // Get names and ages of two people
        string nameA, nameB;
        int ageA, ageB;
        Boolean result;

        Console.Write("Enter first person's name: ");
        nameA = Console.ReadLine();

        Console.Write("Enter first person's age: ");
        ageA = Convert.ToInt32(Console.ReadLine());

        Console.Write("Enter second person's name: ");
        nameB = Console.ReadLine();

        Console.Write("Enter second person's age: ");
        ageB = Convert.ToInt32(Console.ReadLine());

        // Set value of result
        result = ((ageA > ageB) && (ageB >= 30)) || ((ageA <= (ageB - 10)) && (ageB != 50));

        // Write out result
        Console.WriteLine("For " + nameA + " and " + nameB + ", the result is: " + result.ToString());
    }
}
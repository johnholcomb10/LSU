using System;
using System.Reflection;

class Program
{
    static void Main(string[] args)
    {
        // Declare variables
        int Y;
        double X = 2.0, Z = 4.3;
        string S = "Enter a number: ";

        // Read in string from user and convert to integer
        // Multiply by X and store back in X
        Console.WriteLine(S);
        X *= Convert.ToDouble(Console.ReadLine());

        // Calculation for Y
        Y = Convert.ToInt32((Z + Math.Pow(X, 3)) / (3 * Math.Sin(X) + 14));

        // Write out values of X and Y
        Console.WriteLine("X: " + X.ToString());
        Console.WriteLine("Y: " + Y.ToString());
    }
}
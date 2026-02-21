using System;

class Program
{
    static void Main(string[] args)
    {
        // Assume x is defined as double with example value of 2.5
        double x = 2.5;

        // Compute expression, assign result to z
        double z = (Math.Pow(x, 2) + Math.Sqrt(x) + Math.Log(12)) / (Math.Sin(x) + 6);

        // Display result
        Console.WriteLine("Z: " + z);

        // Read line to pause program
        Console.ReadLine();
    }
}
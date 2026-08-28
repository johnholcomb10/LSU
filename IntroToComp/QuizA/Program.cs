using System;

class Program
{
    static void Main(string[] args)
    {
        // Set arbitrary value for n
        int n = 63;

        // Evaluate if n meets any conditions: 60 <= n <= 65 or n >= 200
        if (((n >= 60) & (n <= 65)) || (n >= 200))
        {
            // Multiply n by 2
            n *= 2;
        } 
        // Fall through
        else
        {
            // Calculate square root of n divided by cos(30 degrees) and assign to n
            n = Convert.ToInt32(Math.Sqrt(n) / Math.Cos(30 * Math.PI / 180));
        }

        // Print result
        Console.WriteLine($"N = {n}");
    }
}
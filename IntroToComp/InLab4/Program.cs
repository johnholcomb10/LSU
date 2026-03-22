using System;

class Program
{
    static void Main(string[] args)
    {
        // Initizalize n
        int n;
        try
        {
            // Get integer input from user
            Console.WriteLine("Enter N > 0:");
            n = int.Parse(Console.ReadLine());

            if (n > 0)
            {
                // Initialize sum
                double sum = 0.0;
                // Calculate sum based on n
                for (int k = 1; k <= n; k++)
                {
                    sum += Math.Pow(Math.Log(k * 100.0), 2.0);
                }
                // Write sum to console
                Console.WriteLine($"{sum}");
            }
            else
            {
                // Write invalid numeric value warning to console
                Console.WriteLine("Not a numeric value greater than 0!");
            }
        }
        catch (FormatException)
        {
            // Write invalid input (not an integer) warning to console
            Console.WriteLine("Invalid input. Please enter a valid integer value.");
        }
        catch (OverflowException)
        {
            // Write invalid input (out of bounds) warning to console
            Console.WriteLine("Input is too large. Please enter a smaller value.");
        }
    }
}

// Green: Comment
// Pink: Function
// Orange: String
// Yellow: Method
// Blue: Class type
// Dark Green: Class
// Light Green: Constant

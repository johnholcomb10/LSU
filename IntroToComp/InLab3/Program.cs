using System;

public class TaxCalculator
{
    public static string CalculateTaxRate(string state)
    {
        string taxRate;

        if (state.Equals("KS"))
        {
            taxRate = "6.15%";
        }
        else if (state.Equals("MS"))
        {
            taxRate = "7%";
        }
        else if (state.Equals("IA") || state.Equals("FL") )
        {
            taxRate = "6%";
        }
        else if (state.Equals("LA") || state.Equals("GA"))
        {
            taxRate = "4%";
        }
        else
        {
            taxRate = "3%";
        }

        return taxRate;
    }
}

class Program
{
    static void Main()
    {
        Console.Write("Enter state code: ");
        string state = Console.ReadLine().ToUpper(); // Convert to uppercase for case-insensitive comparison

        string taxRate = TaxCalculator.CalculateTaxRate(state);

        Console.WriteLine($"Tax rate for {state} is {taxRate}");
    }
} 

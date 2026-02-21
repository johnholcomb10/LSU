using System;

class Program
{
    static void Main(string[] args)
    {
        // Insert weight in pounds
        Console.WriteLine("Enter weight in pounds: ");
        double weightInPounds = Convert.ToDouble(Console.ReadLine());

        // Insert height in feet
        Console.WriteLine("Enter weight in feet: ");
        double heightInFeet = Convert.ToDouble(Console.ReadLine());

        // Convert weight from pounds to kilograms (1 lb = 0.453592 kg)
        double weightInKilograms = weightInPounds * 0.453592;

        // Convert height from feet to meters (1 ft = 0.3048m)
        double heightInMeters = heightInFeet * 0.3048;

        // Display results
        Console.WriteLine($"Weight in kilograms: {weightInKilograms} kg\nHeight in meters: {heightInMeters} m");
    }
}
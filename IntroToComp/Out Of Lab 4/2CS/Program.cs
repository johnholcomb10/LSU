using System;

class Program
{
    static void Main(string[] args)
    {
        // Prompt user for input and save to string
        Console.Write("Enter string: ");
        string userInput = Console.ReadLine();

        // Split input into substrings between commas and semicolons
        string[] inputs = userInput.Split(',', ';');

        // Parse each substring
        foreach (var input in inputs)
        {
            try
            {
                // If substring is a number, print in intended format
                double n = Convert.ToDouble(input);
                Console.WriteLine($"{n,15:n3}");
            }
            // Substring is not a number
            catch
            {
                // Determine if substring is a date
                DateTime dateInput;
                if (DateTime.TryParse(input, out dateInput))
                {
                    // Print date in intended format
                    Console.WriteLine(dateInput.ToString("dddd, MMMM d, yyyy"));
                    continue;
                }

                // If substring contains a capital B, append an exclamation mark to the end
                if (input.IndexOf('B') != -1)
                {
                    // Print substring with appended exclamation mark and without leading spaces
                    Console.WriteLine($"{input.TrimStart()}!");
                    continue;
                }

                // Print substring without leading spaces
                Console.WriteLine(input.TrimStart());
            }
        }
    }
}
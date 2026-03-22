using System;

class Program
{
    static void Main(string[] args)
    {
        // Initialize register balance
        double registerBalance = 0;

        // Get starting register balance
        Boolean hasRegisterBalance = false;
        while (!hasRegisterBalance)
        {
            try
            {
                // Prompt user for initial register balance
                Console.Write("Enter initial cash register balance: ");
                registerBalance = Convert.ToDouble(Console.ReadLine());

                // Throw exception for negative beginning balance
                if (registerBalance < 0)
                {
                    throw new Exception();
                }

                // Continue to transactions
                hasRegisterBalance = true;
            }
            catch
            {
                // Invalid input exceptions
                Console.WriteLine("Invalid input. Please try again...\n");
            }
        }

        // Transactions
        Boolean logOut = false;
        while (!logOut)
        {
            // Write current balance to console
            Console.WriteLine($"\nCurrent balance: ${registerBalance:n2}");

            // Prompt user for input
            Console.Write("Enter transaction amount, or type \"LOGOUT\" to end session: ");
            string transactionInput = Console.ReadLine();

            // Determine if user wants to quit
            if (transactionInput.Equals("LOGOUT"))
            {
                // Print final balance, then exit program
                Console.WriteLine($"\nFinal balance: ${registerBalance:n2}\nEnding session...");
                return;
            }

            try
            {
                // Parse user input
                double transactionDouble = Convert.ToDouble(transactionInput);

                // Determine if negative transaction would draw too much money
                if (transactionDouble < (-1 * registerBalance))
                {
                    // Block transaction
                    throw new OverflowException();
                }

                // Update balance
                registerBalance += transactionDouble;
            }
            catch (OverflowException)
            {
                // Invalid transaction amount
                Console.WriteLine("Transaction value too large. Please try again...");
            }
            catch
            {
                // Invalid user input
                Console.WriteLine("Invalid input. Please try again...");
            }
        }
    }
}
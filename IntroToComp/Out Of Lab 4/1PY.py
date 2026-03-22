import sys

# Initialize register balance
registerBalance = 0.0

# Get starting register balance
hasRegisterBalance = 0
while hasRegisterBalance == 0:
    try:
        # Prompt user for initial register balance
        registerBalance = float(input("Enter initial cash register balance: "))

        # Throws exception for negative beginning balance
        if registerBalance < 0:
            raise Exception
        
        # Continue to transactions
        hasRegisterBalance = 1
    except:
        # Invalid input exceptions
        print("Invalid input. Please try again...\n")

# Transactions
logOut = 0
while logOut == 0:
    # Write current balance to console
    print(f"\nCurrent balance: ${registerBalance:,.2f}")

    # Prompt user for input
    transactionInput = input("Enter transaction amount, or type \"LOGOUT\" to end session: ")

    # Determine if user want to quit
    if transactionInput.__eq__("LOGOUT"):
        # Print final balance, then exit program
        print(f"\nFinal Balance: ${registerBalance:,.2f}\nEnding session...")
        sys.exit(0)

    try:
        # Parse user input
        transactionFloat = float(transactionInput)

        # Determine if negative transaction would draw too much money
        if transactionFloat < (-1 * registerBalance):
            # Block transaction
            raise OverflowError
        
        # Update balance
        registerBalance += transactionFloat
    except OverflowError:
        # Invalid transaction amount
        print("Transaction too large. Please try again...")
    except:
        # Invalid user input
        print("Invalid input. Please try again...")

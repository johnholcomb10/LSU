# import math functions
import math

try:
    # get integer input from user
    n = int(input("Enter n > 0: "))

    # determine whether n is valid or not
    if n > 0:
        # Initizalize sum
        sum = 0.0
        # calculate sum based on n
        for k in range (1, n + 1):
            # save to sum
            sum += math.pow(math.log(k * 100), 2.0)
        # Write sum to console
        print(f"{sum}")
    else:
        # Invalid numeric value warning
        print("Not a numeric value greater than 0!")
except ValueError:
    # Not an integer warning
    print("Invalid input. Please enter a valid integer value.")
except OverflowError:
    # Invalid number warning
    print("Input is too large. Please enter a smaller value.")

# Equivalency if each term in C#
# input: Console.Read()
# f: $
# ValueError: FormatException
# OverflowError: OverflowException
# print: Console.Write()
# import: using

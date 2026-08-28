from datetime import datetime
import sys

# Get user input
print("Enter a date:")
inputDateTime = input()

# Determine month from input datetime
d = datetime.strptime(inputDateTime, "%m/%d/%Y")
month = d.month

# Determine number of days in given month
match month:
    case 1 | 3 | 5 | 7 | 8 | 10 | 12:
        numberOfDays = 31
    case 4 | 6 | 9 | 11:
        numberOfDays = 30
    case 2:
        # Calculate whether given date is during Leap Year
        if ((d.year % 4 == 0) & ((d.year % 100 != 0) | (d.year % 400 == 0))):
            # Is Leap Year
            numberOfDays = 29
        else:
            # Is not Leap Year
            numberOfDays = 28
    case _:
        print("Invalid month.")
        sys.exit(1)

# Print out number of days in month
print(f"This month has {numberOfDays} days.")

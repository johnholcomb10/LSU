from datetime import datetime, timedelta
import sys
import re

# Get inputs from user
print("Enter first date: ")
firstDateInput = input()

print("Enter second date: ")
secondDateInput = input()

print("Enter string: ")
inputString = input().upper()

# Parse user input for first date
try:
    firstDateTime = datetime.strptime(firstDateInput, "%m/%d/%y %I:%M%p")
except ValueError:
    # Try second acceptable format
    try:
        firstDateTime = datetime.strptime(firstDateInput, "%m/%d/%y")
    except ValueError:
        # Invalid datetime input
        print("Error in datetimes!")
        sys.exit(1)

# Parse user input for second date
try:
    secondDateTime = datetime.strptime(secondDateInput, "%m/%d/%y %I:%M%p")
except ValueError:
    # Try second acceptable format
    try:
        secondDateTime = datetime.strptime(secondDateInput, "%m/%d/%y")
    except ValueError:
        # Invalid datetime input
        print("Error in datetimes!")
        sys.exit(1)

# Evaluate which date is earlier
if (firstDateTime < secondDateTime):
    print("Date 1 is before Date 2.")
elif (firstDateTime > secondDateTime):
    print("Date 2 is before Date 1.")
else:
    print("Date 1 and Date 2 are on the same date.")

# Evaluate difference between dates and print in terms of minutes
dateDifference = abs((firstDateTime - secondDateTime).total_seconds() / 60)
print(f"Difference in minutes: {dateDifference:,.2f}")

# Determine whether the first date is during a leap year
if (firstDateTime.year % 4 == 0):
    print("Is Leap Year? True.")
else:
    print("Is Leap Year? False.")

# Replace ^ with LSU and eliminate substrings between two brackets
inputString = inputString.replace("^", "LSU")
inputString = re.sub("[\[].*?[\]]", "", inputString)
print(f"String: {inputString}")

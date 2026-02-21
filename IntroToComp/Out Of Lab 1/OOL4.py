# Get names and ages of two people
nameA = input("Enter first person's name: ")
ageA = int(input("Enter first person's age: "))

nameB = input("Enter second person's name: ")
ageB = int(input("Enter second person's age: "))

# Set value for result
Result = ((ageA > ageB) & (ageB >= 30)) | ((ageA <= (ageB - 10)) & (ageB != 50))

# Write out result
print("For " + nameA + " and " + nameB + ", the result is: " + str(Result))
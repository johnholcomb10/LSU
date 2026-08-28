# Initialize variables
import math
X = 2.0
Z = 4.3
S = "Enter a number: "

# Read in string from user, convert to integer
# Multiply by X, store back in X
X *= float(input(S))

# Calculation for Y
Y = round((Z + X ** 3) / (3 * math.sin(X) + 14))

# Write out values of X and Y
print("X: " + str(int(X)))
print("Y: " + str(Y))
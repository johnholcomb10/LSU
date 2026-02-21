# Insert weight in pounds
weightInPounds = float(input("Enter weight in pounds: "))

# Enter height in feet
heightInFeet = float(input("Enter height in feet: "))

# Conversion from lb to kg
weightInKilograms = weightInPounds * 0.453592

# Conversion from ft to m
heightInMeters = heightInFeet * 0.3048

# Display results
print(f"Weight in kilograms: {weightInKilograms} kg\nHeight in meters: {heightInMeters} m")
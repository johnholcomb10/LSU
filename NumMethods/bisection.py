import numpy as np
def bisection_method(a, b, func, tol):
    # Check if the initial interval is valid
    if func(a) * func(b) >= 0:
        print("The function has the same sign at the endpoints a and b.")
        return None
    
    count = 0
    # Bisection method loop
    while (b - a) / 2 > tol:
        count += 1
        print(count)
        c = (a + b) / 2  # Midpoint
        if func(c) == 0:  # Solution found
            return c
        elif func(a) * func(c) < 0:  # Root is in the left half
            b = c
        else:  # Root is in the right half
            a = c
    
    return (a + b) / 2  # Approximate root

# Example usage
def example_function(x):
   return np.log(x) - np.sin(x) # ln(x) - sin(x)
   # x**6 - x -1  # Example function f(x) = x^6 - x -1
    
a = 1.5 # Left endpoint
b = 2.5  # Right endpoint
tol = 1e-10  # Tolerance

root = bisection_method(a, b, example_function, tol)
print(f"The root is approximately: {root}")
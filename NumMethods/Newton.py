# -*- coding: utf-8 -*-
"""
Created on Wed Mar  5 21:19:25 2025

@author: abeer
"""
import math as math
def newtons_method(f, f_driv, x0, tolerance=10**(-12), max_iterations=100):
    """
    Uses Newton's Method to approximate the root of f(x) = 0.
    
    Parameters:
    f: Function representing f(x)
    f_driv: Function representing the derivative of f(x)
    x0: Initial guess
    tolerance: The tolerance for stopping criteria
    max_iterations: The maximum number of iterations allowed
    
    Returns:
    x: The approximated root of f(x) = 0
    """
    x = x0
    for i in range(max_iterations):
        fx = f(x)
        fdr = f_driv(x)
        
        # Avoid division by zero if derivative is close to zero
        if abs(fdr) < 10**(-12):
            print("Derivative is close to zero. Method may fail.")
            return None
        
        # Newton's iteration
        x_new = x - fx / fdr
        
        # Check for convergence
        if abs(x_new - x) < tolerance:
            print(f"Converged to root at x = {x_new} after {i+1} iterations.")
            return x_new
        
        x = x_new
    
    print("Method did not converge within the maximum number of iterations.")
    return None

# Example usage
if __name__ == "__main__":
    # Define the function f(x) = e^x - x^3 + x^2 - x
    def f(x):
        ## return e^x - x^3 + x^2 - x
        return math.exp(x) - x**3 + x**2 - x
    
    # Define the derivative f'(x) = e^x - 3x^2 + 2x - 1
    def f_driv(x):
        ##return e^x - 3x^2 + 2x - 1
        return math.exp(x) - 3*x**2 + 2*x - 1
    
    # Initial guess
    x0 = 2.25
    
    # Call Newton's method
    root = newtons_method(f, f_driv, x0)
    print(f"Approximate root: {root}")
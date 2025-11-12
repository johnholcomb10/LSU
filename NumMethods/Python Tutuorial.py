import numpy as np
import matplotlib.pyplot as plt

# Define the function sin(x) and the Taylor polynomials
x = np.linspace(-4, 4, 400)
sin_x = np.sin(x)

# Taylor polynomials
P1 = x
P3 = x - (x**3) / 6
P5 = x - (x**3) / 6 + (x**5) / 120

# Plot the functions
plt.figure(figsize=(8, 6))
plt.plot(x, sin_x, label='sin(x)', color='black', linewidth=2)
plt.plot(x, P1, label='Degree 1 (P1)', linestyle='--')
plt.plot(x, P3, label='Degree 3 (P3)', linestyle='--')
plt.plot(x, P5, label='Degree 5 (P5)', linestyle='--')

# Customize the plot
plt.title('Taylor Series Approximations for sin(x)')
plt.xlabel('x')
plt.ylabel('y')
plt.axhline(0, color='black',linewidth=0.5)
plt.axvline(0, color='black',linewidth=0.5)
plt.legend()
plt.grid(True)

# Show plot
plt.show()

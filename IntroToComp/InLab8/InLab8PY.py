def calculate_determinant(matrix):
    determinant = 0

    # Calculate determinant using the formula for a 3x3 matrix
    determinant = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) - \
                  matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) + \
                  matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0])
    
    return determinant

def calculate_inverse(matrix):
    determinant = calculate_determinant(matrix)

    if determinant == 0:
        raise ValueError("Matrix is not invertible (determinant is zero)")
    
    inverse = [[0]*3 for _ in range(3)]
    inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / determinant
    inverse[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / determinant
    inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / determinant
    inverse[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / determinant
    inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / determinant
    inverse[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) / determinant
    inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / determinant
    inverse[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) / determinant
    inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / determinant

    return inverse

# Initialize matrix
B = [[4, 12, 18], [92, 31, 23], [-12, 43, 33]]

# Calculate inverse of matrix B
inverse_matrix = calculate_inverse(B)

# Print the inverse
print("Inverse matrix: ")
for row in inverse_matrix:
    print(row)

# Calculate determinant of matrix B
determinant = calculate_determinant(B)

# Print the determinant
print("Determinant of matrix B is: ")
print(determinant)

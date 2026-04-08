using System;

class Program
{
    static void Main(string[] args)
    {
        // Initialize matrix
        double[,] B = {{4, 12, 18}, {92, 31, 23}, {-12, 43, 33}};

        // Calculate determinant of matrix B
        double determinant = CalculateDeterminant(B);

        // Display result
        Console.WriteLine("Determinant of matrix B is: ");
        Console.WriteLine(determinant);
    }

    static double CalculateDeterminant(double[,] matrix)
    {
        double determinant = 0;
        
        // Calculate determinant using the formula for 3x3 matrices
        determinant = matrix [0, 0] * (matrix[1, 1] * matrix[2, 2] - matrix[1, 2] * matrix[2, 1]) -
                      matrix[0, 1] * (matrix[1, 0] * matrix[2, 2] - matrix[1, 2] * matrix[2, 0]) +
                      matrix[0, 2] * (matrix[1, 0] * matrix[2, 1] - matrix[1, 1] * matrix[2, 0]);
        
        return determinant;
    }
}
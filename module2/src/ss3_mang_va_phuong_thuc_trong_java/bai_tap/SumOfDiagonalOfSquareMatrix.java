package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input size of a square matrix: ");
        int length = sc.nextInt();
        float[][] squareMatrix = new float[length][length];
        float sum1 = 0;
        float sum2 = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("Input value of squareMatrix[%d][%d]= ", i, j);
                squareMatrix[i][j] = sc.nextFloat();
                if (i == j) {
                    sum1 = sum1 + squareMatrix[i][j];
                }
                if (i + j == length - 1) {
                    sum2 = sum2 + squareMatrix[i][j];
                }
            }
        }
        System.out.printf("Sum of diagonals of the matrix: %f and %f", sum1 ,sum2);
    }
}

package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class CalculateSumOfColum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input row size: ");
        int row = sc.nextInt();
        System.out.println("Input colum size: ");
        int col = sc.nextInt();
        float[][] myMatrix = new float[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Input value of myMatrix[%d][%d]= ", i, j);
                myMatrix[i][j] = sc.nextFloat();
            }
        }
        System.out.println("Input number of colum you want to calculate sum: ");
        int colPos = sc.nextInt();
        float sum = 0.0f;
        for (int i = 0; i < row; i++) {
            sum += myMatrix[colPos][i];
        }
        System.out.printf("Sum of colum %d : %f",colPos,sum);
    }
}

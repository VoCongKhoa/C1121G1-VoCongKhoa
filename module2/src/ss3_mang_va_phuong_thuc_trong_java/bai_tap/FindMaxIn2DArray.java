package ss3_mang_va_phuong_thuc_trong_java.bai_tap;
import java.util.Scanner;
public class FindMaxIn2DArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Input number of row: ");
        int row = sc.nextInt();
        System.out.println("Input number of col: ");
        int col = sc.nextInt();
        float[][] matrix = new float[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Input value matrix[%d][%d] = ", i,j);
                matrix[i][j] = sc.nextFloat();
            }
        }
        float max = 0.0f;
        int rowPos = 0;
        int colPos = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]>max){
                    max = matrix[i][j];
                    rowPos = i;
                    colPos = j;
                }
            }
        }
        System.out.printf("Max value: matrix[%d][%d] = %f",rowPos,colPos,max);
    }
}

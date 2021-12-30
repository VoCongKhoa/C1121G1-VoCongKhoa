package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length: ");
        int length = sc.nextInt();
        int[] myArr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Input value [%d]: ", i);
            myArr[i] = sc.nextInt();
        }
        int i = 0, temp;
        while (i < (length - 1 - i)) {
            temp = myArr[i];
            myArr[i] = myArr[length - 1 - i];
            myArr[length - 1 - i] = temp;
            i++;
        }
        for (int j = 0; j < length; j++) {
            System.out.printf("Phần tử thứ %d là: %d\n", j, myArr[j]);
        }
    }
}

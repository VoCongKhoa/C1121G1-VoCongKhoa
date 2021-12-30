package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] myArr = {4, -12, -7, -8, 0, 6, 9};
        System.out.println("Min value of array: " + minValue(myArr));
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++)
            if (min > arr[i]) {
                min = arr[i];
            }
        return min;
    }
}

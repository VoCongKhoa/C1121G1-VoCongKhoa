package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length of array A: ");
        int lengthA = sc.nextInt();
        System.out.println("Input length of array B: ");
        int lengthB = sc.nextInt();
        int[] arrA = new int[lengthA];
        int[] arrB = new int[lengthB];
        int[] arrC = new int[lengthA + lengthB];
        for (int i = 0; i < lengthA; i++) {
            System.out.printf("Nhập phần tử thứ %d của mảng A:", i);
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < lengthB; i++) {
            System.out.printf("Nhập phần tử thứ %d của mảng B:", i);
            arrB[i] = sc.nextInt();
        }
        if (lengthA >= lengthB) {
            for (int i = 0; i < lengthA; i++) {
                arrC[i] = arrA[i];
                if (lengthA + i < arrC.length) {
                    arrC[lengthA + i] = arrB[i];
                }
            }
        } else {
            for (int i = 0; i < lengthB; i++) {
                if (i < lengthA) {
                    arrC[i] = arrA[i];
                }
                arrC[lengthA + i] = arrB[i];
            }
        }
        for (int i = 0; i < arrC.length; i++) {
            System.out.printf("Phần tử thứ %d của mảng gộp C là: %d\n", i, arrC[i]);
        }
    }
}

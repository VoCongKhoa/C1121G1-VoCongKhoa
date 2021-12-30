package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length of myArr: ");
        int length = sc.nextInt();
        int[] myArr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Input value of myArr[%d]= \n", i);
            myArr[i] = sc.nextInt();
        }
        int[] minArr = {myArr[0]};
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] < minArr[0]) {
                minArr[0] = myArr[i];
            }
        }
        System.out.println("Min value of myArr: " + minArr[0]);
    }
}

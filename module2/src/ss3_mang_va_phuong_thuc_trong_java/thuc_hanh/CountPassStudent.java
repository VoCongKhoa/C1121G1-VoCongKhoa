package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class CountPassStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int length;
        do {
            System.out.println("Input quantity of student: ");
            length = sc.nextInt();
            if (length > 30 || length <= 0) {
                System.out.println("Number of student below 30 and over 0!! Plz try again!!");
            }
        } while (length > 30 || length <= 0);
        float[] markList = new float[length];
        for (int i = 0; i < length; i++) {
            do {
                System.out.printf("Input mark of student %d: ", i + 1);
                markList[i] = sc.nextFloat();
                if (markList[i] > 10 || markList[i] < 0) {
                    System.out.println("Mark of student only below 10 and over 0!! Plz try again!!");
                }
            } while (markList[i] > 10 || markList[i] < 0);
        }
        for (int i = 0; i < length; i++) {
            if (markList[i] >= 5) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Number of passed student: " + count);
        } else System.out.println("None of students pass!! ");
    }
}

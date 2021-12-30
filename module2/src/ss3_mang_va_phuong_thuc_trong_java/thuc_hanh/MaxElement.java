package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length;
        do {
            System.out.println("Input length of list: ");
            length = sc.nextInt();
            if (length > 20) {
                System.out.println("Invalid input, maximum length of list is only 20. Try again!");
            }
        } while (length > 20);
        float[] billionaireList = new float[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Input billionaireList[%d]: \n",i);
            billionaireList[i] = sc.nextFloat();
            System.out.printf("billionaireList[%d]: %f\n",i,billionaireList[i]);
        }
        float max=0;
        for (int i = 0; i < length; i++) {
            if (max < billionaireList[i]) {
                max = billionaireList[i];
            }
        }
        System.out.println("The number one billionaire is: " + max);
    }
}

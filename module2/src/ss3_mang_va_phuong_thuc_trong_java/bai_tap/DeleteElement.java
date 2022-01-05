package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] myArr = {1,2,3,45,6,6};
        int length = myArr.length;
        System.out.println("Input any number: ");
        int number = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (number == myArr[i]) {
                flag = true;
                for (int j = i; j < length; j++) {
                    if (j < length - 1) {
                        myArr[j] = myArr[j + 1];
                    } else {
                        myArr[length - 1] = 0;
                    }
                }
                i--;
            }
        }
        if (flag){
            for (int i = 0; i < length; i++) {
                System.out.printf("myArr[%d] = %d\n", i, myArr[i]);
            }
        } else {
            System.out.println("No number valid!");
        }
    }
}

package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] myArr = {1, 0, 3, 4, 5, 6, 1, 2, 3};
        int length = myArr.length;
        System.out.println("Input X: ");
        int x = sc.nextInt();
        int index;
        do {
            System.out.println("Input index: ");
            index = sc.nextInt();
            if (index > length){
                System.out.printf("Bạn nhập quá chiều dài mảng cho sẵn, hãy nhập lại số <%d\n",length);
            }
        }while (index > length);

        int[] cloneArr = new int[length + 1];
        for (int i = 0; i < cloneArr.length; i++) {
            if (i < index) {
                cloneArr[i] = myArr[i];
            } else if (i == index) {
                cloneArr[i] = x;
            } else {
                cloneArr[i] = myArr[i - 1];
            }
        }
        for (int i = 0; i < cloneArr.length; i++) {
            System.out.printf("myArr[%d] = %d\n", i, cloneArr[i]);
        }
    }
}
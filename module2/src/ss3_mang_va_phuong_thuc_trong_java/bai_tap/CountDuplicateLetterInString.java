package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

//import java.util.Arrays;

import java.util.Objects;
import java.util.Scanner;

public class CountDuplicateLetterInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a letter to find in string: ");
        char letter = sc.nextLine().charAt(0);
//        String letter = sc.nextLine();

        String str = "aaaaabbbbcccdd";
        if (str.indexOf(letter) == -1) {
            System.out.println("Don't exist!!");
        } else {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (letter == str.charAt(i)) {
                    count++;
                }
            }
            System.out.println("Result = " + count);
        }
    }
}

//        String[] strArr = str.split("");
//        if (str.indexOf(letter) == -1) {
//            System.out.println("Don't exist!!");
//        } else {
//            int count = 0;
////        System.out.println(Arrays.toString(strArr));
//            for (int i = 0; i < strArr.length; i++) {
//                if (Objects.equals(letter, strArr[i])) {
//                    count++;
//                }
//            }
//            System.out.println("Result = " + count);
//        }


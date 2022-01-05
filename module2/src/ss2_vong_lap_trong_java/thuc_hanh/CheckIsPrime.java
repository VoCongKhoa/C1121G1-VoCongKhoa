package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CheckIsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number: ");
        int number = sc.nextInt();
        System.out.println("Result: " + isPrime(number));
    }
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
//        for (int i = 2; i <= number; i++) {
//            if (count >= 1 && i < number) {
//                return false;
//            } else if (number % i == 0) {
//                count++;
//            }
//        }
        return true;
    }
}

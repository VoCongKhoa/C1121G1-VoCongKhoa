package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class MaxCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number a: ");
        int numberA = sc.nextInt();
        System.out.println("Input number b: ");
        int numberB = sc.nextInt();
        if (numberA == 0 && numberB == 0) {
            System.out.println("Do not exist!");
        } else if (numberA == 0) {
            System.out.println("Max common divisor = " + Math.abs(numberB));
        } else if (numberB == 0) {
            System.out.println("Max common divisor = " + Math.abs(numberA));
        } else if (numberA % numberB == 0) {
            System.out.println("Max common divisor = " + numberB);
        } else if (numberB % numberA == 0) {
            System.out.println("Max common divisor = " + numberA);
        } else {
            int maxComDivisor = 0;
            for (int i = 1; i <= numberA; i++) {
                if (numberA % i == 0 && numberB % i == 0) {
                    maxComDivisor = i;
                }
            }
            System.out.println("Max common divisor = " + maxComDivisor);
        }

    }
}

package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class OutputNumberOfPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input numbers of Prime you want: ");
        int n = sc.nextInt();
        int count = 0;
        int i = 2;
        while (count < n) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    public static boolean isPrime(int number) {
        int i = 2;
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}

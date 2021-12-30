package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class OutputNumberOfPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, prime = 2;
        System.out.println("Input numbers of Prime you want: ");
        int number = sc.nextInt();
        while (count < number) {
            int i = 2;
            boolean check = true;
            while (i < prime) {
                if (prime % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check){
                System.out.println(prime + " is a prime");
                count++;
            }
            prime++;
        }
    }
}

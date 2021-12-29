package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class InterestBankCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double interestTotal = 0;
        System.out.println("Input money: ");
        double money = sc.nextLong();
        System.out.println("Input month: ");
        int month = sc.nextInt();
        System.out.println("Input interestRate: ");
        double interestRate = sc.nextLong();
        for (int i = 0; i < month; i++) {
            interestTotal += money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total interest: "+interestTotal);
    }
}

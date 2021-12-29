package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long money;
        final int RATEUSD = 23000;
        System.out.println("Input USD: ");
        money = sc.nextLong();
        System.out.printf("Output VND: %d VND", RATEUSD*money);
    }
}

package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYearCheck {
    public static void main(String[] args) {
        int year;
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input year: ");
        year = sc.nextInt();
        if (year % 4 == 0 && year % 100 != 0) {
            text = "nhuận";
        } else if (year % 100 == 0 & year % 400 != 0) {
            text = "nhuận";
        } else if (year % 100 == 0 & year % 400 == 0) {
            text = "nhuận";
        } else {
            text = "";
        }
        if (!text.equals("")) {
            System.out.printf("Năm %d là năm %s", year, text);
        } else {
            System.out.printf("Năm %d là năm không nhuận", year);
        }
    }
}

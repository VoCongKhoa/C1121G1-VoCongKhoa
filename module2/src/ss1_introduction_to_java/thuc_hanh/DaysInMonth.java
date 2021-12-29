package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        int month;
        String day;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input month: ");
        month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = "30";
                break;
            case 2:
                day = "29 hoặc 30";
                break;
            default:
                day = "";
        }
        if (!day.equals("")) {
            System.out.printf("Tháng %d có %s ngày!", month, day);
        } else {
            System.out.println("Bạn nhập sai hãy nhập lại!");
        }
    }
}

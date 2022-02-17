package bai_thi_code_C09.utils;

import java.util.Scanner;

public class ValidationC09 {
    public String resultStringAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }
        return result;
    }

    public double resultDoubleAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        double result;
        while (true) {
            try {
                System.out.print(text);
                result = Double.parseDouble(scanner.nextLine());
                if (result <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }
        return result;
    }

    public int resultIntAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            try {
                System.out.print(text);
                result = Integer.parseInt(scanner.nextLine());
                if (result <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }
        return result;
    }
}

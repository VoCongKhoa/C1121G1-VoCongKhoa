package bai_thi_code_C10.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationC10 {

    private static final String MA_SAN_PHAM_REGEX = "^SP\\d{5}$";

    public boolean validateMaSanPham(String maSanPham) {
        return Pattern.matches(MA_SAN_PHAM_REGEX, maSanPham.trim());
    }

    public String resultMaSanPhamAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateMaSanPham(result)){
                System.out.println("Nhập sai định dạng mã sản phẩm (EX: SP00001, SP0002,...)");
            } else {
                break;
            }
        }
        return result;
    }

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

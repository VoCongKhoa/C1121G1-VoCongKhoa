package bai_thi_code_C08.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationC08 {

    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[-/ ]((0[1-9]|1[012])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))[-/ ](\\d{4})$";
    private static final String MA_TAI_KHOAN_REGEX = "^\\d{9}$";
    private static final String SO_THE_REGEX = "^\\d{16}$";

    public boolean validateDate(String date) {
        date = date.trim();
        boolean resultValid = false;
        if (date.matches(DATE_REGEX)) {
            try {
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                //Nếu set formatter1.setLenient là true (Mặc định nếu bạn dùng parse là SimpleDateFormat thì nó là true) thì
                //bạn input date string là 31/2/2019
                // -> nó sẽ tự động hiểu là 3 ngày sau ngày 28/2/2019 -> thành ra 3/3/2019
                //Trong trường hợp này bạn sẽ muốn nó bắn về lỗi => setLenient là false
                formatter1.setLenient(false);
                //throws ParseException in case of invalid date
                formatter1.parse(date);
                resultValid = true;
            } catch (ParseException ignored) {
            }
        }
        return resultValid;
    }

    public boolean validateMaTaiKhoan(String maTaiKhoan) {
        return Pattern.matches(MA_TAI_KHOAN_REGEX, maTaiKhoan.trim());
    }

    public boolean validateSoThe(String soThe) {
        return Pattern.matches(SO_THE_REGEX, soThe.trim());
    }

    public String resultDateAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateDate(result)){
                System.out.println("Nhập sai định dạng ngày (Ex: dd/MM/yyyy, 29/12/2022,...");
            } else {
                break;
            }
        }
        return result;
    }

    public String resultMaTaiKhoanAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateMaTaiKhoan(result)){
                System.out.println("Nhập sai định dạng mã tài khoản (Gồm 9 số)");
            } else {
                break;
            }
        }
        return result;
    }

    public String resultSoTheAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateSoThe(result)){
                System.out.println("Nhập sai định dạng số thẻ (Gồm 16 số)");
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
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
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

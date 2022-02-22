package bai_thi_thuc_hanh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    private static final String MA_BENH_AN_REGEX = "^BA-\\d{3}$";
    private static final String MA_BENH_NHAN_REGEX = "^BN-\\d{3}$";
    private static final String LOAI_VIP_REGEX = "^(VIP 1|VIP 2|VIP 3)$";
    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[-/ ]((0[1-9]|1[012])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))[-/ ](\\d{4})$";

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

    public String resultNgayRaVienAfterValidate(String text, String ngayNhapVien){
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayNhapVienDate = null;
        Date ngayRaVienDate = null;
        boolean flag = false;
        try {
            ngayNhapVienDate = formatter.parse(ngayNhapVien);
        } catch (ParseException e) {
        }
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateDate(result)){
                System.out.println("Nhập sai định dạng ngày!!! Hãy nhập lại");
                flag = true;
            } else{
                try {
                    ngayRaVienDate = formatter.parse(result);
                } catch (ParseException e) {
                }
            }
            if (ngayNhapVienDate.before(ngayRaVienDate) || ngayNhapVien.equals(result)){
                break;
            } else if (!flag){
                System.out.println("Ngày ra viện phải lớn hơn hoặc bằng ngày nhập viện");
            }
        }
        return result;
    }

    public String resultDateAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("") && validateDate(result)) {
                System.out.println("không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateDate(result)){
                System.out.println("Nhập sai định dạng ngày (Ex: dd/MM/yyyy, 29/12/2022,...");
            } else {
                break;
            }
        }
        return result;
    }

    public boolean validateMaBenhAn(String maBenhAn) {
        return Pattern.matches(MA_BENH_AN_REGEX, maBenhAn.trim());
    }

    public boolean validateMaBenhNhan(String maBenhNhan) {
        return Pattern.matches(MA_BENH_NHAN_REGEX, maBenhNhan.trim());
    }

    public boolean validateLoaiVIP(String loaiVIP) {
        return Pattern.matches(LOAI_VIP_REGEX, loaiVIP.trim());
    }

    public String resultLoaiVIPAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateLoaiVIP(result)){
                System.out.println("Nhập sai định dạng loại VIP (Chỉ được nhập VIP 1 hoặc VIP 2 hoặc VIP 3)");
            } else {
                break;
            }
        }
        return result;
    }

    public String resultMaBenhAnAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateMaBenhAn(result)){
                System.out.println("Nhập sai định dạng mã bệnh án (EX: BA-XXX, BA-001,...)");
            } else {
                break;
            }
        }
        return result;
    }

    public String resultMaBenhNhanAfterValidate(String text){
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            result = scanner.nextLine();
            if (result.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập vào thông tin!");
            } else if (!validateMaBenhNhan(result)){
                System.out.println("Nhập sai định dạng mã bệnh nhân (EX: BN-XXX, BN-001,...)");
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

}

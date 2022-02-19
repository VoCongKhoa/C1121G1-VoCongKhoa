package bai_thi_code_C08.services;

import bai_thi_code_C08.common.ReadAndWriteFileCSVC08;
import bai_thi_code_C08.models.TaiKhoan;
import bai_thi_code_C08.models.TaiKhoanThanhToan;
import bai_thi_code_C08.models.TaiKhoanTietKiem;
import bai_thi_code_C08.utils.NotFoundBankAccountException;
import bai_thi_code_C08.utils.ValidationC08;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanServiceImpl implements TaiKhoanService{
    static final String TAI_KHOAN = "src/bai_thi_code_C08/data/taiKhoan.csv";
    ValidationC08 validationC08 = new ValidationC08();
    public static List<TaiKhoan> taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(
            ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN));

    @Override
    public void themMoi(int caseNumber) {
        taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(
                ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN));
        boolean flagMaTaiKhoan = true;
        String maTaiKhoan = null;
        while (flagMaTaiKhoan){
            maTaiKhoan = validationC08.resultMaTaiKhoanAfterValidate("Nhập mã tài khoản: ");
            for (TaiKhoan taiKhoan: taiKhoanList) {
                if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)){
                    System.out.println("Mã tài khoản đã tồn tại! Hãy nhập lại mã tài khoản khác!");
                    flagMaTaiKhoan = true;
                    break;
                } else {
                    flagMaTaiKhoan = false;
                }
            }
        }
        String tenChuTaiKhoan= validationC08.resultStringAfterValidate("Nhập tên chủ tài khoản: ");
        String ngayTaoTaiKhoan= validationC08.resultDateAfterValidate("Nhập ngày tạo tài khoản: ");
        List<TaiKhoan> taiKhoanTietKiemList = new ArrayList<>();
        List<TaiKhoan> taiKhoanThanhToanList = new ArrayList<>();
        List<String> stringTaiKhoanTietKiemList;
        List<String> stringTaiKhoanThanhToanList;

        switch (caseNumber) {
            case 1:
                double soTienGuiTietKiem= validationC08.resultDoubleAfterValidate("Nhập số tiền gửi tiết kiệm: ");
                String ngayGuiTietKiem= validationC08.resultDateAfterValidate("Nhập ngày gửi tiết kiệm: ");
                int laiSuat= validationC08.resultIntAfterValidate("Nhập lãi suất: ");
                int kyHan= validationC08.resultIntAfterValidate("Nhập kỳ hạn: ");
                TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan, soTienGuiTietKiem,
                        ngayGuiTietKiem, laiSuat, kyHan);
                if (taiKhoanList.isEmpty()){
                    taiKhoanTietKiem.setIdTaiKhoan(1);
                } else {
                    taiKhoanTietKiem.setIdTaiKhoan(taiKhoanList.get(taiKhoanList.size()-1).getIdTaiKhoan() + 1);
                }
                taiKhoanList.add(taiKhoanTietKiem);
                taiKhoanTietKiemList.add(taiKhoanTietKiem);
                stringTaiKhoanTietKiemList = ReadAndWriteFileCSVC08.convertTaiKhoanListToStringList(taiKhoanTietKiemList);
                ReadAndWriteFileCSVC08.writeStringListIntoCSVFile(TAI_KHOAN, stringTaiKhoanTietKiemList, true);
                System.out.println("Thêm mới tài khoản tiết kiệm thành công!!!");
                break;
            case 2:
                boolean flagSoThe = true;
                String soThe = null;
                while (flagSoThe){
                    soThe = validationC08.resultSoTheAfterValidate("Nhập số thẻ của tài khoản: ");
                    for (TaiKhoan taiKhoan: taiKhoanList) {
                        if (taiKhoan instanceof TaiKhoanThanhToan){
                            if (((TaiKhoanThanhToan) taiKhoan).getSoThe().equals(soThe)){
                                System.out.println("Số thẻ đã tồn tại! Hãy nhập lại số thẻ khác!");
                                flagSoThe = true;
                                break;
                            } else {
                                flagSoThe = false;
                            }
                        }
                    }
                }
                double soTienTrongTaiKhoan = validationC08.resultDoubleAfterValidate("Nhập số tiền trong tài khoản: ");
                TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan,
                        soThe, soTienTrongTaiKhoan);
                if (taiKhoanList.isEmpty()){
                    taiKhoanThanhToan.setIdTaiKhoan(1);
                } else {
                    taiKhoanThanhToan.setIdTaiKhoan(taiKhoanList.get(taiKhoanList.size()-1).getIdTaiKhoan() + 1);
                }
                taiKhoanList.add(taiKhoanThanhToan);
                taiKhoanThanhToanList.add(taiKhoanThanhToan);
                stringTaiKhoanThanhToanList = ReadAndWriteFileCSVC08.convertTaiKhoanListToStringList(taiKhoanThanhToanList);
                ReadAndWriteFileCSVC08.writeStringListIntoCSVFile(TAI_KHOAN, stringTaiKhoanThanhToanList, true);
                System.out.println("Thêm mới tài khoản thanh toán thành công!!!");
                break;
        }
    }

    @Override
    public void xoa() throws NotFoundBankAccountException {
        taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(
                ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN));
        if (taiKhoanList.isEmpty()){
            System.out.println("Empty file!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            chonMaTaiKhoanLoop:
            while (true) {
                hienThi();
                System.out.print("Chọn mã tài khoản muốn xoá: ");
                String maTaiKhoan = scanner.nextLine();
                if (maTaiKhoan.trim().equals("")) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    List<String> stringList = ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN);
//                List<TaiKhoan> taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(stringList);
                    taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(stringList);
                    boolean flag = false;
                    for (TaiKhoan taiKhoan : taiKhoanList) {
                        if (taiKhoan.getMaTaiKhoan().equals(maTaiKhoan)) {
                            do {
                                int xacNhan;
                                try {
                                    System.out.println("Bạn có xác nhận xoá tài khoản với mã tài khoản là: " + maTaiKhoan);
                                    System.out.println("1. Có");
                                    System.out.println("2. Không");
                                    System.out.print("Bạn chọn: ");
                                    xacNhan = Integer.parseInt(scanner.nextLine());
                                    switch (xacNhan) {
                                        case 1:
                                            taiKhoanList.remove(taiKhoan);
                                            stringList = ReadAndWriteFileCSVC08.convertTaiKhoanListToStringList(taiKhoanList);
                                            ReadAndWriteFileCSVC08.writeStringListIntoCSVFile(TAI_KHOAN, stringList, false);
                                            System.out.println("Bạn đã xoá thành công!!!");
                                            break chonMaTaiKhoanLoop;
                                        case 2:
                                            System.out.println("Bạn đã huỷ xoá!");
                                            break chonMaTaiKhoanLoop;
                                        default:
                                            System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
                                }
                            } while (true);
                        }
                        else {
                            flag = true;
                        }
                    }
                    if (flag) {
                        throw new NotFoundBankAccountException();
                    }
                }
            }
        }
    }

    @Override
    public void hienThi() {
        taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(
                ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN));
        if (taiKhoanList.isEmpty()){
            System.out.println("Empty file!!!");
        } else {
            List<String> stringList = ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN);
            List<TaiKhoan> taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(stringList);
            System.out.println("Danh sách tài khoản: ");
            for (TaiKhoan taiKhoan : taiKhoanList) {
                System.out.println(taiKhoan.toString());
            }
        }
    }

    @Override
    public void timKiem() {
        taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(
                ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN));
        if (taiKhoanList.isEmpty()){
            System.out.println("Empty file!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                hienThi();
                System.out.print("Chọn mã tài khoản hoặc tên tài khoản bạn muốn tìm: ");
                String timTaiKhoan = scanner.nextLine();
                if (timTaiKhoan.trim().equals("")) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    List<String> stringList = ReadAndWriteFileCSVC08.readFileCSVToStringList(TAI_KHOAN);
                    List<TaiKhoan> taiKhoanList = ReadAndWriteFileCSVC08.convertStringListToTaiKhoanList(stringList);
                    boolean flag = false;
                    for (TaiKhoan taiKhoan : taiKhoanList) {
                        if (taiKhoan.getMaTaiKhoan().toLowerCase().contains(timTaiKhoan.toLowerCase())
                                || taiKhoan.getTenChuTaiKhoan().toLowerCase().contains(timTaiKhoan.toLowerCase())) {
                            System.out.println(taiKhoan);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("Không tìm thấy!!! Hãy nhập lại!!!");
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

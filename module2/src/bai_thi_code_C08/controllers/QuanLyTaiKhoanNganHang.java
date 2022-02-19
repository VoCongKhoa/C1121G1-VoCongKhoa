package bai_thi_code_C08.controllers;

import bai_thi_code_C08.services.TaiKhoanServiceImpl;
import bai_thi_code_C08.utils.NotFoundBankAccountException;
import java.util.Scanner;

public class QuanLyTaiKhoanNganHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoanServiceImpl taiKhoanService = new TaiKhoanServiceImpl();

        QLSPLoop:
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách các tài khoản\n" +
                        "4. Tìm kiếm\n" +
                        "5. Thoát\n");
                System.out.print("Chọn chức năng: ");
                int chonChucNang = Integer.parseInt(scanner.nextLine());
                switch (chonChucNang) {
                    case 1:
                        chonTaiKhoanLoop:
                        do {
                            try {
                                System.out.println("Chọn loại tài khoản cần thêm mới:");
                                System.out.println("1. Tài khoản tiết kiệm");
                                System.out.println("2. Tài khoản thanh toán");
                                System.out.println("3. Quay lại Quản lý tài khoản");
                                System.out.print("Chọn tài khoản: ");
                                int chonTaiKhoan = Integer.parseInt(scanner.nextLine());
                                switch (chonTaiKhoan) {
                                    case 1:
                                        taiKhoanService.themMoi(1);
                                        break;
                                    case 2:
                                        taiKhoanService.themMoi(2);
                                        break;
                                    case 3:
                                        break chonTaiKhoanLoop;
                                    default:
                                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai định dạng!!! Hãy nhập lại");
                            }
                        } while (true);
                        break;
                    case 2:
                        while (true){
                            try {
                                taiKhoanService.xoa();
                                break;
                            } catch (NotFoundBankAccountException e) {
                                System.out.println("Không tìm thấy!!! Hãy nhập lại!!!");
                            }
                        }
                        break;
                    case 3:
                        taiKhoanService.hienThi();
                        break;
                    case 4:
                        taiKhoanService.timKiem();
                        break;
                    case 5:
                        break QLSPLoop;
                    default:
                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại");
            }
        } while (true);
    }
}

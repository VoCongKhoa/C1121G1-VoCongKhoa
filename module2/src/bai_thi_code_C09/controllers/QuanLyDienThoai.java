package bai_thi_code_C09.controllers;

import bai_thi_code_C09.services.DienThoaiService;
import bai_thi_code_C09.services.DienThoaiServiceImpl;

import java.util.Scanner;

public class QuanLyDienThoai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DienThoaiService dienThoaiService = new DienThoaiServiceImpl();

        QLSPLoop:
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI –\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách các sản phẩm\n" +
                        "4. Tìm kiếm\n" +
                        "5. Thoát\n");
                System.out.print("Chọn chức năng: ");
                int chonChucNang = Integer.parseInt(scanner.nextLine());
                switch (chonChucNang) {
                    case 1:
                        chonDienThoaiLoop:
                        do {
                            try {
                                System.out.println("Chọn loại điện thoại cần thêm mới:");
                                System.out.println("1. Điện thoại chính hãng");
                                System.out.println("2. Điện thoại xách tay");
                                System.out.println("3. Quay lại Quản lý điện thoại");
                                System.out.print("Chọn loại điện thoại: ");
                                int chonDienThoai = Integer.parseInt(scanner.nextLine());
                                switch (chonDienThoai) {
                                    case 1:
                                        dienThoaiService.themMoi(1);
                                        break;
                                    case 2:
                                        dienThoaiService.themMoi(2);
                                        break;
                                    case 3:
                                        break chonDienThoaiLoop;
                                    default:
                                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai định dạng!!! Hãy nhập lại");
                            }
                        } while (true);
                        break;
                    case 2:
                        dienThoaiService.xoa();
                        break;
                    case 3:
                        dienThoaiService.hienThi();
                        break;
                    case 4:
                        dienThoaiService.timKiem();
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

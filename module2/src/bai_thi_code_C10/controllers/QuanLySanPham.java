package bai_thi_code_C10.controllers;

import bai_thi_code_C10.services.SanPhamServiceImpl;

import java.util.Scanner;

public class QuanLySanPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SanPhamServiceImpl sanPhamService = new SanPhamServiceImpl();

        QLSPLoop:
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM –\n" +
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
                        chonSanPhamLoop:
                        do {
                            try {
                                System.out.println("Chọn loại sản phẩm cần thêm mới:");
                                System.out.println("1. Sản phẩm nhập khẩu");
                                System.out.println("2. Sản phẩm xuất khẩu");
                                System.out.println("3. Quay lại Quản lý sản phẩm");
                                System.out.print("Chọn sản phẩm: ");
                                int chonSanPham = Integer.parseInt(scanner.nextLine());
                                switch (chonSanPham) {
                                    case 1:
                                        sanPhamService.themMoi(1);
                                        break;
                                    case 2:
                                        sanPhamService.themMoi(2);
                                        break;
                                    case 3:
                                        break chonSanPhamLoop;
                                    default:
                                        System.out.println("Nhập sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai định dạng!!! Hãy nhập lại");
                            }
                        } while (true);
                        break;
                    case 2:
                        sanPhamService.xoa();
                        break;
                    case 3:
                        sanPhamService.hienThi();
                        break;
                    case 4:
                        sanPhamService.timKiem();
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

package bai_thi_thuc_hanh.controllers;

import bai_thi_thuc_hanh.services.BenhAnServiceImpl;
import bai_thi_thuc_hanh.utils.NotFoundMedicalRecordException;

import java.util.Scanner;

public class QuanLyBenhAn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BenhAnServiceImpl benhAnService = new BenhAnServiceImpl();

        QLSPLoop:
        do {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM –\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1. Thêm mới\n" +
                        "2. Xóa\n" +
                        "3. Xem danh sách các bệnh án\n" +
                        "4. Thoát\n");
                System.out.print("Chọn chức năng: ");
                int chonChucNang = Integer.parseInt(scanner.nextLine());
                switch (chonChucNang) {
                    case 1:
                        chonBenhAnLoop:
                        do {
                            try {
                                System.out.println("Chọn loại bệnh án cần thêm mới:");
                                System.out.println("1. Bệnh án của bệnh nhân thường");
                                System.out.println("2. Bệnh án của bệnh nhân VIP");
                                System.out.println("3. Quay lại Quản lý bệnh án");
                                System.out.print("Chọn bệnh án: ");
                                int chonBenhAn = Integer.parseInt(scanner.nextLine());
                                switch (chonBenhAn) {
                                    case 1:
                                        benhAnService.themMoi(1);
                                        break;
                                    case 2:
                                        benhAnService.themMoi(2);
                                        break;
                                    case 3:
                                        break chonBenhAnLoop;
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
                                benhAnService.xoa();
                                break;
                            } catch (NotFoundMedicalRecordException e) {
                                System.out.println("Bệnh án không tồn tại!!! Hãy nhập lại!!!");
                            }
                        }
                        break;
                    case 3:
                        benhAnService.hienThi();
                        break;
                    case 4:
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

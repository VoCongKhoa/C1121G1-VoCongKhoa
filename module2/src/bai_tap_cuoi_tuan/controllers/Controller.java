package bai_tap_cuoi_tuan.controllers;

import bai_tap_cuoi_tuan.services.Service;
import bai_tap_cuoi_tuan.services.impls.OtoServiceImpl;
import bai_tap_cuoi_tuan.services.impls.XeMayServiceImpl;
import bai_tap_cuoi_tuan.services.impls.XeTaiServiceImpl;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OtoServiceImpl otoService = new OtoServiceImpl();
        XeMayServiceImpl xeMayService = new XeMayServiceImpl();
        XeTaiServiceImpl xeTaiService = new XeTaiServiceImpl();

        int choose = -1;
        while (choose != 4) {
            displayMainMenu();
            System.out.println("Chọn chức năng:");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("1. Thêm xe tải,\n" +
                            "2. Thêm ôtô,\n" +
                            "3. Thêm xe máy.\n");
                    int chooseAdd = Integer.parseInt(sc.nextLine());
                    switch (chooseAdd){
                        case 1:
                            xeTaiService.themMoi();
                            break;
                        case 2:
                            otoService.themMoi();
                            break;
                        case 3:
                            xeMayService.themMoi();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Hiển thị xe tải,\n" +
                            "2. Hiển thị ôtô,\n" +
                            "3. Hiển thị xe máy.\n");
                    int chooseDisplay = Integer.parseInt(sc.nextLine());
                    switch (chooseDisplay){
                        case 1:
                            xeTaiService.hienThi();
                            break;
                        case 2:
                            otoService.hienThi();
                            break;
                        case 3:
                            xeMayService.hienThi();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Xoá xe tải,\n" +
                            "2. Xoá ôtô,\n" +
                            "3. Xoá xe máy.\n");
                    int chooseDelete = Integer.parseInt(sc.nextLine());
                    switch (chooseDelete){
                        case 1:
                            xeTaiService.xoa();
                            break;
                        case 2:
                            otoService.xoa();
                            break;
                        case 3:
                            xeMayService.xoa();
                            break;
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    static void displayMainMenu() {
        System.out.println("Chọn chức năng:\n" +
                "1. Thêm mới phương tiện.\n" +
                "2. Hiển thị phương tiện\n" +
                "3. Xóa phương tiện\n" +
                "4. Thoát\n");
    }

}

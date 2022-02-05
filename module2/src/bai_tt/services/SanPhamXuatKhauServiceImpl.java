package bai_tt.services;

import bai_tt.common.ReadAndWriteFileCSV;
import bai_tt.models.SanPham;
import bai_tt.models.SanPhamXuatKhau;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamXuatKhauServiceImpl implements SanPhamXuatKhauService{
    static final String SAN_PHAM_XUAT_KHAU = "src/bai_tt/data/sanPhamXuatKhau.csv";
    @Override
    public void themMoi() {
        Scanner scanner = new Scanner(System.in);
        String maSanPham;
        while (true) {
            System.out.print("Nhập mã sản phẩm: ");
            maSanPham = scanner.nextLine();
            if (maSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }

        String tenSanPham;
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            tenSanPham = scanner.nextLine();
            if (tenSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }

        double giaBan;
        while (true) {
            try {
                System.out.print("Nhập giá bán: ");
                giaBan = Double.parseDouble(scanner.nextLine());
                if (giaBan <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }

        int soLuong;
        while (true) {
            try {
                System.out.print("Nhập số lượng: ");
                soLuong = Integer.parseInt(scanner.nextLine());
                if (soLuong <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }

        String nhaSanXuat;
        while (true) {
            System.out.print("Nhập nhà sản xuất: ");
            nhaSanXuat = scanner.nextLine();
            if (nhaSanXuat.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }

        double giaXuatKhau;
        while (true) {
            try {
                System.out.print("Nhập giá xuất khẩu: ");
                giaXuatKhau = Double.parseDouble(scanner.nextLine());
                if (giaXuatKhau <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }

        String quocGiaNhapSanPham;
        while (true) {
            System.out.print("Nhập quốc gia nhập sản phẩm: ");
            quocGiaNhapSanPham = scanner.nextLine();
            if (quocGiaNhapSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }

        List<SanPham> sanPhamXuatKhauList = new ArrayList<>();
        sanPhamXuatKhauList.add(new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                , giaXuatKhau, quocGiaNhapSanPham));
        List<String> stringList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamXuatKhauList);
        ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM_XUAT_KHAU, stringList, true);
        System.out.println("Thêm mới sản phẩm xuất khẩu thành công!!!");
    }

    @Override
    public void xoa() {
    }

    @Override
    public void hienThi() {
        List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM_XUAT_KHAU);
        List<SanPham> sanPhamList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringList);
        System.out.println("Danh sách sản phẩm xuất khẩu: ");
        for (SanPham sanPham : sanPhamList) {
            System.out.println(sanPham);
        }
    }

    @Override
    public void timKiem() {
    }
}

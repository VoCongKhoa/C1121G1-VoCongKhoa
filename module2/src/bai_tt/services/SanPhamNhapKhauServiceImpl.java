package bai_tt.services;

import bai_tt.common.ReadAndWriteFileCSV;
import bai_tt.models.SanPham;
import bai_tt.models.SanPhamNhapKhau;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamNhapKhauServiceImpl implements SanPhamNhapKhauService {
    static final String SAN_PHAM_NHAP_KHAU = "src/bai_tt/data/sanPhamNhapKhau.csv";

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

        double giaNhapKhau;
        while (true) {
            try {
                System.out.print("Nhập giá nhập khẩu: ");
                giaNhapKhau = Double.parseDouble(scanner.nextLine());
                if (giaNhapKhau <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }

        String tinhThanhNhap;
        while (true) {
            System.out.print("Nhập tỉnh thành nhập: ");
            tinhThanhNhap = scanner.nextLine();
            if (tinhThanhNhap.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                break;
            }
        }

        double thueNhapKhau;
        while (true) {
            try {
                System.out.print("Nhập thuế nhập khẩu: ");
                thueNhapKhau = Double.parseDouble(scanner.nextLine());
                if (thueNhapKhau <= 0) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
            }
        }

        List<SanPham> sanPhamNhapKhauList = new ArrayList<>();
        sanPhamNhapKhauList.add(new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                , giaNhapKhau, tinhThanhNhap, thueNhapKhau));
        List<String> stringList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamNhapKhauList);
        ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM_NHAP_KHAU, stringList, true);
        System.out.println("Thêm mới sản phẩm nhập khẩu thành công!!!");
    }

    @Override
    public void xoa() {
    }

    @Override
    public void hienThi() {
        List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM_NHAP_KHAU);
        List<SanPham> sanPhamList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringList);
        System.out.println("Danh sách sản phẩm nhập khẩu: ");
        for (SanPham sanPham : sanPhamList) {
            System.out.println(sanPham);
        }
    }

    @Override
    public void timKiem() {
    }
}

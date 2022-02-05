package bai_tt.services;

import bai_tt.common.ReadAndWriteFileCSV;
import bai_tt.models.SanPham;
import bai_tt.models.SanPhamNhapKhau;

import java.util.List;
import java.util.Scanner;

public class SanPhamServiceImpl implements SanPhamService {
    static final String SAN_PHAM = "src/bai_tt/data/sanPham.csv";
    static final String SAN_PHAM_NHAP_KHAU = "src/bai_tt/data/sanPhamNhapKhau.csv";
    static final String SAN_PHAM_XUAT_KHAU = "src/bai_tt/data/sanPhamXuatKhau.csv";

    @Override
    public void themMoi() {
    }

    @Override
    public void xoa() {
        Scanner scanner = new Scanner(System.in);
        chonMaSanPhamLoop:
        while (true) {
            hienThi();
            System.out.print("Chọn mã sản phẩm muốn xoá: ");
            String maSanPham = scanner.nextLine();
            if (maSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM);
                List<SanPham> sanPhamList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringList);
                boolean flag = false;
                for (SanPham sanPham : sanPhamList) {
                    if (sanPham.getMaSanPham().equals(maSanPham)) {
                        xacNhanLoop:
                        do {
                            int xacNhan;
                            try {
                                System.out.println("Bạn có xác nhận xoá sản phẩm với mã sản phẩm là: " + maSanPham);
                                System.out.println("1. Có");
                                System.out.println("2. Không");
                                System.out.print("Bạn chọn: ");
                                xacNhan = Integer.parseInt(scanner.nextLine());
                                switch (xacNhan) {
                                    case 1:
                                        sanPhamList.remove(sanPham);
                                        stringList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamList);
                                        ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM, stringList, false);
                                        if (sanPham instanceof SanPhamNhapKhau) { //Bug: xoá không được trong file csv
                                            System.out.println("NK");
                                            System.out.println(sanPham);
                                            List<String> stringNhapKhauList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM_NHAP_KHAU);
                                            List<SanPham> sanPhamNhapKhauList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringNhapKhauList);
                                            sanPhamNhapKhauList.remove(sanPham);
                                            stringNhapKhauList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamNhapKhauList);
                                            ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM_NHAP_KHAU, stringNhapKhauList, false);
                                        } else {
                                            System.out.println("XK");
                                            System.out.println(sanPham);
                                            List<SanPham> sanPhamXuatKhauList = ReadAndWriteFileCSV.convertStringListToSanPhamList(
                                                    ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM_XUAT_KHAU));
                                            sanPhamXuatKhauList.remove(sanPham);
                                            ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM_XUAT_KHAU,
                                                    ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamXuatKhauList), false);
                                        }
                                        System.out.println("Bạn đã xoá thành công!!!");
                                        break chonMaSanPhamLoop;
                                    case 2:
                                        System.out.println("Bạn đã huỷ xoá!");
                                        break xacNhanLoop;
                                    default:
                                        System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai!!! Hãy nhập lại!");
                            }
                        } while (true);
                        break;
                    } else {
                        flag = true;
                    }
                }
                if (flag) {
                    System.out.println("Không tìm thấy!!! Hãy nhập lại!!!");
                }
            }
        }
    }

    @Override
    public void hienThi() {
    }

    @Override
    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            hienThi();
            System.out.print("Chọn mã sản phẩm hoặc tên sản phẩm bạn muốn tìm: ");
            String timSanPham = scanner.nextLine();
            if (timSanPham.trim().equals("")) {
                System.out.println("Nhập sai!!! Hãy nhập lại!");
            } else {
                List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM);
                List<SanPham> sanPhamList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringList);
                boolean flag = false;
                for (SanPham sanPham : sanPhamList) {
                    if (sanPham.getMaSanPham().toLowerCase().contains(timSanPham.toLowerCase())
                            || sanPham.getTenSanPham().toLowerCase().contains(timSanPham.toLowerCase())) {
                        System.out.println(sanPham);
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

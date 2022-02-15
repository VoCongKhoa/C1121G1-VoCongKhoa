package bai_thi_code_C10.services;

import bai_thi_code_C10.common.ReadAndWriteFileCSV;
import bai_thi_code_C10.models.SanPham;
import bai_thi_code_C10.models.SanPhamNhapKhau;
import bai_thi_code_C10.models.SanPhamXuatKhau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamServiceImpl implements SanPhamService {
    static final String SAN_PHAM = "src/bai_tt/data/sanPham.csv";
    static final String SAN_PHAM_NHAP_KHAU = "src/bai_tt/data/sanPhamNhapKhau.csv";
    static final String SAN_PHAM_XUAT_KHAU = "src/bai_tt/data/sanPhamXuatKhau.csv";

    @Override
    public void themMoi(int caseNumber) {
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
        List<SanPham> sanPhamNhapKhauList = new ArrayList<>();
        List<SanPham> sanPhamXuatKhauList = new ArrayList<>();
        List<String> stringNhapKhauList;
        List<String> stringXuatKhauList;
        switch (caseNumber) {
            case 1:
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
                sanPhamNhapKhauList.add(new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                        , giaNhapKhau, tinhThanhNhap, thueNhapKhau));
                stringNhapKhauList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamNhapKhauList);
                ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM, stringNhapKhauList, true);
                System.out.println("Thêm mới sản phẩm nhập khẩu thành công!!!");
                break;
            case 2:
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
                sanPhamXuatKhauList.add(new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                        , giaXuatKhau, quocGiaNhapSanPham));
                stringXuatKhauList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamXuatKhauList);
                ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM, stringXuatKhauList, true);
                System.out.println("Thêm mới sản phẩm xuất khẩu thành công!!!");
                break;
        }

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
                                            List<String> stringNhapKhauList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM_NHAP_KHAU);
                                            List<SanPham> sanPhamNhapKhauList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringNhapKhauList);
                                            System.out.println(sanPhamNhapKhauList.contains(sanPham));
                                            sanPhamNhapKhauList.remove(sanPham);
                                            stringNhapKhauList = ReadAndWriteFileCSV.convertSanPhamListToStringList(sanPhamNhapKhauList);
                                            ReadAndWriteFileCSV.writeStringListIntoCSVFile(SAN_PHAM_NHAP_KHAU, stringNhapKhauList, false);
                                        } else {
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
                                        break chonMaSanPhamLoop;
                                    default:
                                        System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Nhập sai!!! Hãy nhập lại!");
                            }
                        } while (true);
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
        List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(SAN_PHAM);
        List<SanPham> sanPhamList = ReadAndWriteFileCSV.convertStringListToSanPhamList(stringList);
        System.out.println("Danh sách sản phẩm: ");
        for (SanPham sanPham : sanPhamList) {
            System.out.println(sanPham);
        }
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

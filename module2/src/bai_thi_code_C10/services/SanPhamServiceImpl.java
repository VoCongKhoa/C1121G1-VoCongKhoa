package bai_thi_code_C10.services;

import bai_thi_code_C10.common.ReadAndWriteFileCSVC10;
import bai_thi_code_C10.models.SanPham;
import bai_thi_code_C10.models.SanPhamNhapKhau;
import bai_thi_code_C10.models.SanPhamXuatKhau;
import bai_thi_code_C10.utils.NotFoundProductException;
import bai_thi_code_C10.utils.ValidationC10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamServiceImpl implements SanPhamService {
    static final String SAN_PHAM = "src/bai_thi_code_C10/data/sanPham.csv";
    ValidationC10 validationC10 = new ValidationC10();
    public static List<SanPham> sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(
            ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM));

    @Override
    public void themMoi(int caseNumber) {
        sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(
                ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM));
        String maSanPham = null;
        boolean flagMaSanPham = true;
        while (flagMaSanPham) {
            maSanPham = validationC10.resultMaSanPhamAfterValidate("Nhập mã sản phẩm: ");
            for (SanPham sanPham : sanPhamList) {
                if (sanPham.getMaSanPham().equals(maSanPham)) {
                    System.out.println("Mã sản phẩm đã tồn tại!!! Vui lòng nhập lại!!!");
                    flagMaSanPham = true;
                    break;
                } else {
                    flagMaSanPham = false;
                }
            }
        }
        String tenSanPham = validationC10.resultStringAfterValidate("Nhập tên sản phẩm: ");
        double giaBan = validationC10.resultDoubleAfterValidate("Nhập giá bán: ");
        int soLuong = validationC10.resultIntAfterValidate("Nhập số lượng: ");
        String nhaSanXuat = validationC10.resultStringAfterValidate("Nhập nhà sản xuất: ");
        List<SanPham> sanPhamNhapKhauList = new ArrayList<>();
        List<SanPham> sanPhamXuatKhauList = new ArrayList<>();
        List<String> stringNhapKhauList;
        List<String> stringXuatKhauList;
        switch (caseNumber) {
            case 1:
                double giaNhapKhau = validationC10.resultDoubleAfterValidate("Nhập giá nhập khẩu: ");
                String tinhThanhNhap = validationC10.resultStringAfterValidate("Nhập tỉnh thành nhập: ");
                double thueNhapKhau = validationC10.resultDoubleAfterValidate("Nhập thuế nhập khẩu: ");
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                        , giaNhapKhau, tinhThanhNhap, thueNhapKhau);
                if (sanPhamList.isEmpty()) {
                    sanPhamNhapKhau.setIdSanPham(1);
                } else {
                    sanPhamNhapKhau.setIdSanPham(sanPhamList.get(sanPhamList.size() - 1).getIdSanPham() + 1);
                }
                sanPhamList.add(sanPhamNhapKhau);
                sanPhamNhapKhauList.add(sanPhamNhapKhau);
                stringNhapKhauList = ReadAndWriteFileCSVC10.convertSanPhamListToStringList(sanPhamNhapKhauList);
                ReadAndWriteFileCSVC10.writeStringListIntoCSVFile(SAN_PHAM, stringNhapKhauList, true);
                System.out.println("Thêm mới sản phẩm nhập khẩu thành công!!!");
                break;
            case 2:
                double giaXuatKhau = validationC10.resultDoubleAfterValidate("Nhập giá xuất khẩu: ");
                String quocGiaNhapSanPham = validationC10.resultStringAfterValidate("Nhập quốc gia nhập sản phẩm: ");

                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat
                        , giaXuatKhau, quocGiaNhapSanPham);
                if (sanPhamList.isEmpty()) {
                    sanPhamXuatKhau.setIdSanPham(1);
                } else {
                    sanPhamXuatKhau.setIdSanPham(sanPhamList.get(sanPhamList.size() - 1).getIdSanPham() + 1);
                }
                sanPhamList.add(sanPhamXuatKhau);
                sanPhamXuatKhauList.add(sanPhamXuatKhau);
                stringXuatKhauList = ReadAndWriteFileCSVC10.convertSanPhamListToStringList(sanPhamXuatKhauList);
                ReadAndWriteFileCSVC10.writeStringListIntoCSVFile(SAN_PHAM, stringXuatKhauList, true);
                System.out.println("Thêm mới sản phẩm xuất khẩu thành công!!!");
                break;
        }
    }

    @Override
    public void xoa() throws NotFoundProductException {
        sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(
                ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM));
        if (sanPhamList.isEmpty()) {
            System.out.println("Empty file!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            chonMaSanPhamLoop:
            while (true) {
                hienThi();
                System.out.print("Chọn mã sản phẩm muốn xoá: ");
                String maSanPham = scanner.nextLine();
                if (maSanPham.trim().equals("")) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    List<String> stringList = ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM);
                    List<SanPham> sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(stringList);
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
                                            stringList = ReadAndWriteFileCSVC10.convertSanPhamListToStringList(sanPhamList);
                                            ReadAndWriteFileCSVC10.writeStringListIntoCSVFile(SAN_PHAM, stringList, false);
                                            System.out.println("Bạn đã xoá thành công!!!");
                                            break chonMaSanPhamLoop;
                                        case 2:
                                            System.out.println("Bạn đã huỷ xoá!");
                                            break chonMaSanPhamLoop;
                                        default:
                                            System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
                                }
                            } while (true);
                        } else {
                            flag = true;
                        }
                    }
                    if (flag) {
                        throw new NotFoundProductException();
                    }
                }
            }
        }
    }

    @Override
    public void hienThi() {
        sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(
                ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM));
        if (sanPhamList.isEmpty()) {
            System.out.println("Empty file!!!");
        } else {
            List<String> stringList = ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM);
            List<SanPham> sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(stringList);
            System.out.println("Danh sách sản phẩm: ");
            for (SanPham sanPham : sanPhamList) {
                System.out.println(sanPham);
            }
        }
    }

    @Override
    public void timKiem() {
        sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(
                ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM));
        if (sanPhamList.isEmpty()) {
            System.out.println("Empty file!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                hienThi();
                System.out.print("Chọn mã sản phẩm hoặc tên sản phẩm bạn muốn tìm: ");
                String timSanPham = scanner.nextLine();
                if (timSanPham.trim().equals("")) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    List<String> stringList = ReadAndWriteFileCSVC10.readFileCSVToStringList(SAN_PHAM);
                    List<SanPham> sanPhamList = ReadAndWriteFileCSVC10.convertStringListToSanPhamList(stringList);
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
}

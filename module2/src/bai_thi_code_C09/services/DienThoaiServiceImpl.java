package bai_thi_code_C09.services;

import bai_thi_code_C09.common.ReadAndWriteFileCSVC09;
import bai_thi_code_C09.models.DienThoai;
import bai_thi_code_C09.models.DienThoaiChinhHang;
import bai_thi_code_C09.models.DienThoaiXachTay;
import bai_thi_code_C09.utils.NotFoundProductException;
import bai_thi_code_C09.utils.ValidationC09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiServiceImpl implements DienThoaiService {
    static final String DIEN_THOAI = "src/bai_thi_code_C09/data/dienThoai.csv";
    ValidationC09 validationC09 = new ValidationC09();

    @Override
    public void themMoi(int caseNumber) {
        Scanner scanner = new Scanner(System.in);
        String tenDienThoai = validationC09.resultStringAfterValidate("Nhập tên điện thoại: ");
        double giaBan = validationC09.resultDoubleAfterValidate("Nhập giá bán: ");
        int soLuong = validationC09.resultIntAfterValidate("Nhập số lượng: ");
        String nhaSanXuat = validationC09.resultStringAfterValidate("Nhập nhà sản xuất: ");
        List<DienThoai> dienThoaiChinhHangList = new ArrayList<>();
        List<DienThoai> dienThoaiXachTayList = new ArrayList<>();
        List<String> stringDienThoaiChinhHangList;
        List<String> stringDienThoaiXachTayList;
        switch (caseNumber) {
            case 1:
                int thoiGianBaoHanh;
                while (true) {
                    try {
                        System.out.print("Nhập thời gian bảo hành: ");
                        thoiGianBaoHanh = Integer.parseInt(scanner.nextLine());
                        if (thoiGianBaoHanh <= 0 || thoiGianBaoHanh > 730) {
                            System.out.println("Nhập sai!!! Hãy nhập lại!");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
                    }
                }

                String phamViBaoHanh;
                while (true) {
                    System.out.print("Nhập phạm vi bảo hành: ");
                    phamViBaoHanh = scanner.nextLine();
                    if (phamViBaoHanh.trim().equals("")) {
                        System.out.println("Phạm vi bảo hành không được để trống!!! Hãy nhập lại!");
                    } else if (!phamViBaoHanh.trim().equals("Toan Quoc") && !phamViBaoHanh.trim().equals("Quoc Te")) {
                        System.out.println("Phạm vi bảo hành chỉ được nhập Toan Quoc hoặc Quoc Te!!! Hãy nhập lại!");
                    } else {
                        break;
                    }
                }

                dienThoaiChinhHangList.add(new DienThoaiChinhHang(tenDienThoai, giaBan, soLuong, nhaSanXuat
                        , thoiGianBaoHanh, phamViBaoHanh));
                stringDienThoaiChinhHangList = ReadAndWriteFileCSVC09.convertDienThoaiListToStringList(dienThoaiChinhHangList);
                ReadAndWriteFileCSVC09.writeStringListIntoCSVFile(DIEN_THOAI, stringDienThoaiChinhHangList, true);
                System.out.println("Thêm mới điện thoại chính hãng thành công!!!");
                break;
            case 2:
                String quocGiaXachTay;
                while (true) {
                    System.out.print("Nhập quốc gia nhập xách tay: ");
                    quocGiaXachTay = scanner.nextLine();
                    if (quocGiaXachTay.trim().equals("")) {
                        System.out.println("Quốc gia nhập xách tay không được để trống!!! Hãy nhập lại!");
                    } else if (quocGiaXachTay.equals("Viet Nam")) {
                        System.out.println("Quốc gia nhập xách tay không được là Viet Nam");
                    } else {
                        break;
                    }
                }

                String trangThai;
                while (true) {
                    System.out.print("Nhập trạng thái của điện thoại: ");
                    trangThai = scanner.nextLine();
                    if (trangThai.trim().equals("")) {
                        System.out.println("Trạng thái của điện thoại không được để trống!!! Hãy nhập lại!");
                    } else if (!trangThai.trim().equals("Da sua chua") && !trangThai.trim().equals("Chua sua chua")) {
                        System.out.println("Trạng thái của điện thoại chỉ được nhập Da sua chua hoặc Chua sua chua!!! Hãy nhập lại!");
                    } else {
                        break;
                    }
                }
                dienThoaiXachTayList.add(new DienThoaiXachTay(tenDienThoai, giaBan, soLuong, nhaSanXuat
                        , quocGiaXachTay, trangThai));
                stringDienThoaiXachTayList = ReadAndWriteFileCSVC09.convertDienThoaiListToStringList(dienThoaiXachTayList);
                ReadAndWriteFileCSVC09.writeStringListIntoCSVFile(DIEN_THOAI, stringDienThoaiXachTayList, true);
                System.out.println("Thêm mới điện thoại xách tay thành công!!!");
                break;
        }
    }

    @Override
    public void xoa() throws NotFoundProductException {
        Scanner scanner = new Scanner(System.in);
        chonMaDienThoaiLoop:
        do {
            try {
                hienThi();
                System.out.print("Chọn mã điện thoại muốn xoá: ");
                int maDienThoai = Integer.parseInt(scanner.nextLine());
                List<String> stringList = ReadAndWriteFileCSVC09.readFileCSVToStringList(DIEN_THOAI);
                List<DienThoai> dienThoaiList = ReadAndWriteFileCSVC09.convertStringListToDienThoaiList(stringList);
                boolean flag = false;
                for (DienThoai dienThoai : dienThoaiList) {
                    if (dienThoai.getIdDienThoai() == maDienThoai) {
                        do {
                            int xacNhan;
                            try {
                                System.out.println("Bạn có xác nhận xoá điện thoại với mã là: " + maDienThoai);
                                System.out.println("1. Có");
                                System.out.println("2. Không");
                                System.out.print("Bạn chọn: ");
                                xacNhan = Integer.parseInt(scanner.nextLine());
                                switch (xacNhan) {
                                    case 1:
                                        dienThoaiList.remove(dienThoai);
                                        stringList = ReadAndWriteFileCSVC09.convertDienThoaiListToStringList(dienThoaiList);
                                        ReadAndWriteFileCSVC09.writeStringListIntoCSVFile(DIEN_THOAI, stringList, false);
                                        System.out.println("Bạn đã xoá thành công!!!");
                                        break chonMaDienThoaiLoop;
                                    case 2:
                                        System.out.println("Bạn đã huỷ xoá!");
                                        break chonMaDienThoaiLoop;
                                    default:
                                        System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Sai định dạng!!! Hãy nhập lại!");
                            }
                        } while (true);
                    } else {
                        flag = true;
                    }
                }
                if (flag) {
                    throw new NotFoundProductException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng!!! Hãy nhập lại!");
            }
        } while (true);
    }

    @Override
    public void hienThi() {
        List<String> stringList = ReadAndWriteFileCSVC09.readFileCSVToStringList(DIEN_THOAI);
        List<DienThoai> dienThoaiList = ReadAndWriteFileCSVC09.convertStringListToDienThoaiList(stringList);
        System.out.println("Danh sách điện thoại: ");
        for (DienThoai dienThoai : dienThoaiList) {
            System.out.println(dienThoai);
        }
    }

    @Override
    public void timKiem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            hienThi();
            System.out.print("Chọn mã điện thoại hoặc tên điện thoại bạn muốn tìm: ");
            String timDienThoai = scanner.nextLine();
            if (timDienThoai.trim().equals("")) {
                System.out.println("Không được để trống!!! Hãy nhập lại!");
            } else {
                List<String> stringList = ReadAndWriteFileCSVC09.readFileCSVToStringList(DIEN_THOAI);
                List<DienThoai> dienThoaiList = ReadAndWriteFileCSVC09.convertStringListToDienThoaiList(stringList);
                boolean flag = false;
                for (DienThoai dienThoai : dienThoaiList) {
                    if (timDienThoai.equals(String.valueOf(dienThoai.getIdDienThoai()))
                            || dienThoai.getTenDienThoai().toLowerCase().contains(timDienThoai.toLowerCase())) {
                        System.out.println(dienThoai);
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

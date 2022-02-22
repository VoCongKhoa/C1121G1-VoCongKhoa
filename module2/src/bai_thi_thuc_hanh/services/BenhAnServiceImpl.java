package bai_thi_thuc_hanh.services;

import bai_thi_thuc_hanh.common.ReadAndWriteFileCSV;
import bai_thi_thuc_hanh.models.BenhAn;
import bai_thi_thuc_hanh.models.BenhAnBenhNhanThuong;
import bai_thi_thuc_hanh.models.BenhAnBenhNhanVIP;
import bai_thi_thuc_hanh.utils.NotFoundMedicalRecordException;
import bai_thi_thuc_hanh.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService{
    static final String BENH_AN = "src/bai_thi_thuc_hanh/data/benhAn.csv";
    Validation validation = new Validation();
    public static List<BenhAn> benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(
            ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN));

    @Override
    public void themMoi(int caseNumber) {
        benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(
                ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN));

        String maBenhAn = validation.resultMaBenhAnAfterValidate("Nhập mã bệnh án: ");
        String maBenhNhan = validation.resultMaBenhNhanAfterValidate("Nhập mã bệnh nhân: ");
        String tenBenhNhan = validation.resultStringAfterValidate("Nhập tên bệnh nhân: ");
        String ngayNhapVien = validation.resultDateAfterValidate("Nhập ngày nhập viện: ");
        String ngayRaVien = validation.resultNgayRaVienAfterValidate("Nhập ngày ra viện: ", ngayNhapVien);
        String lyDo = validation.resultStringAfterValidate("Nhập lý do nhập viện: ");
        List<BenhAn> benhAnBenhNhanVIPList = new ArrayList<>();
        List<BenhAn> benhAnBenhNhanThuongList = new ArrayList<>();
        List<String> stringbenhAnBenhNhanVIPList;
        List<String> stringbenhAnBenhNhanThuongList;
        switch (caseNumber) {
            case 1:
                double phiNamVien = validation.resultDoubleAfterValidate("Nhập phí nằm viện: ");
                BenhAnBenhNhanThuong benhAnBenhNhanThuong = new BenhAnBenhNhanThuong(maBenhAn, maBenhNhan, tenBenhNhan,
                        ngayNhapVien, ngayRaVien, lyDo, phiNamVien);
                if (benhAnList.isEmpty()) {
                    benhAnBenhNhanThuong.setSoThuTu(1);
                } else {
                    benhAnBenhNhanThuong.setSoThuTu(benhAnList.get(benhAnList.size() - 1).getSoThuTu() + 1);
                }
                benhAnList.add(benhAnBenhNhanThuong);
                benhAnBenhNhanThuongList.add(benhAnBenhNhanThuong);
                stringbenhAnBenhNhanThuongList = ReadAndWriteFileCSV.convertBenhAnListToStringList(benhAnBenhNhanThuongList);
                ReadAndWriteFileCSV.writeStringListIntoCSVFile(BENH_AN, stringbenhAnBenhNhanThuongList, true);
                System.out.println("Thêm mới bệnh án bệnh nhân thường thành công!!!");
                break;
            case 2:
                String loaiVIP = validation.resultLoaiVIPAfterValidate("Nhập loại VIP: ");
                String thoiHanVip = validation.resultDateAfterValidate("Nhập thời hạn vip: ");
                BenhAnBenhNhanVIP benhAnBenhNhanVIP = new BenhAnBenhNhanVIP(maBenhAn, maBenhNhan, tenBenhNhan,
                        ngayNhapVien, ngayRaVien, lyDo,loaiVIP,thoiHanVip);
                if (benhAnList.isEmpty()) {
                    benhAnBenhNhanVIP.setSoThuTu(1);
                } else {
                    benhAnBenhNhanVIP.setSoThuTu(benhAnList.get(benhAnList.size() - 1).getSoThuTu() + 1);
                }
                benhAnList.add(benhAnBenhNhanVIP);
                benhAnBenhNhanVIPList.add(benhAnBenhNhanVIP);
                stringbenhAnBenhNhanVIPList = ReadAndWriteFileCSV.convertBenhAnListToStringList(benhAnBenhNhanVIPList);
                ReadAndWriteFileCSV.writeStringListIntoCSVFile(BENH_AN, stringbenhAnBenhNhanVIPList, true);
                System.out.println("Thêm mới bệnh án bệnh nhân VIP thành công!!!");
                break;
        }
    }

    @Override
    public void xoa() throws NotFoundMedicalRecordException {
        benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(
                ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN));
        if (benhAnList.isEmpty()) {
            System.out.println("Empty file!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            chonMaBenhAnLoop:
            while (true) {
                hienThi();
                System.out.print("Chọn mã bệnh án muốn xoá: ");
                String maBenhAn = scanner.nextLine();
                if (maBenhAn.trim().equals("")) {
                    System.out.println("Nhập sai!!! Hãy nhập lại!");
                } else {
                    List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN);
                    List<BenhAn> benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(stringList);
                    boolean flag = false;
                    for (BenhAn benhAn : benhAnList) {
                        if (benhAn.getMaBenhAn().equals(maBenhAn)) {
                            do {
                                int xacNhan;
                                try {
                                    System.out.println("Bạn có xác nhận xoá bệnh án với mã bệnh án là: " + maBenhAn);
                                    System.out.println("1. Có");
                                    System.out.println("2. Không");
                                    System.out.print("Bạn chọn: ");
                                    xacNhan = Integer.parseInt(scanner.nextLine());
                                    switch (xacNhan) {
                                        case 1:
                                            benhAnList.remove(benhAn);
                                            stringList = ReadAndWriteFileCSV.convertBenhAnListToStringList(benhAnList);
                                            ReadAndWriteFileCSV.writeStringListIntoCSVFile(BENH_AN, stringList, false);
                                            System.out.println("Bạn đã xoá thành công!!!");
                                            break chonMaBenhAnLoop;
                                        case 2:
                                            System.out.println("Bạn đã huỷ xoá!");
                                            break chonMaBenhAnLoop;
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
                        throw new NotFoundMedicalRecordException();
                    }
                }
            }
        }
    }

    @Override
    public void hienThi() {
        benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(
                ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN));
        if (benhAnList.isEmpty()) {
            System.out.println("Empty file!!!");
        } else {
            List<String> stringList = ReadAndWriteFileCSV.readFileCSVToStringList(BENH_AN);
            List<BenhAn> benhAnList = ReadAndWriteFileCSV.convertStringListToBenhAnList(stringList);
            System.out.println("Danh sách bệnh án: ");
            for (BenhAn benhAn : benhAnList) {
                System.out.println(benhAn);
            }
        }
    }
}

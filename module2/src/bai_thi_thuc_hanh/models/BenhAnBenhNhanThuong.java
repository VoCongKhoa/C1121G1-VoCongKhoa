package bai_thi_thuc_hanh.models;

public class BenhAnBenhNhanThuong extends BenhAn {
    //Phí nằm viện (đơn vị VNĐ)
    private double phiNamVien;

    public BenhAnBenhNhanThuong() {
    }

    public BenhAnBenhNhanThuong(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnBenhNhanThuong(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien,
                                String ngayRaVien, String lyDo, double phiNamVien) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "soThuTu='" + getSoThuTu() + '\'' +
                ", maBenhAn='" + getMaBenhAn() + '\'' +
                ", maBenhNhan='" + getMaBenhNhan() + '\'' +
                ", tenBenhNhan='" + getTenBenhNhan() + '\'' +
                ", ngayNhapVien='" + getNgayNhapVien() + '\'' +
                ", NgayRaVien='" + getNgayRaVien() + '\'' +
                ", lyDo='" + getLyDo() + '\'' +
                ", phiNamVien=" + phiNamVien +
                '}';
    }

    @Override
    public String toStringToCSVFile() {
        return super.toStringToCSVFile() + "," + phiNamVien;
    }
}

package bai_thi_thuc_hanh.models;

public abstract class BenhAn {
    //Số thứ tự bệnh án, Mã bệnh án, Tên bệnh nhân, Ngày nhập viện, Ngày ra viện, Lý do nhập viện.

    private static int soLuongBenhAn = 1;
    private int soThuTu;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDo;

    public BenhAn() {
        soThuTu = soLuongBenhAn++;
    }

    public BenhAn(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDo) {
        this.soThuTu = soLuongBenhAn++;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDo = lyDo;
    }

    public static int getSoLuongBenhAn() {
        return soLuongBenhAn;
    }

    public static void setSoLuongBenhAn(int soLuongBenhAn) {
        BenhAn.soLuongBenhAn = soLuongBenhAn;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    @Override
    public String toString() {
        return "BenhAn{" +
                "soThuTu='" + soThuTu + '\'' +
                ", maBenhAn='" + maBenhAn + '\'' +
                ", maBenhNhan='" + maBenhNhan + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien='" + ngayNhapVien + '\'' +
                ", NgayRaVien='" + ngayRaVien + '\'' +
                ", lyDo='" + lyDo + '\'' +
                '}';
    }

    public String toStringToCSVFile() {
        return soThuTu + "," + maBenhAn + "," + maBenhNhan + "," + tenBenhNhan + "," + ngayNhapVien + "," + ngayRaVien + "," + lyDo;
    }
}

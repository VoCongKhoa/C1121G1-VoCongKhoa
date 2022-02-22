package bai_thi_thuc_hanh.models;

public class BenhAnBenhNhanVIP extends BenhAn {
    //    Loại VIP gồm các gói VIP I, VIP II và VIP III.
//  - Thời hạn VIP
    private String loaiVip;
    private String thoiHanVip; //tinh theo nam

    public BenhAnBenhNhanVIP() {
    }

    public BenhAnBenhNhanVIP(String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnBenhNhanVIP(String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien,
                             String ngayRaVien, String lyDo, String loaiVip, String thoiHanVip) {
        super(maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDo);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
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
                ", loaiVip='" + loaiVip + '\'' +
                ", thoiHanVip=" + thoiHanVip +
                '}';
    }

    @Override
    public String toStringToCSVFile() {
        return super.toStringToCSVFile() + "," + loaiVip + "," + thoiHanVip;
    }
}

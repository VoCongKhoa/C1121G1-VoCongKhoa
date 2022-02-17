package bai_thi_code_C08.models;

public class TaiKhoanThanhToan extends TaiKhoan {
    private String soThe;
    private double soTienTrongTaiKhoan;

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(String soThe, double soTienTrongTaiKhoan) {
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan, String soThe, double soTienTrongTaiKhoan) {
        super(maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public double getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "idTaiKhoan=" + getIdTaiKhoan() +
                ", maTaiKhoan='" + getMaTaiKhoan() + '\'' +
                ", tenChuTaiKhoan='" + getTenChuTaiKhoan() + '\'' +
                ", ngayTaoTaiKhoan='" + getNgayTaoTaiKhoan() + '\'' +
                ", soThe='" + soThe + '\'' +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan +
                '}';
    }

    @Override
    public String toStringToCSVFile() {
        return super.toStringToCSVFile() + "," + soThe + "," + soTienTrongTaiKhoan;
    }
}

package bai_thi_code_C08.models;

public class TaiKhoanTietKiem extends TaiKhoan{
    private double soTienGuiTietKiem;
    private String ngayGuiTietKiem;
    private int laiSuat;
    private int kyHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(double soTienGuiTietKiem, String ngayGuiTietKiem, int laiSuat, int kyHan) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem(String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan, double soTienGuiTietKiem, String ngayGuiTietKiem, int laiSuat, int kyHan) {
        super(maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public double getSoTienGuiTietKiem() {
        return soTienGuiTietKiem;
    }

    public void setSoTienGuiTietKiem(double soTienGuiTietKiem) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
    }

    public String getNgayGuiTietKiem() {
        return ngayGuiTietKiem;
    }

    public void setNgayGuiTietKiem(String ngayGuiTietKiem) {
        this.ngayGuiTietKiem = ngayGuiTietKiem;
    }

    public int getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(int laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "idTaiKhoan=" + getIdTaiKhoan() +
                ", maTaiKhoan='" + getMaTaiKhoan() + '\'' +
                ", tenChuTaiKhoan='" + getTenChuTaiKhoan() + '\'' +
                ", ngayTaoTaiKhoan='" + getNgayTaoTaiKhoan() + '\'' +
                ", soTienGuiTietKiem=" + soTienGuiTietKiem +
                ", ngayGuiTietKiem='" + ngayGuiTietKiem + '\'' +
                ", laiSuat=" + laiSuat +
                ", kyHan=" + kyHan +
                '}';
    }

    @Override
    public String toStringToCSVFile() {
        return super.toStringToCSVFile()+ "," + soTienGuiTietKiem + "," + ngayGuiTietKiem + "," + laiSuat + "," + kyHan ;
    }
}

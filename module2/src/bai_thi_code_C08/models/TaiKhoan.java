package bai_thi_code_C08.models;

public abstract class TaiKhoan {
    private static int demTaiKhoan = 1;
    private int idTaiKhoan;
    private String maTaiKhoan;
    private String tenChuTaiKhoan;
    private String ngayTaoTaiKhoan;

    public TaiKhoan() {
        this.idTaiKhoan = demTaiKhoan++;
    }

    public TaiKhoan(String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan) {
        this.idTaiKhoan = demTaiKhoan++;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public static int getDemTaiKhoan() {
        return demTaiKhoan;
    }

    public static void setDemTaiKhoan(int demTaiKhoan) {
        TaiKhoan.demTaiKhoan = demTaiKhoan;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public String getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(String ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "idTaiKhoan=" + idTaiKhoan +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenChuTaiKhoan='" + tenChuTaiKhoan + '\'' +
                ", ngayTaoTaiKhoan='" + ngayTaoTaiKhoan + '\'' +
                '}';
    }

    public String toStringToCSVFile(){
        return idTaiKhoan + "," + maTaiKhoan + "," + tenChuTaiKhoan + "," + ngayTaoTaiKhoan;
    }
}
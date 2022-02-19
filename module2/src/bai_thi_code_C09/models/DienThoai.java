package bai_thi_code_C09.models;

public abstract class DienThoai {
    //    ID, Tên điện thoại, Giá bán, Số lượng, Nhà sản xuất.
    private static int demDienThoai = 1;
    private int idDienThoai;
    private String tenDienThoai;
    private double giaBan;
    private int soLuong;
    private String nhaSanXuat;

    public DienThoai() {
        this.idDienThoai = demDienThoai++;
    }

    public DienThoai(String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat) {
        this.idDienThoai = demDienThoai++;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public static int getDemDienThoai() {
        return demDienThoai;
    }

    public static void setDemDienThoai(int demDienThoai) {
        DienThoai.demDienThoai = demDienThoai;
    }

    public int getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(int idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "idDienThoai=" + idDienThoai +
                ", tenDienThoai='" + tenDienThoai + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    public String toStringToFileCSV() {
        return idDienThoai + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSanXuat;
    }
}

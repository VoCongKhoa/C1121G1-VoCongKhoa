package bai_tt.models;

import java.util.Objects;

public class SanPham {
    static int soSanPham = 1;
    int idSanPham;
    String maSanPham;
    String tenSanPham;
    double giaBan;
    int soLuong;
    String nhaSanXuat;

    public SanPham() {
        idSanPham = soSanPham++;
    }

    public SanPham(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat) {
        this.idSanPham = soSanPham++;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public static int getSoSanPham() {
        return soSanPham;
    }

    public static void setSoSanPham(int soSanPham) {
        SanPham.soSanPham = soSanPham;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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
        return "SanPham{" +
                "idSanPham=" + idSanPham +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return Double.compare(sanPham.giaBan, giaBan) == 0 && soLuong == sanPham.soLuong
                && Objects.equals(maSanPham, sanPham.maSanPham) && Objects.equals(tenSanPham, sanPham.tenSanPham)
                && Objects.equals(nhaSanXuat, sanPham.nhaSanXuat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSanPham, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
    }

    public String toStringToFileCSV(){
        return idSanPham + "," + maSanPham + "," + tenSanPham + "," + giaBan + "," + soLuong + "," + nhaSanXuat;
    }
}

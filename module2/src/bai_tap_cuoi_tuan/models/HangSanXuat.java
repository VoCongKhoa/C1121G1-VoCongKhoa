package bai_tap_cuoi_tuan.models;

public class HangSanXuat {
    private String idHangSanXuat;
    private String tenHangSanXuat;
    private String quocGia;

    public HangSanXuat() {
    }

    public HangSanXuat(String idHangSanXuat, String tenHangSanXuat, String quocGia) {
        this.idHangSanXuat = idHangSanXuat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.quocGia = quocGia;
    }

    public String getIdHangSanXuat() {
        return idHangSanXuat;
    }

    public void setIdHangSanXuat(String idHangSanXuat) {
        this.idHangSanXuat = idHangSanXuat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return idHangSanXuat+ ", " + tenHangSanXuat + ", " + quocGia;
    }
}
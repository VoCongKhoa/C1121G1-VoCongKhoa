package bai_tap_cuoi_tuan.models;

public class Oto extends PhuongTienGiaoThong{
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(int soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Oto(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "bienKiemSoat='" + super.getBienKiemSoat() + '\'' +
                ", tenHangSanXuat='" + super.getTenHangSanXuat() + '\'' +
                ", namSanXuat='" + super.getNamSanXuat() + '\'' +
                ", chuSoHuu='" + super.getChuSoHuu() + '\'' +
                ", soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }
}

package bai_tap_cuoi_tuan.models;

public class XeMay extends PhuongTienGiaoThong{
    private String congSuat;

    public XeMay() {
    }

    public XeMay(String congSuat) {
        this.congSuat = congSuat;
    }

    public XeMay(String bienKiemSoat, HangSanXuat tenHangSanXuat, int namSanXuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                "bienKiemSoat='" + super.getBienKiemSoat() + '\'' +
                ", tenHangSanXuat='" + super.getHangSanXuat() + '\'' +
                ", namSanXuat='" + super.getNamSanXuat() + '\'' +
                ", chuSoHuu='" + super.getChuSoHuu() + '\'' +
                ", congSuat='" + congSuat + '\'' +
                '}';
    }
}

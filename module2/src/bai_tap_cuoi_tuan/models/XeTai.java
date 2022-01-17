package bai_tap_cuoi_tuan.models;

public class XeTai extends PhuongTienGiaoThong{
    private String trongTai;

    public XeTai() {
    }

    public XeTai(String trongTai) {
        this.trongTai = trongTai;
    }

    public XeTai(String bienKiemSoat, HangSanXuat tenHangSanXuat, int namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                "bienKiemSoat='" + super.getBienKiemSoat() + '\'' +
                ", tenHangSanXuat='" + super.getHangSanXuat() + '\'' +
                ", namSanXuat='" + super.getNamSanXuat() + '\'' +
                ", chuSoHuu='" + super.getChuSoHuu() + '\'' +
                ", trongTai='" + trongTai + '\'' +
                '}';
    }
}

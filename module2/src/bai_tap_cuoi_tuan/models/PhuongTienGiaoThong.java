package bai_tap_cuoi_tuan.models;

import java.util.Objects;

public abstract class PhuongTienGiaoThong {
    private String bienKiemSoat;
    private HangSanXuat hangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    public PhuongTienGiaoThong(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public PhuongTienGiaoThong() {
    }

    public PhuongTienGiaoThong(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "PhuongTienGiaoThong{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhuongTienGiaoThong that = (PhuongTienGiaoThong) o;
        return Objects.equals(bienKiemSoat, that.bienKiemSoat);
    }

}

package bai_thi_code_C09.models;

public class DienThoaiChinhHang extends DienThoai{
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(int thoiGianBaoHanh, String phamViBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public DienThoaiChinhHang(String tenDienThoai, double giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang{" +
                "idDienThoai=" + getIdDienThoai() +
                ", tenDienThoai='" + getTenDienThoai() + '\'' +
                ", giaBan=" + getGiaBan() +
                ", soLuong=" + getSoLuong() +
                ", nhaSanXuat='" + getNhaSanXuat() + '\'' +
                ", thoiGianBaoHanh=" + thoiGianBaoHanh +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                '}';
    }

    @Override
    public String toStringToFileCSV() {
        return super.toStringToFileCSV()+"," + thoiGianBaoHanh + "," + phamViBaoHanh;
    }
}

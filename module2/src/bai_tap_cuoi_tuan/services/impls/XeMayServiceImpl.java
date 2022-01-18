package bai_tap_cuoi_tuan.services.impls;

import bai_tap_cuoi_tuan.models.*;
import bai_tap_cuoi_tuan.services.XeMayService;

import java.util.*;

public class XeMayServiceImpl implements XeMayService {
    static List<XeMay> xeMayArrayList = new ArrayList<>();
    static List<HangSanXuat> hangSanXuatList = new ArrayList<>();

    static {
        hangSanXuatList.add(new HangSanXuat("HSX-001", "Yamaha", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-002", "Honda", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-003", "Dongfeng", "Trung Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-004", "Huyndai", "Hàn Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-005", "Ford", "Mỹ"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Toyota", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Hino", "Nhật Bản"));

        xeMayArrayList.add(new XeMay("43G1-015.45", hangSanXuatList.get(2), 2010,
                "Khoa", "1000cc"));
        xeMayArrayList.add(new XeMay("92G1-593.45", hangSanXuatList.get(3), 2005,
                "Su", "2000cc"));
        xeMayArrayList.add(new XeMay("92G1-136.45", hangSanXuatList.get(4), 2000,
                "Vo", "3000cc"));
    }
    @Override
    public void themMoi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát mới:");
        String bienKiemSoat = sc.nextLine();
        System.out.println("Chọn tên hãng sản xuất mới:");
        System.out.println("1.\tYamaha\n" +
                "2.\tHonda\n" +
                "3.\tDongfeng\n" +
                "4.\tHuyndai\n" +
                "5.\tFord\n" +
                "6.\tToyota\n" +
                "7.\tHino\n");
        HangSanXuat tenHangSanXuat = hangSanXuatList.get(Integer.parseInt(sc.nextLine())-1);
        System.out.println("Nhập năm sản xuất mới:");
        int namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chủ sở hữu mới:");
        String chuSoHuu = sc.nextLine();
        System.out.println("Nhập công suất mới:");
        String congSuat = sc.nextLine();
        xeMayArrayList.add(new XeMay(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, congSuat));
        System.out.println("Thêm mới xe máy thành công!!!");
    }

    @Override
    public void hienThi() {
        for (XeMay xeMay : xeMayArrayList) {
            System.out.println(xeMay);
        }
    }


    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát xe máy cần xoá:");
        String bienKiemSoat = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < xeMayArrayList.size(); i++) {
            if (xeMayArrayList.get(i).getBienKiemSoat().toLowerCase().contains(bienKiemSoat.toLowerCase())) {
                flag = true;
                System.out.println("Bạn có xác nhận muốn xoá xe máy có biển kiểm soát " +
                        xeMayArrayList.get(i).getBienKiemSoat() + " khỏi danh sách không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int xacNhan = Integer.parseInt(sc.nextLine());
                if (xacNhan == 1) {
                    System.out.println("Bạn đã xoá xe máy có biển kiểm soát " +
                            xeMayArrayList.get(i).getBienKiemSoat() + " khỏi danh sách!");
                    xeMayArrayList.remove(i);
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("Bạn nhập sai!");
        }
    }

    public boolean xacNhan(XeMay xeMay){
        return xeMayArrayList.contains(xeMay);
    }
    @Override
    public <XeMay> void xoa(XeMay xeMay){
        xeMayArrayList.remove(xeMay);
    }
}

package bai_tap_cuoi_tuan.services.impls;

import bai_tap_cuoi_tuan.models.*;
import bai_tap_cuoi_tuan.services.XeTaiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiServiceImpl implements XeTaiService {
    static List<XeTai> xeTaiArrayList = new ArrayList<>();
    static List<HangSanXuat> hangSanXuatList = new ArrayList<>();

    static {
        hangSanXuatList.add(new HangSanXuat("HSX-001", "Yamaha", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-002", "Honda", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-003", "Dongfeng", "Trung Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-004", "Huyndai", "Hàn Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-005", "Ford", "Mỹ"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Toyota", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Hino", "Nhật Bản"));

        xeTaiArrayList.add(new XeTai("43G1-758.48", hangSanXuatList.get(4), 2010,
                "Khoa", "10T"));
        xeTaiArrayList.add(new XeTai("92G1-023.45", hangSanXuatList.get(5), 2005,
                "Su", "20T"));
        xeTaiArrayList.add(new XeTai("92G1-741.42", hangSanXuatList.get(6), 2000,
                "Vo", "30T"));
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
        System.out.println("Nhập trọng tải mới:");
        String trongTai = sc.nextLine();
        xeTaiArrayList.add(new XeTai(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, trongTai));
        System.out.println("Thêm mới xe máy thành công!!!");
    }

    @Override
    public void hienThi() {
        for (XeTai xeTai : xeTaiArrayList) {
            System.out.println(xeTai);
        }
    }

    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát xe tải cần xoá:");
        String bienKiemSoat = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < xeTaiArrayList.size(); i++) {
            if (xeTaiArrayList.get(i).getBienKiemSoat().toLowerCase().contains(bienKiemSoat.toLowerCase())) {
                flag = true;
                System.out.println("Bạn có xác nhận muốn xoá xe tải có biển kiểm soát " +
                        xeTaiArrayList.get(i).getBienKiemSoat() + " khỏi danh sách không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int xacNhan = Integer.parseInt(sc.nextLine());
                if (xacNhan == 1) {
                    System.out.println("Bạn đã xoá xe tải có biển kiểm soát " +
                            xeTaiArrayList.get(i).getBienKiemSoat() + " khỏi danh sách!");
                    xeTaiArrayList.remove(i);
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("Bạn nhập sai!");
        }
    }
}

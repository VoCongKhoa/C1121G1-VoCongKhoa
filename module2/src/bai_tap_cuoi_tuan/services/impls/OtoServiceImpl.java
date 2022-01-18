package bai_tap_cuoi_tuan.services.impls;

import bai_tap_cuoi_tuan.models.*;
import bai_tap_cuoi_tuan.services.OtoService;

import java.util.*;

public class OtoServiceImpl implements OtoService {

    static List<Oto> otoArrayList = new ArrayList<>();
    static List<HangSanXuat> hangSanXuatList = new ArrayList<>();
    static Map<Integer, String> kieuXeList = new TreeMap<>();

    static {
        hangSanXuatList.add(new HangSanXuat("HSX-001", "Yamaha", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-002", "Honda", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-003", "Dongfeng", "Trung Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-004", "Huyndai", "Hàn Quốc"));
        hangSanXuatList.add(new HangSanXuat("HSX-005", "Ford", "Mỹ"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Toyota", "Nhật Bản"));
        hangSanXuatList.add(new HangSanXuat("HSX-006", "Hino", "Nhật Bản"));

        kieuXeList.put(1, "Du lịch");
        kieuXeList.put(2, "Xe khách");

        otoArrayList.add(new Oto("43G1-123.45", hangSanXuatList.get(1), 2000,
                "Khoa", 7, "Du lịch"));
        otoArrayList.add(new Oto("92E1-456.78", hangSanXuatList.get(2), 2010,
                "Su", 7, "Xe khách"));
        otoArrayList.add(new Oto("43G1-789.00", hangSanXuatList.get(3), 2000,
                "Khoa", 7, "Du lịch"));
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
        HangSanXuat tenHangSanXuat = hangSanXuatList.get(Integer.parseInt(sc.nextLine()) - 1);
        System.out.println("Nhập năm sản xuất mới:");
        int namSanXuat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chủ sở hữu mới:");
        String chuSoHuu = sc.nextLine();
        System.out.println("Nhập số chỗ ngồi mới:");
        int soChoNgoi = Integer.parseInt(sc.nextLine());
        System.out.println("Chọn kiểu xe mới:");
        System.out.println("1.\tDu lịch\n" +
                "2.\tXe khách\n");
        String kieuXe = kieuXeList.get(Integer.parseInt(sc.nextLine()));
        otoArrayList.add(new Oto(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe));
        System.out.println("Thêm mới Ô tô thành công!!!");
    }

    @Override
    public void hienThi() {
        for (Oto oto : otoArrayList) {
            System.out.println(oto);
        }
    }


    public void delete() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển kiểm soát xe ôtô cần xoá:");
        String bienKiemSoat = sc.nextLine();
//        Oto deleteOto = new Oto("ádsad");

        for (Oto oto : otoArrayList) {
            if (oto.getBienKiemSoat().contains(bienKiemSoat)) {
                System.out.println("Bạn có xác nhận muốn xoá xe ô tô có biển kiểm soát " +
                        oto.getBienKiemSoat() + " khỏi danh sách không?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int xacNhan = Integer.parseInt(sc.nextLine());
                if (xacNhan == 1) {
                    System.out.println("Bạn đã xoá xe ô tô có biển kiểm soát " +
                            oto.getBienKiemSoat() + " khỏi danh sách!");
//                    this.delete(oto);
                }
                break;
            }
        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập biển kiểm soát xe ôtô cần xoá:");
//        String bienKiemSoat = sc.nextLine();
//        boolean flag = false;
//        for (int i = 0; i < otoArrayList.size(); i++) {
//            if (otoArrayList.get(i).getBienKiemSoat().toLowerCase().contains(bienKiemSoat.toLowerCase())) {
//                flag = true;
//                System.out.println("Bạn có xác nhận muốn xoá xe ô tô có biển kiểm soát " +
//                        otoArrayList.get(i).getBienKiemSoat() + " khỏi danh sách không?");
//                System.out.println("1. Có");
//                System.out.println("2. Không");
//                int xacNhan = Integer.parseInt(sc.nextLine());
//                if (xacNhan == 1) {
//                    System.out.println("Bạn đã xoá xe ô tô có biển kiểm soát " +
//                            otoArrayList.get(i).getBienKiemSoat() + " khỏi danh sách!");
//                    otoArrayList.remove(i);
//                }
//                break;
//            }
//        }
//        if (!flag) {
//            System.out.println("Bạn nhập sai!");
//        }
    }

    public boolean xacNhan(Oto oto){
        return otoArrayList.contains(oto);
    }

    @Override
    public <Oto> void xoa(Oto oto){
            otoArrayList.remove(oto);
    }
}


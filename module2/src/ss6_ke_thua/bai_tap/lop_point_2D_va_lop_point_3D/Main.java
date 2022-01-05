package ss6_ke_thua.bai_tap.lop_point_2D_va_lop_point_3D;

public class Main {
    public static void main(String[] args) {
        testPoint2D();
        testPoint3D();
    }
    public static void testPoint2D(){
        Point2D point2D1 = new Point2D();
        System.out.println(point2D1);
        Point2D point2D2 = new Point2D(10.0f,20.0f);
        System.out.println(point2D2);
    }
    public static void testPoint3D(){
        Point3D point3D1 = new Point3D();
        System.out.println(point3D1);
        Point3D point3D2 = new Point3D(10.0f,20.0f,30.0f);
        System.out.println(point3D2);
    }
}

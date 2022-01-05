package ss6_ke_thua.bai_tap.lop_point_va_moveablepoint;

public class Main {
    public static void main(String[] args) {
        testPoint();
        testMovablePoint();
    }
    public static void testPoint(){
        Point point1 = new Point();
        System.out.println(point1);
        Point point2 = new Point(10.0f,20.0f);
        System.out.println(point2);
    }
    public static void testMovablePoint(){
        MovablePoint movablePoint1 = new MovablePoint();
        System.out.println(movablePoint1);
        MovablePoint movablePoint2 = new MovablePoint(2.0f,4.0f);
        System.out.println(movablePoint2);
        MovablePoint movablePoint3 = new MovablePoint(10.0f,20.0f,2.0f,4.0f);
        System.out.println(movablePoint3);
        System.out.println(movablePoint3.move());
    }
}

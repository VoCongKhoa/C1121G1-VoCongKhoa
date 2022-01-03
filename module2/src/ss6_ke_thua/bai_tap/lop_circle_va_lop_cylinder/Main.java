package ss6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Main {
    public static void main(String[] args) {
        circleTest ();
//        cylinderTest ();
    }

    public static void circleTest (){
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(10, "red");
        System.out.println(circle);

        System.out.printf(circle + " has:\n" +
                "    Area = %.3f\n    Perimeter = %.3f", circle.getArea(), circle.getPerimeter());
    }

    public static void cylinderTest (){
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(10, "blue", 20);
        System.out.printf(cylinder + " has:\n" +
                        "    SurroundingArea = %.3f\n    TotalArea = %.3f\n    Volume = %.3f",
                cylinder.getSurroundingArea(), cylinder.getTotalArea(), cylinder.getVolume());
    }
}

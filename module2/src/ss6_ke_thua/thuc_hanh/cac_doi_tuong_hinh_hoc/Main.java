package ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc;

public class Main {
    public static void main(String[] args) {
        shapeTest();
        circleTest();
        RectangleTest();
        SquareTest();
    }

    public static void shapeTest(){
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
    }

    public static void circleTest() {
            Circle circle = new Circle();
            System.out.println(circle);

            circle = new Circle(10);
            System.out.println(circle);

            circle = new Circle("blue", false, 10);
            System.out.println(circle);
    }

    public static void RectangleTest(){
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(5, 10);
        System.out.println(rectangle);

        rectangle = new Rectangle("red", true, 5, 10);
        System.out.println(rectangle);
    }

    public static void SquareTest () {
        Square square = new Square();
        System.out.println(square);

        square = new Square(10);
        System.out.println(square);

        square = new Square("orange", true, 10);
        System.out.println(square);
    }
}

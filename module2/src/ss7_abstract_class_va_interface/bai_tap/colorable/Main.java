package ss7_abstract_class_va_interface.bai_tap.colorable;

import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Square;

public class Main {
    public static void main(String[] args) {
        Square colorableSquare1 = new ColorableSquare(5.0);
        Square normalSquare = new Square(10);

        Square[] list = new Square[2];
        list[0] = colorableSquare1;
        list[1] = normalSquare;
        for (int i = 0; i < list.length; i++) {
            System.out.printf("Area of square %d = %f\n", i + 1, list[i].getArea());
            if (list[i] instanceof ColorableSquare) {
                ((ColorableSquare) list[i]).howToColor(i + 1);
            } else {
                System.out.println("This square can't color!");
            }
        }
    }
}

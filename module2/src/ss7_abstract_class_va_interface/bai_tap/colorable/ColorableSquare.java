package ss7_abstract_class_va_interface.bai_tap.colorable;

import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Square;

public class ColorableSquare extends Square implements Colorable{

    public ColorableSquare() {
    }

    public ColorableSquare(double side) {
        super(side);
    }

    public ColorableSquare(String color, boolean filled, double side) {
        super(color, filled, side);
    }

    @Override
    public void howToColor(int index) {
        System.out.printf("Color all four sides of Square %d\n",index);
    }


}

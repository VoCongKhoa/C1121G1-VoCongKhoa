package ss7_abstract_class_va_interface.thuc_hanh.interface_comparable;


import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Circle;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 100;
        else if (getRadius() < o.getRadius()) return -100;
        else return 0;
    }
}

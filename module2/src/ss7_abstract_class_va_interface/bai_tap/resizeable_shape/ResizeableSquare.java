package ss7_abstract_class_va_interface.bai_tap.resizeable_shape;

import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Square;

public class ResizeableSquare extends Square implements Resizeable {
    @Override
    public void resize(double percent) {
        setSide(percent*getSide());
    }
}

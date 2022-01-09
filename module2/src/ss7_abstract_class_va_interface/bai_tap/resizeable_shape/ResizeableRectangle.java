package ss7_abstract_class_va_interface.bai_tap;

import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Rectangle;

public class ResizeableRectangle extends Rectangle implements Resizeable {
    @Override
    public void resize(double percent) {
        setLength(percent*getLength());
        setWidth(percent*getWidth());
    }
}

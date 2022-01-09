package ss7_abstract_class_va_interface.bai_tap;

import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Circle;
import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Rectangle;
import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Shape;
import ss6_ke_thua.thuc_hanh.cac_doi_tuong_hinh_hoc.Square;

import java.util.List;
import java.util.Random;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape resizeableCircle = new ResizeableCircle();
        Shape resizeableRectangle = new ResizeableRectangle();
        Shape resizeableSquare = new ResizeableSquare();

        Shape[] shapeList = new Shape[3];
        shapeList[0] = resizeableCircle;
        shapeList[1] = resizeableRectangle;
        shapeList[2] = resizeableSquare;
        Random random = new Random();

        for (Shape shape : shapeList) {
            if (shape instanceof ResizeableCircle) {
                System.out.println("Circle before resize:\n" +
                        "Area = " + ((ResizeableCircle) resizeableCircle).getArea());
                ((ResizeableCircle) resizeableCircle).resize(random.nextDouble());
                System.out.println("Circle after resize:\n" +
                        "Area = " + ((ResizeableCircle) resizeableCircle).getArea() + "\n");
            } else if (shape instanceof ResizeableRectangle) {
                System.out.println("Rectangle before resize:" +
                        "Area = " + ((ResizeableRectangle) resizeableRectangle).getArea() + "\n" +
                        "Perimeter = " + ((ResizeableRectangle) resizeableRectangle).getPerimeter());
                ((ResizeableRectangle) resizeableRectangle).resize(random.nextDouble());
                System.out.println("Rectangle before resize:" +
                        "Area = " + ((ResizeableRectangle) resizeableRectangle).getArea() + "\n" +
                        "Perimeter = " + ((ResizeableRectangle) resizeableRectangle).getPerimeter() + "\n");
            } else {
                System.out.println("Square before resize:" +
                        "Area = " + ((ResizeableSquare) resizeableSquare).getArea() + "\n" +
                        "Perimeter = " + ((ResizeableSquare) resizeableSquare).getPerimeter());
                ((ResizeableSquare) resizeableSquare).resize(random.nextDouble());
                System.out.println("Square before resize:" +
                        "Area = " + ((ResizeableSquare) resizeableSquare).getArea() + "\n" +
                        "Perimeter = " + ((ResizeableSquare) resizeableSquare).getPerimeter() + "\n");
            }
        }
    }
}

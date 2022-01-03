package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.Rectangle;

public class Rectangle {
    int width, height;

    public Rectangle() {

    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return this.width * this.height;
    }

    public int getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Area = " + getArea() + "\n" +
                "Perimeter = " + getPerimeter();
    }
}

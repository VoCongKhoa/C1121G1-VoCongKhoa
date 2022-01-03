package ss6_ke_thua.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSurroundingArea(){
        return super.getPerimeter()*height;
    }
    public double getTotalArea() {
        return super.getArea()*2 + this.getSurroundingArea();
    }

    public double getVolume(){
        return super.getArea()*height;
    }

    @Override
    public String toString(){
        return "A Cylinder with height = " + this.getHeight() + ", which is a subclass of " + super.toString();
    }
}

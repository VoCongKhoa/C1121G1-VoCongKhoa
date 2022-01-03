package ss5_access_modifier_static_method_static_property.bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }
    public Circle(double r) {
        this.radius = r;
    }

    protected double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected double getArea(){
        return Math.PI*Math.pow(this.radius,2);
    }
}

class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.getRadius();
        circle.getArea();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }

}


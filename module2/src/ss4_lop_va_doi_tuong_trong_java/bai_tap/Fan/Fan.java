package ss4_lop_va_doi_tuong_trong_java.bai_tap.Fan;

public class Fan {

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
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

    public String toString() {
        if (this.on) {
            return "Fan{" +
                    "speed=" + speed +
                    ", on= Fan is on"  +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }else {
            return "Fan{" +
                    "speed=" + speed +
                    ", on= Fan is off" +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }

    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}

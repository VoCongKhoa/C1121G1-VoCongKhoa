package ss5_access_modifier_static_method_static_property.thuc_hanh.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {

        Car car1 = new Car("BMW","ABC123");

        System.out.println(Car.numberOfCars);

        Car car2 = new Car("Lexus","XYZ456");

        System.out.println(Car.numberOfCars);

    }
}

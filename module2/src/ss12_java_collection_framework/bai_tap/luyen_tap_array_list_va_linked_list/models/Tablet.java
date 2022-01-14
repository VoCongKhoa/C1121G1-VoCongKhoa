package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models;

public class Tablet extends ElectricProduct{
    public Tablet() {
    }

    public Tablet(String name, String brand, double price, String screen, String RAM, String color) {
        super(name, brand, price, screen, RAM, color);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", screen='" + super.getScreen() + '\'' +
                ", RAM='" + super.getRAM() + '\'' +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}

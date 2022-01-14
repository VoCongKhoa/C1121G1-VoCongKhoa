package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models;

public class Laptop extends ElectricProduct {
    private String SSD;

    public Laptop() {
    }

    public Laptop(String SSD) {
        this.SSD = SSD;
    }

    public Laptop(String name, String brand, double price, String screen, String RAM, String color, String SSD) {
        super(name, brand, price, screen, RAM, color);
        this.SSD = SSD;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String SSD) {
        this.SSD = SSD;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", screen='" + super.getScreen() + '\'' +
                ", RAM='" + super.getRAM() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", SSD='" + SSD + '\'' +
                '}';
    }
}

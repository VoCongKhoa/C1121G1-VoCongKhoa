package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models;

public abstract class ElectricProduct {
    private String name;
    private String brand;
    private double price;
    private String screen;
    private String RAM;
    private String color;

    public ElectricProduct() {
    }

    public ElectricProduct(String name, String brand, double price, String screen, String RAM, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.screen = screen;
        this.RAM = RAM;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ElectricProduct{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", screen='" + screen + '\'' +
                ", RAM='" + RAM + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}


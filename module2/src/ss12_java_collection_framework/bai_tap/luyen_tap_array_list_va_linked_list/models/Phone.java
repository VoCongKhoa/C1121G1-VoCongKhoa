package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models;

public class Phone extends ElectricProduct {
    private String camera;
    private String type;

    public Phone() {
    }

    public Phone(String camera, String type) {
        this.camera = camera;
        this.type = type;
    }

    public Phone(String name, String brand, double price, String screen, String RAM, String color, String camera, String type) {
        super(name, brand, price, screen, RAM, color);
        this.camera = camera;
        this.type = type;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + super.getName() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", price='" + super.getPrice() + '\'' +
                ", screen='" + super.getScreen() + '\'' +
                ", RAM='" + super.getRAM() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", camera='" + camera + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

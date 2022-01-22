package ss17_binary_file_and_serialization.bai_tap.quan_ly_san_pham_file_nhi_phan;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String name;
    private String brand;
    private double price;
    private String otherInfor;

    public Product() {
    }

    public Product(int productID, String name, String brand, double price, String otherInfor) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.otherInfor = otherInfor;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    public String getOtherInfor() {
        return otherInfor;
    }

    public void setOtherInfor(String otherInfor) {
        this.otherInfor = otherInfor;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", otherInfor='" + otherInfor + '\'' +
                '}';
    }
}

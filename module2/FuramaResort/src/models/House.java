package models;

public class House extends Facility{
    private String houseType;
    private int houseNumberFloor;

    public House() {
    }

    public House(String houseType, int houseNumberFloor) {
        this.houseType = houseType;
        this.houseNumberFloor = houseNumberFloor;
    }

    public House(String serviceName, double usableArea, double price, int maximumPerson, int rentType, String houseType, int houseNumberFloor) {
        super(serviceName, usableArea, price, maximumPerson, rentType);
        this.houseType = houseType;
        this.houseNumberFloor = houseNumberFloor;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getHouseNumberFloor() {
        return houseNumberFloor;
    }

    public void setHouseNumberFloor(int houseNumberFloor) {
        this.houseNumberFloor = houseNumberFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseType='" + houseType + '\'' +
                ", houseNumberFloor=" + houseNumberFloor +
                '}';
    }
}

package models;

public class Villa extends Facility{
    private String villaType;
    private double villaPoolArea;
    private int villaNumberFloor;

    public Villa() {
    }

    public Villa(String villaType, double villaPoolArea, int villaNumberFloor) {
        this.villaType = villaType;
        this.villaPoolArea = villaPoolArea;
        this.villaNumberFloor = villaNumberFloor;
    }

    public Villa(String serviceName, double usableArea, double price, int maximumPerson, int rentType, String villaType, double villaPoolArea, int villaNumberFloor) {
        super(serviceName, usableArea, price, maximumPerson, rentType);
        this.villaType = villaType;
        this.villaPoolArea = villaPoolArea;
        this.villaNumberFloor = villaNumberFloor;
    }

    public String getVillaType() {
        return villaType;
    }

    public void setVillaType(String villaType) {
        this.villaType = villaType;
    }

    public double getVillaPoolArea() {
        return villaPoolArea;
    }

    public void setVillaPoolArea(double villaPoolArea) {
        this.villaPoolArea = villaPoolArea;
    }

    public int getVillaNumberFloor() {
        return villaNumberFloor;
    }

    public void setVillaNumberFloor(int villaNumberFloor) {
        this.villaNumberFloor = villaNumberFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "villaType='" + villaType + '\'' +
                ", villaPoolArea=" + villaPoolArea +
                ", villaNumberFloor=" + villaNumberFloor +
                '}';
    }
}

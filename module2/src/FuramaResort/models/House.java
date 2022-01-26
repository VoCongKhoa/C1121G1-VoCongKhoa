package FuramaResort.models;

public class House extends Facility {
    private String houseType;
    private int houseNumberFloor;

    public House() {
    }

    public House(String houseType, int houseNumberFloor) {
        this.houseType = houseType;
        this.houseNumberFloor = houseNumberFloor;
    }

    public House(String idService, String serviceName, double usableArea, double price, int maximumPerson,
                 String rentType, String houseType, int houseNumberFloor) {
        super(idService, serviceName, usableArea, price, maximumPerson, rentType);
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
                "idService = '" + getIdService() + '\'' +
                ", serviceName = " + getServiceName() +
                ", usableArea = " + getUsableArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaximumPerson() +
                ", rentType = " + getRentType() +
                ", houseType = " + houseType +
                ", houseNumberFloor = " + houseNumberFloor +
                '}';
    }

    public String toStringToCSVFile() {
        return getIdService() + "," + getServiceName() + "," + getUsableArea() + "," + getPrice() + "," +
                getMaximumPerson() + "," + getRentType() + "," + houseType + "," + houseNumberFloor;
    }
}

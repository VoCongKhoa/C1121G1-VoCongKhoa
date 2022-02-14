package FuramaResort.models;

public class Villa extends Facility {
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

    public Villa(String idService, String serviceName, double usableArea, double price, int maximumPerson, String rentType, String villaType, double villaPoolArea, int villaNumberFloor, int bookingCount) {
        super(idService, serviceName, usableArea, price, maximumPerson, rentType, bookingCount);
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
                "idService = '" + getIdService() + '\'' +
                ", serviceName = " + getServiceName() +
                ", usableArea = " + getUsableArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaximumPerson() +
                ", rentType = " + getRentType() +
                ", villaType = " + villaType +
                ", villaPoolArea = " + villaPoolArea +
                ", villaNumberFloor = " + villaNumberFloor +
                ", bookingCount=" + getBookingCount() +
                '}';
    }

    public String toStringToCSVFile() {
        return getIdService() + "," + getServiceName() + "," + getUsableArea() + "," + getPrice() + "," +
                getMaximumPerson() + "," + getRentType() + "," + villaType + "," + villaPoolArea + "," +
                villaNumberFloor + "," + getBookingCount();
    }
}

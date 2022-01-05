package models;

public abstract class Facility {
    private String serviceName;
    private double usableArea;
    private double price;
    private int maximumPerson;
    private int rentType;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double price, int maximumPerson, int rentType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.rentType = rentType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", price=" + price +
                ", maximumPerson=" + maximumPerson +
                ", rentType=" + rentType +
                '}';
    }
}

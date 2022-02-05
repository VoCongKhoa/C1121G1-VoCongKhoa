package FuramaResort.models;

import java.util.Objects;

public abstract class
Facility {
    private String idService;
    private String serviceName;
    private double usableArea;
    private double price;
    private int maximumPerson;
    private String rentType;

    public Facility() {
    }

    public Facility(String idService, String serviceName, double usableArea, double price, int maximumPerson, String rentType) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.rentType = rentType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
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

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idService = '" + idService + '\'' +
                ", serviceName = " + serviceName +
                ", usableArea = " + usableArea +
                ", price = " + price +
                ", maximumPerson = " + maximumPerson +
                ", rentType = " + rentType +
                '}';
    }

    public String toStringToCSVFile() {
        return idService + "," + serviceName + "," + usableArea + "," + price + "," + maximumPerson + "," + rentType;
    }
}

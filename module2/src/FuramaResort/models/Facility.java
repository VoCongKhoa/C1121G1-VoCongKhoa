package FuramaResort.models;

public abstract class Facility {
    private static String serviceName;
    private double usableArea;
    private double price;
    private int maximumPerson;
    private static String rentType;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double price, int maximumPerson, String rentType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.rentType = rentType;
    }

    public static String getServiceName() {
        return serviceName;
    }

    public static void setServiceName(String serviceName) {
        Facility.serviceName = serviceName;
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

    public static String getRentType() {
        return rentType;
    }

    public static void setRentType(String rentType) {
        Facility.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName = '" + serviceName + '\'' +
                ", usableArea = " + usableArea +
                ", price = " + price +
                ", maximumPerson = " + maximumPerson +
                ", rentType = " + rentType +
                '}';
    }
}

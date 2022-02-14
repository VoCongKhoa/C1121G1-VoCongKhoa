package FuramaResort.models;

public class Room extends Facility{
    private String roomFreeService;

    public Room() {
    }

    public Room(String roomFreeService) {
        this.roomFreeService = roomFreeService;
    }

    public Room(String idService, String serviceName, double usableArea, double price, int maximumPerson,
                String rentType, String roomFreeService, int bookingCount) {
        super(idService, serviceName, usableArea, price, maximumPerson, rentType, bookingCount);
        this.roomFreeService = roomFreeService;
    }

    public String getRoomFreeService() {
        return roomFreeService;
    }

    public void setRoomFreeService(String roomFreeService) {
        this.roomFreeService = roomFreeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idService = '" + getIdService() + '\'' +
                ", serviceName = " + getServiceName() +
                ", usableArea = " + getUsableArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaximumPerson() +
                ", rentType = " + getRentType() +
                ", roomFreeService = " + roomFreeService +
                ", bookingCount=" + getBookingCount() +
                '}';
    }

    public String toStringToCSVFile() {
        return getIdService() + "," + getServiceName() + "," + getUsableArea() + "," + getPrice() + "," +
                getMaximumPerson() + "," + getRentType() + "," + roomFreeService + "," + getBookingCount();
    }
}

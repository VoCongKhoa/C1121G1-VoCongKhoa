package FuramaResort.models;

public class Room extends Facility{
    private String roomFreeService;

    public Room() {
    }

    public Room(String roomFreeService) {
        this.roomFreeService = roomFreeService;
    }

    public Room(String serviceName, double usableArea, double price, int maximumPerson,
                String rentType, String roomFreeService) {
        super(serviceName, usableArea, price, maximumPerson, rentType);
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
                "serviceName = '" + getServiceName() + '\'' +
                ", usableArea = " + getUsableArea() +
                ", price = " + getPrice() +
                ", maximumPerson = " + getMaximumPerson() +
                ", rentType = " + getRentType() +
                ", roomFreeService = " + roomFreeService +
                '}';
    }
}

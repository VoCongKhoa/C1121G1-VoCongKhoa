package FuramaResort.services.impls;

import FuramaResort.models.*;
import FuramaResort.services.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    Scanner sc = new Scanner(System.in);
    static Map<Facility, Integer> facilityServiceList = new LinkedHashMap<>();

    static {
        Villa villa = new Villa("VL001","bookingVilla", 100, 10, 10,
                "day", "big", 25, 3);
        House house = new House("HS001","bookingHouse", 100, 10, 10,
                "day", "medium", 2);
        Room room = new Room("RO001","bookingRoom", 100, 10, 10,
                "day", "free");

        facilityServiceList.put(villa, 2);
        facilityServiceList.put(house, 4);
        facilityServiceList.put(room, 6);
    }

    @Override
    public void displayFacility() {
        for (Map.Entry<Facility, Integer> entry : facilityServiceList.entrySet()) {
            System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
        }
        //Không cast KDL Facility sang Room, House,Villa được??
//        Collection<Facility> facilityList = facilityServiceList.keySet();
//        for (int i = 0; i < facilityList.size(); i++) {
//            if ((Room)facilityList.toArray()[i] instanceof Room){
//                System.out.println("Room");
//            } else if ((Villa)facilityList.toArray()[i] instanceof Villa){
//                System.out.println("Villa");
//            } else if ((House)facilityList.toArray()[i] instanceof House){
//                System.out.println("House");
//            }
//        }
    }

    @Override
    public void addFacility() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n");
        System.out.println("Choose facility you wanna add:");
        int addFacilityChoice = Integer.parseInt(sc.nextLine());
        switch (addFacilityChoice) {
            case 1:
                System.out.print("Input id service:");
                String villaIdService = sc.nextLine();
                System.out.print("Input service name:");
                String villaServiceName = sc.nextLine();
                System.out.print("Input usable area:");
                double villaUsableArea = Double.parseDouble(sc.nextLine());
                System.out.print("Input price:");
                double villaPrice = Double.parseDouble(sc.nextLine());
                System.out.print("Input maximum person:");
                int villaMaximumPerson = Integer.parseInt(sc.nextLine());
                System.out.print("Input rent type:");
                String villaRentType = sc.nextLine();
                System.out.print("Input villa type:");
                String villaType = sc.nextLine();
                System.out.print("Input villa pool area:");
                double villaPoolArea = Double.parseDouble(sc.nextLine());
                System.out.print("Input villa number floor:");
                int villaNumberFloor = Integer.parseInt(sc.nextLine());
                Villa newVilla = new Villa(villaIdService,villaServiceName, villaUsableArea, villaPrice, villaMaximumPerson,
                        villaRentType, villaType, villaPoolArea, villaNumberFloor);
                facilityServiceList.put(newVilla, 0);
                System.out.println("Add a new villa successfully!!!");
                break;
            case 2:
                System.out.print("Input id service:");
                String houseIdService = sc.nextLine();
                System.out.print("Input service name:");
                String houseServiceName = sc.nextLine();
                System.out.print("Input usable area:");
                double houseUsableArea = Double.parseDouble(sc.nextLine());
                System.out.print("Input price:");
                double housePrice = Double.parseDouble(sc.nextLine());
                System.out.print("Input maximum person:");
                int houseMaximumPerson = Integer.parseInt(sc.nextLine());
                System.out.print("Input rent type:");
                String houseRentType = sc.nextLine();
                System.out.print("Input house type:");
                String houseType = sc.nextLine();
                System.out.print("Input house number floor:");
                int houseNumberFloor = Integer.parseInt(sc.nextLine());
                House newHouse = new House(houseIdService,houseServiceName, houseUsableArea, housePrice, houseMaximumPerson,
                        houseRentType, houseType, houseNumberFloor);
                facilityServiceList.put(newHouse, 0);
                System.out.println("Add a new house successfully!!!");
                break;
            case 3:
                System.out.print("Input id service:");
                String roomIdService = sc.nextLine();
                System.out.print("Input service name:");
                String roomServiceName = sc.nextLine();
                System.out.print("Input usable area:");
                double roomUsableArea = Double.parseDouble(sc.nextLine());
                System.out.print("Input price:");
                double roomPrice = Double.parseDouble(sc.nextLine());
                System.out.print("Input maximum person:");
                int roomMaximumPerson = Integer.parseInt(sc.nextLine());
                System.out.print("Input rent type:");
                String roomRentType = sc.nextLine();
                System.out.print("Input room type:");
                String roomFreeService = sc.nextLine();
                Room newRoom = new Room(roomIdService,roomServiceName, roomUsableArea, roomPrice, roomMaximumPerson,
                        roomRentType, roomFreeService);
                facilityServiceList.put(newRoom, 0);
                System.out.println("Add a new room successfully!!!");
                break;
            case 4:
                returnMainMenu();
                break;
            default:
                System.out.println("Choice again: ");
        }

    }

    @Override
    public void displayFacilityMaintenance() {
        for (Map.Entry<Facility, Integer> entry : facilityServiceList.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
            }
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

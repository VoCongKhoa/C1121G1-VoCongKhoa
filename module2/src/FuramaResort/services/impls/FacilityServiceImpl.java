package FuramaResort.services.impls;

import FuramaResort.models.*;
import FuramaResort.services.FacilityService;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    Scanner sc = new Scanner(System.in);
    private static Map<Facility, Integer> facilityServiceList = new LinkedHashMap<>();

    static {
        Villa villa = new Villa("bookingVilla", 100, 10, 10,
                "day", "big", 25, 3);
        House house = new House("bookingVilla", 100, 10, 10,
                "day", "medium", 2);
        Room room = new Room("bookingVilla", 100, 10, 10,
                "day", "free");

        facilityServiceList.put(villa, 2);
        facilityServiceList.put(house, 4);
        facilityServiceList.put(room, 6);
    }

    @Override
    public void displayFacility() {
        System.out.println(facilityServiceList.keySet());
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
                Villa newVilla = new Villa(villaServiceName, villaUsableArea, villaPrice, villaMaximumPerson,
                        villaRentType, villaType, villaPoolArea, villaNumberFloor);
                facilityServiceList.put(newVilla, 0);
                System.out.println("Add a new villa successfully!!!");
                break;
            case 2:
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
                House newHouse = new House(houseServiceName, houseUsableArea, housePrice, houseMaximumPerson,
                        houseRentType, houseType, houseNumberFloor);
                facilityServiceList.put(newHouse, 0);
                System.out.println("Add a new house successfully!!!");
                break;
            case 3:
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
                Room newRoom = new Room(roomServiceName, roomUsableArea, roomPrice, roomMaximumPerson,
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
        Collection<Integer> valueList = facilityServiceList.values();
        Set<Facility> keyList = facilityServiceList.keySet();
        Facility maintenanceFacility;
        for (int i = 0; i < facilityServiceList.size(); i++) {
            System.out.println((int) valueList.toArray()[i]);
            if ((int) valueList.toArray()[i] >= 5) {
                maintenanceFacility= (Facility) keyList.toArray()[i];
                System.out.println(maintenanceFacility.toString());
                break;
            }
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

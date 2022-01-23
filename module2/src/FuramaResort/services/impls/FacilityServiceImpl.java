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
    }

    @Override
    public void addFacility() {
        Scanner sc = new Scanner(System.in);
        boolean flagAddFacility = false;
        do {
            System.out.println("1.\tAdd new Villa\n" +
                    "2.\tAdd new House\n" +
                    "3.\tAdd new Room\n" +
                    "4.\tBack to facility management menu\n");
            System.out.println("Choose facility you wanna add:");
            int addFacilityChoice = Integer.parseInt(sc.nextLine());
            switch (addFacilityChoice) {
                case 1:
                    Villa villa = new Villa();
                    choiceInputFacility(villa);
                    break;
                case 2:
                    House house = new House();
                    choiceInputFacility(house);
                    break;
                case 3:
                    Room room = new Room();
                    choiceInputFacility(room);
                    break;
                case 4:
                    flagAddFacility = true;
                    returnMainMenu();
                    break;
                default:
                    System.out.println("Choice again: ");
            }
        }while (!flagAddFacility);
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

    public void choiceInputFacility(Facility facility){
        System.out.print("Input facility id service:");
        String idService = sc.nextLine();
        System.out.print("Input facility service name:");
        String serviceName = sc.nextLine();
        System.out.print("Input facility usable area:");
        double usableArea = Double.parseDouble(sc.nextLine());
        System.out.print("Input facility price:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Input facility maximum person:");
        int maximumPerson = Integer.parseInt(sc.nextLine());
        System.out.print("Input facility rent type:");
        String rentType = sc.nextLine();
        if (facility instanceof Villa) {
            System.out.print("Input villa type:");
            String villaType = sc.nextLine();
            System.out.print("Input villa pool area:");
            double villaPoolArea = Double.parseDouble(sc.nextLine());
            System.out.print("Input villa number floor:");
            int villaNumberFloor = Integer.parseInt(sc.nextLine());
            Villa newVilla = new Villa(idService,serviceName, usableArea, price, maximumPerson,
                    rentType, villaType, villaPoolArea, villaNumberFloor);
            facilityServiceList.put(newVilla, 0);
            System.out.println("Add a new villa successfully!!!");
        }else if (facility instanceof House){
            System.out.print("Input house type:");
            String houseType = sc.nextLine();
            System.out.print("Input house number floor:");
            int houseNumberFloor = Integer.parseInt(sc.nextLine());
            House newHouse = new House(idService,serviceName, usableArea, price, maximumPerson,
                    rentType, houseType, houseNumberFloor);
            facilityServiceList.put(newHouse, 0);
            System.out.println("Add a new house successfully!!!");
        } else if (facility instanceof Room){
            System.out.print("Input room free service:");
            String roomFreeService = sc.nextLine();
            Room newRoom = new Room(idService,serviceName, usableArea, price, maximumPerson,
                    rentType, roomFreeService);
            facilityServiceList.put(newRoom, 0);
            System.out.println("Add a new room successfully!!!");
        }
    }
}

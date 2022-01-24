package FuramaResort.services.impls;

import FuramaResort.models.*;
import FuramaResort.services.FacilityService;
import FuramaResort.utils.Validation;

import java.io.IOException;
import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    static Map<Facility, Integer> facilityServiceList = new LinkedHashMap<>();
    Validation validation = new Validation();

    static {
        Villa villa = new Villa("VL001", "bookingVilla", 100, 10, 10,
                "day", "big", 25, 3);
        House house = new House("HS001", "bookingHouse", 100, 10, 10,
                "day", "medium", 2);
        Room room = new Room("RO001", "bookingRoom", 100, 10, 10,
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
            System.out.print("Choose facility you wanna add: ");
            int addFacilityChoice = Integer.parseInt(sc.nextLine());
            switch (addFacilityChoice) {
                case 1:
                    Villa villa = new Villa();
                    choiceInputFacility(villa, 1);
                    break;
                case 2:
                    House house = new House();
                    choiceInputFacility(house, 2);
                    break;
                case 3:
                    Room room = new Room();
                    choiceInputFacility(room, 3);
                    break;
                case 4:
                    flagAddFacility = true;
                    returnMainMenu();
                    break;
                default:
                    System.out.print("Choice again: ");
            }
        } while (!flagAddFacility);
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

    public void choiceInputFacility(Facility facility, int choiceNumber) {
        System.out.print("Input facility id service: ");
        String idService = "";
        if (choiceNumber == 1) {
            while (!validation.validateVillaIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        } else if (choiceNumber == 2) {
            while (!validation.validateHouseIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        } else if (choiceNumber == 3) {
            while (!validation.validateRoomIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Input facility service name: ");
        String serviceName = "";
        while (!validation.validateServiceName(serviceName = sc.nextLine())) {
            System.out.println("Wrong format!!! Input again!");
        }

        System.out.print("Input facility usable area: ");
        double usableArea;
        while (true) {
            try {
                usableArea = Double.parseDouble(sc.nextLine());
                if (usableArea > 30) {
                    break;
                } else {
                    System.out.println("Facility usable area have to more than 30m2!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.print("Input facility price: ");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price > 0) {
                    break;
                } else {
                    System.out.println("Facility price have to be a positive number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.print("Input facility maximum person: ");
        int maximumPerson;
        while (true) {
            try {
                maximumPerson = Integer.parseInt(sc.nextLine());
                if (maximumPerson > 0 && maximumPerson < 20) {
                    break;
                } else {
                    System.out.println("Facility maximum person have to more than 0 ang less than 20!!! " +
                            "Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        System.out.print("Input facility rent type: ");
        String rentType = "";
        while (!validation.validateRentType(rentType = sc.nextLine())) {
            System.out.println("Wrong format!!! Input again!");
        }

        if (facility instanceof Villa) {
            System.out.print("Input villa type: ");
            String villaType = "";
            while (!validation.validateVillaType(villaType = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }

            System.out.print("Input villa pool area: ");
            double villaPoolArea;
            while (true) {
                try {
                    villaPoolArea = Double.parseDouble(sc.nextLine());
                    if (villaPoolArea > 30) {
                        break;
                    } else {
                        System.out.println("Villa pool area have to more than 30m2!!! Input again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number!!! Input again!");
                } catch (Exception e) {
                    System.out.println("Wrong format !!! Input again!");
                }
            }

            System.out.print("Input villa number floor: ");
            int villaNumberFloor;
            while (true) {
                try {
                    villaNumberFloor = Integer.parseInt(sc.nextLine());
                    if (villaNumberFloor > 0) {
                        break;
                    } else {
                        System.out.println("Villa number floor have to be a positive number!!! Input again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number!!! Input again!");
                } catch (Exception e) {
                    System.out.println("Wrong format !!! Input again!");
                }
            }

            Villa newVilla = new Villa(idService, serviceName, usableArea, price, maximumPerson,
                    rentType, villaType, villaPoolArea, villaNumberFloor);
            facilityServiceList.put(newVilla, 0);
            System.out.println("Add a new villa successfully!!!");
        } else if (facility instanceof House) {
            System.out.print("Input house type: ");
            String houseType = "";
            while (!validation.validateHouseType(houseType = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }

            System.out.print("Input house number floor: ");
            int houseNumberFloor;
            while (true) {
                try {
                    houseNumberFloor = Integer.parseInt(sc.nextLine());
                    if (houseNumberFloor > 0) {
                        break;
                    } else {
                        System.out.println("House number floor have to be a positive number!!! Input again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number!!! Input again!");
                } catch (Exception e) {
                    System.out.println("Wrong format !!! Input again!");
                }
            }

            House newHouse = new House(idService, serviceName, usableArea, price, maximumPerson,
                    rentType, houseType, houseNumberFloor);
            facilityServiceList.put(newHouse, 0);
            System.out.println("Add a new house successfully!!!");
        } else if (facility instanceof Room) {
            System.out.print("Input free service of room: ");
            String roomFreeService;
            while (true) {
                    if (!(roomFreeService = sc.nextLine()).trim().equals("")) {
                        break;
                    } else {
                        System.out.println("free service of room can't be empty!!! Input again!");
                    }
            }

            Room newRoom = new Room(idService, serviceName, usableArea, price, maximumPerson,
                    rentType, roomFreeService);
            facilityServiceList.put(newRoom, 0);
            System.out.println("Add a new room successfully!!!");
        }
    }
}

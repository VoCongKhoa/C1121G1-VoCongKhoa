package FuramaResort.services.impls;

import FuramaResort.common.ReadAndWriteFile;
import FuramaResort.models.*;
import FuramaResort.services.FacilityService;
import FuramaResort.utils.Validation;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    static Map<Facility, Integer> facilityServiceList = new LinkedHashMap<>();
    Validation validation = new Validation();
    static final String FACILITY_PATH_FILE = "src/FuramaResort/data/facility.csv";
    static final String VILLA_PATH_FILE = "src/FuramaResort/data/villa.csv";
    static final String HOUSE_PATH_FILE = "src/FuramaResort/data/house.csv";
    static final String ROOM_PATH_FILE = "src/FuramaResort/data/room.csv";

    public static Map<Facility, Integer> readCSVFileTofacilityServiceList(String pathFile) {
        Map<Facility, Integer> facilityServiceListFromCSV = new LinkedHashMap<>();
        List<String> lineList = ReadAndWriteFile.readCSVFileToStringList(pathFile);
        String[] lineSplitList;
        Villa villa;
        House house;
        Room room;
        for (String line : lineList) {
            lineSplitList = line.split(",");
            if (lineSplitList[0].contains("SVVL")) {
                villa = new Villa(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                facilityServiceListFromCSV.put(villa, Integer.parseInt(lineSplitList[9]));
            } else if (line.contains("SVHO")) {
                house = new House(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Integer.parseInt(lineSplitList[7]));
                facilityServiceListFromCSV.put(house, Integer.parseInt(lineSplitList[8]));
            } else if (line.contains("SVRO")) {
                room = new Room(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6]);
                facilityServiceListFromCSV.put(room, Integer.parseInt(lineSplitList[7]));
            }
        }
        return facilityServiceListFromCSV;
    }

    public static void writeFacilityListIntoCSVFile(String pathFile, Map<Facility, Integer> facilityMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
        }
        ReadAndWriteFile.writeStringListIntoCSVFile(pathFile, stringList, append);
    }

    @Override
    public void displayFacility() {
        Map<Facility, Integer> facilityServiceList = new LinkedHashMap<>();
        Villa villa;
        House house;
        Room room;
        List<String> lineList = ReadAndWriteFile.readCSVFileToStringList(FACILITY_PATH_FILE);
        String[] lineSplitList;
        for (String line : lineList) {
            lineSplitList = line.split(",");
            if (lineSplitList[0].contains("SVVL")) {
                villa = new Villa(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                facilityServiceList.put(villa, Integer.parseInt(lineSplitList[9]));
            } else if (line.contains("SVHO")) {
                house = new House(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Integer.parseInt(lineSplitList[7]));
                facilityServiceList.put(house, Integer.parseInt(lineSplitList[8]));
            } else if (line.contains("SVRO")) {
                room = new Room(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6]);
                facilityServiceList.put(room, Integer.parseInt(lineSplitList[7]));
            }
        }
        for (Map.Entry<Facility, Integer> entry : facilityServiceList.entrySet()) {
            System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
        }
    }

    @Override
    public void addFacility() {
        Scanner sc = new Scanner(System.in);
        boolean flagAddFacility = false;
        do {
            try {
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
                        System.out.println("Wrong number!!! Choice again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format!!! Input again!");
            }

        } while (!flagAddFacility);
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> facilityMaintenanceList = new LinkedHashMap<>();
        Villa villa;
        House house;
        Room room;
        List<String> lineList = ReadAndWriteFile.readCSVFileToStringList(FACILITY_PATH_FILE);
        String[] lineSplitList;
        for (String line : lineList) {
            lineSplitList = line.split(",");
            if (Integer.parseInt(lineSplitList[lineSplitList.length - 1]) >= 5) {
                if (lineSplitList[0].contains("SVVL")) {
                    villa = new Villa(lineSplitList[0], lineSplitList[1],
                            Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                            Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                            Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                    facilityMaintenanceList.put(villa, Integer.parseInt(lineSplitList[9]));
                } else if (line.contains("SVHO")) {
                    house = new House(lineSplitList[0], lineSplitList[1],
                            Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                            Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                            Integer.parseInt(lineSplitList[7]));
                    facilityMaintenanceList.put(house, Integer.parseInt(lineSplitList[8]));
                } else if (line.contains("SVRO")) {
                    room = new Room(lineSplitList[0], lineSplitList[1],
                            Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                            Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6]);
                    facilityMaintenanceList.put(room, Integer.parseInt(lineSplitList[7]));
                }
            }
        }
        for (Map.Entry<Facility, Integer> entry : facilityMaintenanceList.entrySet()) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
            }
        }
//        System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
//        for (Map.Entry<Facility, Integer> entry : facilityServiceList.entrySet()) {
//            if (entry.getValue() >= 5) {
//                System.out.println(entry.getKey() + ", bookedTimes = " + entry.getValue());
//            }
//        }
    }

    @Override
    public void returnMainMenu() {
    }

    public void choiceInputFacility(Facility facility, int choiceNumber) {
        String idService = "";
        if (choiceNumber == 1) {
            System.out.print("Input facility id service (Format: SVVL-XXXX, Ex: SVVL-1234, SVVL-0123,...): ");
            while (!validation.validateVillaIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        } else if (choiceNumber == 2) {
            System.out.print("Input facility id service (Format: SVHO-XXXX, Ex: SVHO-1234, SVHO-0123,...): ");
            while (!validation.validateHouseIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        } else if (choiceNumber == 3) {
            System.out.print("Input facility id service (Format: SVRO-XXXX, Ex: SVRO-1234, SVRO-0123,...): ");
            while (!validation.validateRoomIDService(idService = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Input facility service name (Ex: Villa service,...): ");
        String serviceName = "";
        while (!validation.validateServiceName(serviceName = sc.nextLine())) {
            System.out.println("Wrong format!!! Input again!");
        }

        System.out.print("Input facility usable area (More than 30): ");
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

        System.out.print("Input facility price (Ex:5000000,...): ");
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

        System.out.print("Input facility maximum person (Ex:19,...): ");
        int maximumPerson;
        while (true) {
            try {
                maximumPerson = Integer.parseInt(sc.nextLine().trim());
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

        System.out.print("Input facility rent type (Ex: Day, Month,...): ");
        String rentType;
        while (!validation.validateRentType(rentType = sc.nextLine())) {
            System.out.println("Wrong format!!! Input again!");
        }

        if (facility instanceof Villa) {
            System.out.print("Input villa type (Only Luxury or Unique): ");
            String villaType;
            while (!validation.validateVillaType(villaType = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }

            System.out.print("Input villa pool area (More than 30): ");
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

            System.out.print("Input villa number floor (Ex:5,...): ");
            int villaNumberFloor;
            while (true) {
                try {
                    villaNumberFloor = Integer.parseInt(sc.nextLine().trim());
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

            Villa newVilla = new Villa(idService.trim(), serviceName.trim(), usableArea, price, maximumPerson,
                    rentType.trim(), villaType.trim(), villaPoolArea, villaNumberFloor);
            Map<Facility, Integer> newFacilityList = new LinkedHashMap<>();
            Map<Villa, Integer> newVillaList = new LinkedHashMap<>();
            newFacilityList.put(newVilla, 0);
            List<String> stringList = new ArrayList<>();
            for (Map.Entry<Facility, Integer> entry : newFacilityList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newVillaList.put(newVilla, 0);
            for (Map.Entry<Villa, Integer> entry : newVillaList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(VILLA_PATH_FILE, stringList, true);
            System.out.println("Add a new villa successfully!!!");
        } else if (facility instanceof House) {
            System.out.print("Input house type (Only Superior or Standard): ");
            String houseType;
            while (!validation.validateHouseType(houseType = sc.nextLine())) {
                System.out.println("Wrong format!!! Input again!");
            }

            System.out.print("Input house number floor (Ex:5,...): ");
            int houseNumberFloor;
            while (true) {
                try {
                    houseNumberFloor = Integer.parseInt(sc.nextLine().trim());
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

            House newHouse = new House(idService.trim(), serviceName.trim(), usableArea, price, maximumPerson,
                    rentType.trim(), houseType.trim(), houseNumberFloor);
            Map<Facility, Integer> newFacilityList = new LinkedHashMap<>();
            Map<House, Integer> newHouseList = new LinkedHashMap<>();
            newFacilityList.put(newHouse, 0);
            List<String> stringList = new ArrayList<>();
            for (Map.Entry<Facility, Integer> entry : newFacilityList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newHouseList.put(newHouse, 0);
            for (Map.Entry<House, Integer> entry : newHouseList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(HOUSE_PATH_FILE, stringList, true);

            System.out.println("Add a new house successfully!!!");
        } else if (facility instanceof Room) {
            System.out.print("Input free service of room (Ex: Beverage voucher, Spa voucher,...): ");
            String roomFreeService;
            while (true) {
                if (!(roomFreeService = sc.nextLine()).trim().equals("")) {
                    break;
                } else {
                    System.out.println("Free service of room can't be empty!!! Input again!");
                }
            }

            Room newRoom = new Room(idService.trim(), serviceName.trim(), usableArea, price, maximumPerson,
                    rentType.trim(), roomFreeService.trim());
            Map<Facility, Integer> newFacilityList = new LinkedHashMap<>();
            Map<Room, Integer> newRoomList = new LinkedHashMap<>();
            newFacilityList.put(newRoom, 0);
            List<String> stringList = new ArrayList<>();
            for (Map.Entry<Facility, Integer> entry : newFacilityList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newRoomList.put(newRoom, 0);
            for (Map.Entry<Room, Integer> entry : newRoomList.entrySet()) {
                stringList.add(entry.getKey().toStringToCSVFile() + "," + entry.getValue());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(ROOM_PATH_FILE, stringList, true);

            System.out.println("Add a new room successfully!!!");
        }
    }
}

package FuramaResort.services.impls;

import FuramaResort.common.ReadAndWriteFile;
import FuramaResort.models.*;
import FuramaResort.services.FacilityService;
import FuramaResort.utils.Validation;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    Scanner sc = new Scanner(System.in);
    static List<Facility> facilityServiceList = new ArrayList<>();
    Validation validation = new Validation();
    static final String FACILITY_PATH_FILE = "src/FuramaResort/data/facility.csv";
    static final String VILLA_PATH_FILE = "src/FuramaResort/data/villa.csv";
    static final String HOUSE_PATH_FILE = "src/FuramaResort/data/house.csv";
    static final String ROOM_PATH_FILE = "src/FuramaResort/data/room.csv";

    @Override
    public void displayFacility() {
        List<Facility> facilityServiceList = new ArrayList<>();
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
                        Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8])
                        , Integer.parseInt(lineSplitList[9]));
                facilityServiceList.add(villa);
            } else if (line.contains("SVHO")) {
                house = new House(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Integer.parseInt(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                facilityServiceList.add(house);
            } else if (line.contains("SVRO")) {
                room = new Room(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6]
                        , Integer.parseInt(lineSplitList[7]));
                facilityServiceList.add(room);
            }
        }
        for (Facility facility : facilityServiceList) {
            System.out.println(facility.toString());
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
        List<Facility> facilityMaintenanceList = new ArrayList<>();
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
                            Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8])
                            , Integer.parseInt(lineSplitList[9]));
                    facilityMaintenanceList.add(villa);
                } else if (line.contains("SVHO")) {
                    house = new House(lineSplitList[0], lineSplitList[1],
                            Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                            Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                            Integer.parseInt(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                    facilityMaintenanceList.add(house);
                } else if (line.contains("SVRO")) {
                    room = new Room(lineSplitList[0], lineSplitList[1],
                            Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                            Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6]
                            , Integer.parseInt(lineSplitList[7]));
                    facilityMaintenanceList.add(room);
                }
            }
        }
        for (Facility facility : facilityMaintenanceList) {
            if (facility.getBookingCount() >= 5) {
                System.out.println(facility.toString());
            }
        }
    }

    @Override
    public void returnMainMenu() {
    }

    public void choiceInputFacility(Facility facility, int choiceNumber) {
        List<Facility> facilityServiceList = readCSVFileTofacilityServiceList(FACILITY_PATH_FILE);
        String idService = null;

        //Check IdService đã tồn tại hay chưa
        //Check format serviceID
        boolean flagExist = false;
        do {
            if (choiceNumber == 1) {
                System.out.print("Input villa id service (Format: SVVL-XXXX, Ex: SVVL-1234, SVVL-0123,...): ");
                flagExist = validation.validateVillaIDService(idService = sc.nextLine());
            } else if (choiceNumber == 2) {
                System.out.print("Input house id service (Format: SVHO-XXXX, Ex: SVHO-1234, SVHO-0123,...): ");
                flagExist = validation.validateHouseIDService(idService = sc.nextLine());
            } else if (choiceNumber == 3) {
                System.out.print("Input room id service (Format: SVRO-XXXX, Ex: SVRO-1234, SVRO-0123,...): ");
                flagExist = validation.validateRoomIDService(idService = sc.nextLine());
            }
            if (!flagExist) {
                System.out.println("Wrong format!!! Input again!");
            }
            if (flagExist) {
                for (Facility facilityCheckID : facilityServiceList) {
                    if (facilityCheckID.getIdService().equals(idService)) {
                        flagExist = false;
                        System.out.println("Id Service already existed!!!");
                        break;
                    }
                }
            }
        } while (!flagExist);

        System.out.print("Input facility service name (Ex: Villa service,...): ");
        String serviceName;
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
                    rentType.trim(), villaType.trim(), villaPoolArea, villaNumberFloor, 0);
            List<Facility> newFacilityList = new ArrayList<>();
            List<Villa> newVillaList = new ArrayList<>();
            newFacilityList.add(newVilla);
            List<String> stringList = new ArrayList<>();
            for (Facility facilityNew : newFacilityList) {
                stringList.add(facilityNew.toStringToCSVFile());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newVillaList.add(newVilla);
            for (Villa villa : newVillaList) {
                stringList.add(villa.toStringToCSVFile());
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
                    rentType.trim(), houseType.trim(), houseNumberFloor, 0);
            List<Facility> newFacilityList = new ArrayList<>();
            List<House> newHouseList = new ArrayList<>();
            newFacilityList.add(newHouse);
            List<String> stringList = new ArrayList<>();
            for (Facility facilityNew : newFacilityList) {
                stringList.add(facilityNew.toStringToCSVFile());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newHouseList.add(newHouse);
            for (House house : newHouseList) {
                stringList.add(house.toStringToCSVFile());
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
                    rentType.trim(), roomFreeService.trim(), 0);
            List<Facility> newFacilityList = new ArrayList<>();
            List<Room> newRoomList = new ArrayList<>();
            newFacilityList.add(newRoom);
            List<String> stringList = new ArrayList<>();
            for (Facility facilityNew : newFacilityList) {
                stringList.add(facilityNew.toStringToCSVFile());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(FACILITY_PATH_FILE, stringList, true);
            stringList.clear();
            newRoomList.add(newRoom);
            for (Room room : newRoomList) {
                stringList.add(room.toStringToCSVFile());
            }
            ReadAndWriteFile.writeStringListIntoCSVFile(ROOM_PATH_FILE, stringList, true);
            System.out.println("Add a new room successfully!!!");
        }
    }

    public static List<Facility> readCSVFileTofacilityServiceList(String pathFile) {
        List<Facility> facilityServiceListFromCSV = new ArrayList<>();
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
                        Double.parseDouble(lineSplitList[7]), Integer.parseInt(lineSplitList[8]),
                        Integer.parseInt(lineSplitList[9]));
                facilityServiceListFromCSV.add(villa);
            } else if (line.contains("SVHO")) {
                house = new House(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Integer.parseInt(lineSplitList[7]), Integer.parseInt(lineSplitList[8]));
                facilityServiceListFromCSV.add(house);
            } else if (line.contains("SVRO")) {
                room = new Room(lineSplitList[0], lineSplitList[1],
                        Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]),
                        Integer.parseInt(lineSplitList[4]), lineSplitList[5], lineSplitList[6],
                        Integer.parseInt(lineSplitList[7]));
                facilityServiceListFromCSV.add(room);
            }
        }
        return facilityServiceListFromCSV;
    }

    public static void writeFacilityListIntoCSVFile(String pathFile, List<Facility> facilityList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Facility facility : facilityList) {
            stringList.add(facility.toStringToCSVFile());
        }
        ReadAndWriteFile.writeStringListIntoCSVFile(pathFile, stringList, append);
    }
}

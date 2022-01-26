package FuramaResort.services.impls;

import FuramaResort.common.ReadAndWriteFile;
import FuramaResort.models.*;
import FuramaResort.services.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookingTreeSet = new TreeSet<>(new SortByStartDate());
    static Queue<Booking> bookingQueue = new ArrayDeque<>();//Booking for add contract
    static List<Contract> contractList = new ArrayList<>();
    static Set<Facility> facilitySet;
    static final String BOOKING_PATH_FILE = "src/FuramaResort/data/booking.csv";
    static final String BOOKING_FOR_CONTRACT_PATH_FILE = "src/FuramaResort/data/bookingListForContract.csv";
    static final String CONTRACT_PATH_FILE = "src/FuramaResort/data/contract.csv";

//    static {
////        facilitySet = FacilityServiceImpl.facilityServiceList.keySet();
////        Facility facility1 = (Facility) facilitySet.toArray()[0];
////        Facility facility2 = (Facility) facilitySet.toArray()[1];
////        Facility facility3 = (Facility) facilitySet.toArray()[2];
//
////        Booking booking1 = new Booking("01/01/2020", "07/01/2020",
////                CustomerServiceImpl.customerList.get(0), facility1);
////        Booking booking2 = new Booking("04/01/2019", "07/01/2019",
////                CustomerServiceImpl.customerList.get(1), facility2);
////        Booking booking3 = new Booking("01/01/2022", "06/01/2022",
////                CustomerServiceImpl.customerList.get(2), facility3);
////        Booking booking4 = new Booking("03/01/2022", "07/01/2022",
////                CustomerServiceImpl.customerList.get(0), facility1);
////        Booking booking5 = new Booking("01/01/2020", "08/01/2020",
////                CustomerServiceImpl.customerList.get(1), facility2);
//
////        bookingTreeSet.add(booking1);
////        bookingTreeSet.add(booking2);
////        bookingTreeSet.add(booking3);
////        bookingTreeSet.add(booking4);
////        bookingTreeSet.add(booking5);
//        for (Booking booking : bookingTreeSet) {
//            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
//                bookingQueue.add(booking);
//            }
//        }
//    }

    @Override
    public void addBooking() {
        Scanner sc = new Scanner(System.in);
        Customer bookingCustomer;
        while (true) {
            try {
                System.out.println("Customers List:");
                CustomerServiceImpl.customerList = CustomerServiceImpl.readCSVFileToCustomerList(CustomerServiceImpl.CUSTOMER_PATH_FILE);
                for (int i = 0; i < CustomerServiceImpl.customerList.size(); i++) {
                    System.out.println(i + 1 + "." + CustomerServiceImpl.customerList.get(i));
                }
                System.out.print("Choice customer id: ");
                int customerBookingChoice = Integer.parseInt(sc.nextLine());
                if (customerBookingChoice > 0 && customerBookingChoice < CustomerServiceImpl.customerList.size() + 1) {
                    bookingCustomer = CustomerServiceImpl.customerList.get(customerBookingChoice);
                    break;
                } else {
                    System.out.println("Wrong number!!! Input again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        Facility facility = null;
        while (true) {
            boolean flag = false;
            try {
                System.out.println("Service List:");
                FacilityServiceImpl.facilityServiceList = FacilityServiceImpl.readCSVFileTofacilityServiceList(FacilityServiceImpl.FACILITY_PATH_FILE);
                for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
                    System.out.println(entry);
                }
                System.out.print("Choice id service: ");
                String inputIdService = sc.nextLine();
                for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
                    if (entry.getKey().getIdService().equals(inputIdService)) {
                        facility = entry.getKey();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Not found !!! Input again!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format !!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }
        System.out.println("Input start date:");
        String startDate = sc.nextLine();
        System.out.println("Input end date:");
        String endDate = sc.nextLine();
        List<Booking> addBookingList = new ArrayList<>();
        Booking newBooking = new Booking(startDate, endDate, bookingCustomer, facility);
        addBookingList.add(newBooking);
        writeBookingListIntoCSVFile(BOOKING_PATH_FILE, addBookingList, true);
        System.out.println("Add booking successfully!!!");
    }

    @Override
    public void displayBooking() {
//        List<String> lineString = ReadAndWriteFile.readCSVFileToStringList(BOOKING_PATH_FILE);
//        String[] lineSplitList;
//        Customer customerCSV = null;
//        Facility facilityCSV = null;
//        Booking bookingCSV;
//        CustomerServiceImpl.customerList = CustomerServiceImpl.readCSVFileToCustomerList(CustomerServiceImpl.CUSTOMER_PATH_FILE);
//        FacilityServiceImpl.facilityServiceList = FacilityServiceImpl.readCSVFileTofacilityServiceList(FacilityServiceImpl.FACILITY_PATH_FILE);
//
//        Booking.setNumberOfBooking(0);
//        for (String s : lineString) {
//            lineSplitList = s.split(",");
//            for (Customer customer : CustomerServiceImpl.customerList) {
//                if (Integer.parseInt(lineSplitList[3]) == customer.getCustomerId()) {
//                    customerCSV = customer;
//                }
//            }
//            for (Facility facility : FacilityServiceImpl.facilityServiceList.keySet()) {
//                if (Objects.equals(lineSplitList[4], facility.getServiceName())) {
//                    if (Objects.equals(lineSplitList[5], facility.getRentType())) {
//                        facilityCSV = facility;
//                    }
//                }
//            }
//            bookingCSV = new Booking(lineSplitList[1], lineSplitList[2], customerCSV, facilityCSV);
//            bookingTreeSet.add(bookingCSV);
//        }
        bookingTreeSet = readCSVFileToBookingList(BOOKING_PATH_FILE);
        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }

        //Ghi đè lại danh sách booking có thể làm hợp đồng để chạy phương thức createNewContract()
        List<Booking> addToBookingForContractFile = new ArrayList<>();
        for (Booking booking : bookingTreeSet) {
            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
                addToBookingForContractFile.add(booking);
            }
        }
        writeBookingListIntoCSVFile(BOOKING_FOR_CONTRACT_PATH_FILE, addToBookingForContractFile, false);
    }

    @Override
    public void createNewContract() {
        Scanner sc = new Scanner(System.in);
        Set<Booking> bookingForContractTreeSet = readCSVFileToBookingList(BOOKING_FOR_CONTRACT_PATH_FILE);
        bookingQueue.addAll(bookingForContractTreeSet);
        Booking newContractBooking;
        int newContractBookingNumber;
        boolean flag = false;
        boundaryLoop:
        while (true) {
            try {
                System.out.println("Booking list:");
                for (Booking booking : bookingQueue) {
                    System.out.println(booking);
                }
                System.out.println("Choice a booking number (earliest startDate first):");
                int choiceBooking = Integer.parseInt(sc.nextLine());
                for (Booking booking : bookingQueue) {
                    if (choiceBooking == booking.getBookingNumber()) {
                        flag = true;
                        newContractBooking = booking;
                        newContractBookingNumber = booking.getBookingNumber();
                        bookingQueue.remove(); //???? vì sao remove không được với LinkedList và PriorityQueue???
                        break boundaryLoop;
                    }
                }
                if (!flag) {
                    System.out.println("Not found!!! Choice again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        double contractDeposit;
        while (true) {
            try {
                System.out.print("Input deposit of customer for new contract: ");
                contractDeposit = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        double contractSum;
        while (true) {
            try {
                System.out.print("Input total charge of new contract: ");
                contractSum = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        Contract newContract = new Contract(contractDeposit, contractSum, newContractBooking);
        List<Contract> addContractList = new ArrayList<>();
        writeContractListIntoCSVFile(CONTRACT_PATH_FILE,addContractList,true);
//        contractList.add(newContract);
        System.out.println("Create new contract successfully for booking number " + newContractBookingNumber);
    }

    @Override
    public void displayContract() {
        contractList = readCSVFileToContractList(CONTRACT_PATH_FILE);
        if (contractList.isEmpty()) {
            System.out.println("There're no contracts!!!");
        } else {
            for (Contract contract : contractList) {
                System.out.println(contract);
            }
        }
    }

    @Override
    public void editContract() {
        Scanner sc = new Scanner(System.in);
        contractList = readCSVFileToContractList(CONTRACT_PATH_FILE);
        if (contractList.isEmpty()) {
            System.out.println("There're no contracts!!!");
        } else {
            boolean flag = false;
            boudaryLoop:
            do {
                try {
                    System.out.println("Contract list:");
                    for (Contract contract : contractList) {
                        System.out.println(contract);
                    }
                    System.out.println("Input the number of contract you wanna edit:");
                    int editNumberContract = Integer.parseInt(sc.nextLine());
                    for (Contract contract : contractList) {
                        if (contract.getContractNumber() == editNumberContract) {
                            flag = true;
                            do {
                                try {
                                    System.out.println("Edit contract list:");
                                    System.out.println("1. Edit contract deposit");
                                    System.out.println("2. Edit total charge of contract");
                                    System.out.print("Your choice: ");
                                    int editChoice = Integer.parseInt(sc.nextLine());
                                    if (editChoice == 1) {
                                        while (true) {
                                            try {
                                                System.out.print("Input new deposit of contract: ");
                                                contract.setContractDeposit(Double.parseDouble(sc.nextLine()));
                                                writeContractListIntoCSVFile(CONTRACT_PATH_FILE,contractList,false);
                                                System.out.println("Edit deposit of contract successfully!");
                                                break boudaryLoop;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            } catch (Exception e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            }
                                        }
                                    } else if (editChoice == 2) {
                                        while (true) {
                                            try {
                                                System.out.print("Input new total charge of contract: ");
                                                contract.setContractDeposit(Double.parseDouble(sc.nextLine()));
                                                writeContractListIntoCSVFile(CONTRACT_PATH_FILE,contractList,false);
                                                System.out.println("Edit total charge of contract successfully!");
                                                break boudaryLoop;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            } catch (Exception e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            }
                                        }
                                    } else {
                                        System.out.println("Wrong number!!! Input again!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Wrong format !!! Input again!");
                                } catch (Exception e) {
                                    System.out.println("Wrong format !!! Input again!");
                                }
                            } while (true);
                        }
                    }
                    if (!flag) {
                        System.out.println("Not found");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format !!! Input again!"); // " " và "" là NumberFormatException
                } catch (Exception e) {
                    System.out.println("Wrong format !!! Input again!");
                }
            } while (true);
        }
    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }

    public static Set<Booking> readCSVFileToBookingList(String pathFile) {
        List<String> lineString = ReadAndWriteFile.readCSVFileToStringList(pathFile);
        Set<Booking> bookingTreeSetFromReadCSV = new TreeSet<>(new SortByStartDate());
        String[] lineSplitList;
        Customer customerCSV = null;
        Facility facilityCSV = null;
        Booking bookingCSV;
        CustomerServiceImpl.customerList = CustomerServiceImpl.readCSVFileToCustomerList(CustomerServiceImpl.CUSTOMER_PATH_FILE);
        FacilityServiceImpl.facilityServiceList = FacilityServiceImpl.readCSVFileTofacilityServiceList(FacilityServiceImpl.FACILITY_PATH_FILE);

        Booking.setNumberOfBooking(0);
        for (String s : lineString) {
            lineSplitList = s.split(",");
            for (Customer customer : CustomerServiceImpl.customerList) {
                if (Integer.parseInt(lineSplitList[3]) == customer.getCustomerId()) {
                    customerCSV = customer;
                }
            }
            for (Facility facility : FacilityServiceImpl.facilityServiceList.keySet()) {
                if (Objects.equals(lineSplitList[4], facility.getServiceName())) {
                    if (Objects.equals(lineSplitList[5], facility.getRentType())) {
                        facilityCSV = facility;
                    }
                }
            }
            bookingCSV = new Booking(lineSplitList[1], lineSplitList[2], customerCSV, facilityCSV);
            bookingTreeSetFromReadCSV.add(bookingCSV);
        }
        return bookingTreeSetFromReadCSV;
    }

    public static List<Contract> readCSVFileToContractList(String pathFile) {
        List<String> lineString = ReadAndWriteFile.readCSVFileToStringList(pathFile);
        List<Contract> contractTreeSetFromReadCSV = new ArrayList<>();
        String[] lineSplitList;
        Booking bookingCSV = null;
        Contract contractCSV;

        bookingTreeSet = readCSVFileToBookingList(BOOKING_PATH_FILE);

        //Ghi đè lại danh sách booking có thể làm hợp đồng để chạy phương thức createNewContract()
        List<Booking> addToBookingForContractFile = new ArrayList<>();
        for (Booking booking : bookingTreeSet) {
            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
                addToBookingForContractFile.add(booking);
            }
        }
        writeBookingListIntoCSVFile(BOOKING_FOR_CONTRACT_PATH_FILE, addToBookingForContractFile, false);

        Set<Booking> bookingForContractTreeSet = readCSVFileToBookingList(BOOKING_FOR_CONTRACT_PATH_FILE);
        bookingQueue.addAll(bookingForContractTreeSet);
        Contract.setNumberOfContract(0);
        for (String s : lineString) {
            lineSplitList = s.split(",");
            for (Booking booking : bookingQueue) {
                if (booking.getBookingNumber() == Integer.parseInt(lineSplitList[0])){
                    if (booking.getCustomer().getCustomerId() == Integer.parseInt(lineSplitList[3])){
                        bookingCSV = booking;
                    }
                }
            }
            contractCSV = new Contract(Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]), bookingCSV);
            contractTreeSetFromReadCSV.add(contractCSV);
        }
        return contractTreeSetFromReadCSV;
    }

    public static void writeBookingListIntoCSVFile(String pathFile, List<Booking> bookingList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Booking booking : bookingList) {
            stringList.add(booking.toStringToCSVFile());
        }
        ReadAndWriteFile.writeStringListIntoCSVFile(pathFile, stringList, append);
    }

    public static void writeContractListIntoCSVFile(String pathFile, List<Contract> contractList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Contract contract : contractList) {
            stringList.add(contract.toStringToCSVFile());
        }
        ReadAndWriteFile.writeStringListIntoCSVFile(pathFile, stringList, append);
    }
}

package FuramaResort.services.impls;

import FuramaResort.common.ReadAndWriteFile;
import FuramaResort.models.*;
import FuramaResort.services.BookingService;
import FuramaResort.utils.Validation;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookingTreeSet = new TreeSet<>(new SortByStartDate());
    static Queue<Booking> bookingQueue = new ArrayDeque<>();//Booking for add contract
    static List<Contract> contractList = new ArrayList<>();
    Validation validation = new Validation();

    //Lấy ngày tháng năm hiện tại
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    String year = String.valueOf(localDate.getYear());
    int month = localDate.getMonthValue();
    int day = localDate.getDayOfMonth();

    static final String BOOKING_PATH_FILE = "src/FuramaResort/data/booking.csv";
    static final String BOOKING_VILLA_AND_HOUSE_FOR_CONTRACT_PATH_FILE = "src/FuramaResort/data/bookingVillaAndHouseForContract.csv";
    static final String BOOKING_ALREADY_HAD_CONTRACT_PATH_FILE = "src/FuramaResort/data/bookingAlreadyHadContract.csv";
    static final String BOOKING_NOT_HAVE_CONTRACT_YET_PATH_FILE = "src/FuramaResort/data/bookingNotHaveContractYet.csv";
    static final String CONTRACT_PATH_FILE = "src/FuramaResort/data/contract.csv";

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
                int customerBookingChoice = Integer.parseInt(sc.nextLine().trim());
                if (customerBookingChoice > 0 && customerBookingChoice < CustomerServiceImpl.customerList.size() + 1) {
                    bookingCustomer = CustomerServiceImpl.customerList.get(customerBookingChoice - 1);
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
                String inputIdService = sc.nextLine().trim();
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

        System.out.print("Input start date: ");//Dùng regrex DoB, start date phải lớn hơn hoặc bằng ngày hiện tại
        String startDate;
        LocalDate startDateParse = null;
        boolean checkStartDate = false;
        while (true) {
            if (validation.validateDateOfBooking(startDate = sc.nextLine())) {
                try {
                    startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    checkStartDate = true;
                } catch (DateTimeParseException ignored) {
                } finally {
                    if (!checkStartDate) {
                        try {
                            startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            checkStartDate = true;
                        } catch (DateTimeParseException ignored) {
                        } finally {
                            if (!checkStartDate) {
                                try {
                                    startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                                    checkStartDate = true;
                                } catch (DateTimeParseException ignored) {
                                }
                            }
                        }
                    }
                }
                break;
            }
            else{
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Input end date: "); //End date phải lớn hơn start date
        String endDate = null;
        LocalDate endDateParse;
        boolean checkEndDate = false;
        while (!checkEndDate) {
            if (validation.validateDateOfBooking(endDate = sc.nextLine())) {
                try {
                    endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    if (endDateParse.isAfter(startDateParse)){
                        checkEndDate = true;
                    }
                } catch (DateTimeParseException ignored) {
                } finally {
                    if (!checkEndDate) {
                        try {
                            endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            if (endDateParse.isAfter(startDateParse)){
                                checkEndDate = true;
                            }
                        } catch (DateTimeParseException ignored) {
                        } finally {
                            if (!checkEndDate) {
                                try {
                                    endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                                    if (endDateParse.isAfter(startDateParse)){
                                        checkEndDate = true;
                                    }
                                } catch (DateTimeParseException ignored) {
                                }
                            }
                        }
                    }
                }
                if (!checkEndDate){
                    System.out.println("End date of booking have to be after start date booking! Input again!");
                }
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        List<Booking> addBookingList = new ArrayList<>();
        Booking newBooking = new Booking(startDate, endDate, bookingCustomer, facility);
        addBookingList.add(newBooking);
        writeBookingListIntoCSVFile(BOOKING_PATH_FILE, addBookingList, true);

        //Cộng 1 cho facility đã booking (Trùng năm, trùng tháng mới cộng 1, không thì không cộng)
        FacilityServiceImpl.facilityServiceList = FacilityServiceImpl.readCSVFileTofacilityServiceList(FacilityServiceImpl.FACILITY_PATH_FILE);

        for (Booking booking : bookingTreeSet) {
            if (booking.getStartDate().contains(year)) {
                if (Integer.parseInt(booking.getStartDate().substring(3, 5)) == month) {
                    for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
                        if (entry.getKey().getIdService().equals(facility.getIdService())) {
                            entry.setValue(entry.getValue() + 1);
                            break;
                        }
                    }
                    FacilityServiceImpl.writeFacilityListIntoCSVFile(FacilityServiceImpl.FACILITY_PATH_FILE, FacilityServiceImpl.facilityServiceList, false);
                }
            }
        }
        System.out.println("Add booking successfully!!!");
    }

    //Đầu tháng sẽ reset
    //Kiểm tra ngày bk có phải đầu tháng hay không
    //Nếu là đầu tháng thì kiểm tra số lần bk có bằng không hay không?, kiểm tra
    // checkResetStatus(boolean reset) là false hay true, nếu false thì reset = 0
    //và chuyển checkResetStatus(boolean reset) thành true.
//    public void updateBookingTimes(Facility facility) {
//        bookingTreeSet = readCSVFileToBookingSet(BOOKING_PATH_FILE);
//        FacilityServiceImpl.facilityServiceList = FacilityServiceImpl.readCSVFileTofacilityServiceList(FacilityServiceImpl.FACILITY_PATH_FILE);
//        if (day == 1) {
//            for (Booking booking : bookingTreeSet) {
//                if (booking.getStartDate().contains(year)) {
//                    if (Integer.parseInt(booking.getStartDate().substring(3, 5)) != month) {
//                        for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
//                            if (entry.getKey().getIdService().equals(facility.getIdService())) {
//                                entry.setValue(0);
//                                break;
//                            }
//                        }
//                        FacilityServiceImpl.writeFacilityListIntoCSVFile(FacilityServiceImpl.FACILITY_PATH_FILE, FacilityServiceImpl.facilityServiceList, false);
//                    }
//                }
//            }
//        }
//    }


    //Done
    @Override
    public void displayBooking() {
        bookingTreeSet = readCSVFileToBookingSet(BOOKING_PATH_FILE);
        System.out.println("Booking list:");
        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
        writeBookingListIntoCSVFile(BOOKING_PATH_FILE, new ArrayList<>(bookingTreeSet), false);//Săp xếp theo ngày rồi ghi đè lại
//        //Ghi đè lại danh sách booking có thể làm hợp đồng để chạy phương thức createNewContract()
//        List<Booking> addToBookingForContractFile = new ArrayList<>();
//        for (Booking booking : bookingTreeSet) {
//            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
//                addToBookingForContractFile.add(booking);
//            }
//        }
//        writeBookingListIntoCSVFile(BOOKING_VILLA_AND_HOUSE_FOR_CONTRACT_PATH_FILE, addToBookingForContractFile, false);
    }

    @Override
    public void createNewContract() {
        Scanner sc = new Scanner(System.in);
        Set<Booking> bookingForContractTreeSet = readCSVFileToBookingSet(BOOKING_NOT_HAVE_CONTRACT_YET_PATH_FILE);
        bookingQueue.clear();
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
                System.out.print("Choice a booking number (earliest startDate first): ");
                int choiceBooking;
                while (true) {
                    choiceBooking = Integer.parseInt(sc.nextLine().trim());
                    if (bookingQueue.peek().getBookingNumber() == choiceBooking) {
                        break;
                    } else {
                        System.out.println("The booking have to be the earliest startDate first!!! Choice again!");
                    }

                }
                for (Booking booking : bookingQueue) {
                    if (choiceBooking == booking.getBookingNumber()) {
                        flag = true;
                        newContractBooking = booking;
                        newContractBookingNumber = booking.getBookingNumber();
//                        bookingQueue.remove(); //???? vì sao remove không được với LinkedList và PriorityQueue???
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

        //Read ra list => .add đối tượng mới tạo => write đè lại
        List<Contract> addContractList = readCSVFileToContractList(CONTRACT_PATH_FILE);
        addContractList.add(new Contract(contractDeposit, contractSum, newContractBooking));
        writeContractListIntoCSVFile(CONTRACT_PATH_FILE, addContractList, false);
        Booking booking = bookingQueue.remove();

        //Remove booking đã có contract khỏi file BOOKING_NOT_HAVE_CONTRACT_YET_PATH_FILE
        List<Booking> notHaveContractBookingList = new ArrayList<>(bookingQueue);
        Collections.sort(notHaveContractBookingList, new SortByStartDate());
        writeBookingListIntoCSVFile(BOOKING_NOT_HAVE_CONTRACT_YET_PATH_FILE, notHaveContractBookingList, false);

        //Thêm booking đã có contract vào file BOOKING_ALREADY_HAD_CONTRACT_PATH_FILE
        Set<Booking> alreadyHadContractBookingSet = readCSVFileToBookingSet(BOOKING_ALREADY_HAD_CONTRACT_PATH_FILE);
        alreadyHadContractBookingSet.add(booking);
        List<Booking> alreadyHadContractBookingList = new ArrayList<>(alreadyHadContractBookingSet);
        Collections.sort(alreadyHadContractBookingList, new SortByStartDate());
        writeBookingListIntoCSVFile(BOOKING_ALREADY_HAD_CONTRACT_PATH_FILE, alreadyHadContractBookingList, false);
        System.out.println("Create new contract successfully for booking number " + newContractBookingNumber);
    }

    @Override
    public void displayContract() {
        contractList = readCSVFileToContractList(CONTRACT_PATH_FILE);
        if (contractList.isEmpty()) {
            System.out.println("There're no contracts!!!");
        } else {
            System.out.println("Contract list:");
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
            boundaryLoop:
            do {
                try {
                    System.out.println("Contract list:");
                    for (Contract contract : contractList) {
                        System.out.println(contract);
                    }
                    System.out.print("Input the number of contract you wanna edit: ");
                    int editNumberContract = Integer.parseInt(sc.nextLine());
                    for (Contract contract : contractList) {
                        if (contract.getContractNumber() == editNumberContract) {
                            flag = true;
                            do {
                                try {
                                    System.out.println("Edit contract list:");
                                    System.out.println("1. Edit contract deposit");
                                    System.out.println("2. Edit total charge of contract");
                                    System.out.println("3. Return to booking management menu");
                                    System.out.print("Your choice: ");
                                    int editChoice = Integer.parseInt(sc.nextLine());
                                    if (editChoice == 1) {
                                        while (true) {
                                            try {
                                                System.out.print("Input new deposit of contract: ");
                                                contract.setContractDeposit(Double.parseDouble(sc.nextLine()));
                                                writeContractListIntoCSVFile(CONTRACT_PATH_FILE, contractList, false);
                                                System.out.println("Edit deposit of contract successfully!");
                                                break;
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
                                                contract.setContractSum(Double.parseDouble(sc.nextLine()));
                                                writeContractListIntoCSVFile(CONTRACT_PATH_FILE, contractList, false);
                                                System.out.println("Edit total charge of contract successfully!");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            } catch (Exception e) {
                                                System.out.println("Wrong format !!! Input again!");
                                            }
                                        }
                                    } else if (editChoice == 3) {
                                        returnMainMenu();
                                        break boundaryLoop;
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
    }

    public static Set<Booking> readCSVFileToBookingSet(String pathFile) {
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
            int bookingNumber = Integer.parseInt(lineSplitList[0]);
            bookingCSV.setBookingNumber(bookingNumber);
            bookingTreeSetFromReadCSV.add(bookingCSV);
        }
        return bookingTreeSetFromReadCSV;
    }

    public static List<Contract> readCSVFileToContractList(String pathFile) {
        List<String> lineString = ReadAndWriteFile.readCSVFileToStringList(pathFile);
        List<Contract> contractTreeSetFromReadCSV = new ArrayList<>();
        Set<Booking> bookingAlreadyHadContractTreeSet = readCSVFileToBookingSet(BOOKING_ALREADY_HAD_CONTRACT_PATH_FILE);
        String[] lineSplitList;
        Booking bookingCSV = null;
        Contract contractCSV;

//        //Ghi đè lại danh sách booking có thể làm hợp đồng để chạy phương thức createNewContract()
//        List<Booking> addToBookingForContractFile = new ArrayList<>();
//        for (Booking booking : bookingTreeSet) {
//            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
//                addToBookingForContractFile.add(booking);
//            }
//        }
//        writeBookingListIntoCSVFile(BOOKING_FOR_CONTRACT_PATH_FILE, addToBookingForContractFile, false);
//        Set<Booking> bookingForContractTreeSet = readCSVFileToBookingList(BOOKING_VILLA_AND_HOUSE_FOR_CONTRACT_PATH_FILE);
//        bookingQueue.clear();
//        bookingQueue.addAll(bookingAlreadyHadContractTreeSet);

        Contract.setNumberOfContract(0);
        for (String s : lineString) {
            lineSplitList = s.split(",");
            for (Booking booking : bookingAlreadyHadContractTreeSet) {
                if (booking.getBookingNumber() == Integer.parseInt(lineSplitList[1])) {
                    if (booking.getCustomer().getCustomerId() == Integer.parseInt(lineSplitList[4])) {
                        bookingCSV = booking;
                        break;
                    }
                }
            }
            contractCSV = new Contract(Double.parseDouble(lineSplitList[2]), Double.parseDouble(lineSplitList[3]), bookingCSV);
            int contractNumber = Integer.parseInt(lineSplitList[0]);
            contractCSV.setContractNumber(contractNumber);
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

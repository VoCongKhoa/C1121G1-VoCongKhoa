package FuramaResort.services.impls;

import FuramaResort.models.*;
import FuramaResort.services.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookingTreeSet = new TreeSet<>(new SortByStartDate());
    static Queue<Booking> bookingQueue = new ArrayDeque<>();//Booking for add contract
    static List<Contract> contractList = new ArrayList<>();
    static Set<Facility> facilitySet;

    static {
        facilitySet = FacilityServiceImpl.facilityServiceList.keySet();
        Facility facility1 = (Facility) facilitySet.toArray()[0];
        Facility facility2 = (Facility) facilitySet.toArray()[1];
        Facility facility3 = (Facility) facilitySet.toArray()[2];

        Booking booking1 = new Booking("01/01/2020", "07/01/2020",
                CustomerServiceImpl.customerList.get(0), facility1);
        Booking booking2 = new Booking("04/01/2019", "07/01/2019",
                CustomerServiceImpl.customerList.get(1), facility2);
        Booking booking3 = new Booking("01/01/2022", "06/01/2022",
                CustomerServiceImpl.customerList.get(2), facility3);
        Booking booking4 = new Booking("03/01/2022", "07/01/2022",
                CustomerServiceImpl.customerList.get(0), facility1);
        Booking booking5 = new Booking("01/01/2020", "08/01/2020",
                CustomerServiceImpl.customerList.get(1), facility2);

        bookingTreeSet.add(booking1);
        bookingTreeSet.add(booking2);
        bookingTreeSet.add(booking3);
        bookingTreeSet.add(booking4);
        bookingTreeSet.add(booking5);
        for (Booking booking : bookingTreeSet) {
            if (booking.getFacility() instanceof Villa || booking.getFacility() instanceof House) {
                bookingQueue.add(booking);
            }
        }
    }

    @Override
    public void addBooking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Customers List:");
        for (int i = 0; i < CustomerServiceImpl.customerList.size(); i++) {
            System.out.println(i + 1 + "." + CustomerServiceImpl.customerList.get(i));
        }
        System.out.println("Choice a number:");
        int customerBookingChoice = Integer.parseInt(sc.nextLine());
        Customer bookingCustomer = CustomerServiceImpl.customerList.get(customerBookingChoice - 1);
        System.out.println("Service List:");
        for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
            System.out.println(entry);
        }
        Facility facility;
        boolean flag = false;
        checkIdServiceLoop:
        while (true) {
            System.out.println("Input id service:");
            String inputIdService = sc.nextLine();
            for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityServiceList.entrySet()) {
                if (entry.getKey().getIdService().equals(inputIdService)) {
                    facility = entry.getKey();
                    break checkIdServiceLoop;
                }
            }
            if (!flag) {
                System.out.println("Wrong format!!");
            }
        }
        System.out.println("Input start date:");
        String startDate = sc.nextLine();
        System.out.println("Input end date:");
        String endDate = sc.nextLine();
        Booking newBooking = new Booking(startDate, endDate, bookingCustomer, facility);
        bookingTreeSet.add(newBooking);
        System.out.println("Add booking successfully!!!");
    }

    @Override
    public void displayBooking() {
        for (Booking booking : bookingTreeSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void createNewContract() {
        Scanner sc = new Scanner(System.in);
        //Số HĐ, Mã Bk, số tiền cọc trước, tổng số tiền thanh toán, mã KH
        System.out.println("Booking list:");
        for (Booking booking : bookingQueue) {
            System.out.println(booking);
        }
        System.out.println("Choice a booking number (earliest startDate first):");
        int choiceBooking = Integer.parseInt(sc.nextLine());
        Booking newContractBooking = null;
        int newContractBookingNumber = 0;
        for (Booking booking : bookingQueue) {
            if (choiceBooking == booking.getBookingNumber()) {
                newContractBooking = booking;
                newContractBookingNumber = booking.getBookingNumber();
                bookingQueue.remove(); //???? vì sao remove không được với LinkedList và PriorityQueue???
            }
        }
        System.out.println("Input deposit of customer for new contract:");
        int contractDeposit = Integer.parseInt(sc.nextLine());
        System.out.println("Input total charge of new contract:");
        int contractSum = Integer.parseInt(sc.nextLine());
        Contract newContract = new Contract(contractDeposit, contractSum, newContractBooking);
        contractList.add(newContract);
        System.out.println("Create new contract successfully for booking number " + newContractBookingNumber);
    }

    @Override
    public void displayContract() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void editContract() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of contract you wanna edit:");
        int editNumberContract = Integer.parseInt(sc.nextLine());
        boolean flag = false;//Hoặc true
        while (!flag){
            for (Contract contract : contractList) {
                if (contract.getContractNumber() == editNumberContract) {
                    flag = true;
                    System.out.println("Your choice: ");
                    System.out.println("1. Edit contract deposit");
                    System.out.println("2. Edit total charge of contract");
                    int editChoice = Integer.parseInt(sc.nextLine());
                    while (editChoice != 1 && editChoice != 2) {
                        System.out.println("Choice wrong number!!!");
                        System.out.println("Choice again:");
                        editChoice = Integer.parseInt(sc.nextLine());
                    }
                    if (editChoice == 1) {
                        System.out.println("Input new deposit of contract:");
                        contract.setContractDeposit(Double.parseDouble(sc.nextLine()));
                        System.out.println("Edit successfully!!!");
                    } else {
                        System.out.println("Input new total charge of contract:");
                        contract.setContractSum(Double.parseDouble(sc.nextLine()));
                        System.out.println("Edit successfully!!!");
                    }
                    break;
                }
            }
            if (!flag){
                System.out.println("Input again the number of contract you wanna edit:");
                editNumberContract = Integer.parseInt(sc.nextLine());
            }
        }

    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

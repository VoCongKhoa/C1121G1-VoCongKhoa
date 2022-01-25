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
        Customer bookingCustomer;
        while (true) {
            try {
                System.out.println("Customers List:");
                for (int i = 0; i < CustomerServiceImpl.customerList.size(); i++) {
                    System.out.println(i + 1 + "." + CustomerServiceImpl.customerList.get(i));
                }
                System.out.print("Choice customer id: ");
                int customerBookingChoice = Integer.parseInt(sc.nextLine());
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
        Booking newContractBooking;
        int newContractBookingNumber;
        boolean flag = false;
        boundaryLoop:
        while (true){
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
                if (!flag){
                    System.out.println("Not found!!! Choice again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!! Input again!");
            } catch (Exception e) {
                System.out.println("Wrong format !!! Input again!");
            }
        }

        double contractDeposit;
        while (true){
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
        while (true){
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
        contractList.add(newContract);
        System.out.println("Create new contract successfully for booking number " + newContractBookingNumber);
    }

    @Override
    public void displayContract() {
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
}

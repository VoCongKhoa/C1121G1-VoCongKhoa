package FuramaResort.controllers;

import FuramaResort.models.*;
import FuramaResort.services.*;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 6) {
            displayMainMenu();
            System.out.print("Input your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    break;
                case 2:
                    System.out.println("1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    break;
                case 3:
                    System.out.println("1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    break;
                case 4:
                    System.out.println("1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    break;
                case 5:
                    System.out.println("1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }
        Person employee = new Employee("Khoa", 29,"22/08/1993","male","123","0905472592","youandme8668@gmail.com",
                1,"ĐH","junior",20);
        Person customer = new Customer("Su", 26,"05/07/1996","female","456","0905472111","8668@gmail.com",
                2,"Diamond","ĐN");
        Facility villa = new Villa("bookingVilla",100,10,10,"day","big",25,3);
        Facility house = new House("bookingVilla",100,10,10,"day","medium",2);
        Facility room = new Room("bookingVilla",100,10,10,"day","free");

        Booking booking = new Booking(123, "1/1/2022", "7/1/2022",3,"bookingVilla","day");
        Contract contract = new Contract(1000,20,50,123,3);

        System.out.println(employee);
        System.out.println(customer);
        System.out.println(villa);
        System.out.println(house);
        System.out.println(room);
        System.out.println(booking);
        System.out.println(contract);

        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        Service facilityService = new FacilityServiceImpl();

        bookingService.addBooking();
        contractService.displayCusUseService();
        customerService.displayCus();
        employeeService.displayEmp();
        facilityService.returnMainMenu();
    }

    static void displayMainMenu() {
        System.out.println("1.\tEmployee Management\n" +
                "2.\tCustomer Management\n" +
                "3.\tFacility Management \n" +
                "4.\tBooking Management\n" +
                "5.\tPromotion Management\n" +
                "6.\tExit\n");
    }
}

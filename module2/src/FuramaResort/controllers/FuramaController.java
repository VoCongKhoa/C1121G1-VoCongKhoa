package FuramaResort.controllers;

import FuramaResort.models.*;
import FuramaResort.services.*;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
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
                    System.out.println("Input your choice:");
                    int empChoice = sc.nextInt();
                    if (empChoice == 1) {
                        employeeService.displayEmp();
                    } else if (empChoice == 2) {
                        employeeService.addEmp();
                    } else if (empChoice == 3) {
                        employeeService.editEmp();
                    } else if (empChoice == 4) {
                        employeeService.returnMainMenu();
                    } else {
                        System.out.println("Choice again: ");
                    }

                    break;
                case 2:
                    System.out.println("1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    System.out.println("Input your choice:");
                    int cusChoice = sc.nextInt();
                    if (cusChoice == 1) {
                        customerService.displayCus();
                    } else if (cusChoice == 2) {
                        customerService.addCus();
                    } else if (cusChoice == 3) {
                        customerService.editCus();
                    } else if (cusChoice == 4) {
                        customerService.returnMainMenu();
                    } else {
                        System.out.println("Choice again: ");
                    }
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
        Employee employee = new Employee(1, "Khoa", "22/08/1993", "male", "123",
                "0905472592", "youandme8668@gmail.com", "ĐH", "junior", 20);
        Customer customer = new Customer("Su", "05/07/1996", "female", "456",
                "0905472111", "8668@gmail.com", "Diamond", "ĐN");
        Villa villa = new Villa("bookingVilla", 100, 10, 10,
                "day", "big", 25, 3);
        House house = new House("bookingVilla", 100, 10, 10,
                "day", "medium", 2);
        Room room = new Room("bookingVilla", 100, 10, 10,
                "day", "free");

        Booking booking = new Booking(123, "1/1/2022", "7/1/2022", 3, "bookingVilla", "day");
        Contract contract = new Contract(1000, 20, 50, 123, 3);

//        System.out.println(employee);
//        System.out.println(customer);
//        System.out.println(villa);
//        System.out.println(house);
//        System.out.println(room);
//        System.out.println(booking);
//        System.out.println(contract);


//        bookingService.addBooking();
//        contractService.displayCusUseService();
//        customerService.displayCus();
        employeeService.displayEmp();
//        facilityService.returnMainMenu();
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

package FuramaResort.controllers;

import FuramaResort.services.impls.*;

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
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    System.out.println("Input your choice:");
                    int employeeChoice = Integer.parseInt(sc.nextLine());
                    if (employeeChoice == 1) {
                        employeeService.displayEmployee();
                    } else if (employeeChoice == 2) {
                        employeeService.addEmployee();
                    } else if (employeeChoice == 3) {
                        employeeService.editEmployee();
                    } else if (employeeChoice == 4) {
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
                    int customerChoice = Integer.parseInt(sc.nextLine());
                    if (customerChoice == 1) {
                        customerService.displayCustomer();
                    } else if (customerChoice == 2) {
                        customerService.addCustomer();
                    } else if (customerChoice == 3) {
                        customerService.editCustomer();
                    } else if (customerChoice == 4) {
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
                    System.out.println("Input your choice:");
                    int facilityChoice = Integer.parseInt(sc.nextLine());
                    if (facilityChoice == 1) {
                        facilityService.displayFacility();
                    } else if (facilityChoice == 2) {
                        facilityService.addFacility();
                    } else if (facilityChoice == 3) {
                        facilityService.displayFacilityMaintenance();
                    } else if (facilityChoice == 4) {
                        facilityService.returnMainMenu();
                    } else {
                        System.out.println("Choice again: ");
                    }
                    break;
                case 4:
                    System.out.println("1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new contract\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contract\n" +
                            "6.\tReturn main menu\n");
                    System.out.println("Input your choice:");
                    int bookingChoice = Integer.parseInt(sc.nextLine());
                    if (bookingChoice == 1) {
                        bookingService.addBooking();
                    } else if (bookingChoice == 2) {
                        bookingService.displayBooking();
                    } else if (bookingChoice == 3) {
                        bookingService.createNewContract();
                    } else if (bookingChoice == 4) {
                        bookingService.displayContract();
                    } else if (bookingChoice == 5) {
                        bookingService.editContract();
                    } else {
                        System.out.println("Choice again: ");
                    }
                    break;
                case 5:
                    System.out.println("1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    System.out.println("Input your choice:");
                    int promotionChoice = Integer.parseInt(sc.nextLine());
                    if (promotionChoice == 1) {
                        contractService.displayCustomerUseService();
                    } else if (promotionChoice == 2) {
                        contractService.displayCustomerGetVoucher();
                    } else if (promotionChoice == 3) {
                        contractService.returnMainMenu();
                    } else {
                        System.out.println("Choice again: ");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        }

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

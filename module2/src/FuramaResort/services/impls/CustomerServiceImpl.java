package FuramaResort.services.impls;

import FuramaResort.models.Customer;
import FuramaResort.services.CustomerService;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    static LinkedList<Customer> customerList = new LinkedList<>();

    static {
        Customer customer1 = new Customer("Su", "05/07/1996", "female", "456",
                "0905472111", "8668@gmail.com", "Diamond", "ĐN");
        Customer customer2 = new Customer("Khoa", "22/08/1993", "male", "123",
                "0905472111", "8668@gmail.com", "Platinum", "ĐN");
        Customer customer3 = new Customer("Khoa2", "01/01/1993", "male", "789",
                "0905472111", "86682@gmail.com", "Gold", "QN");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
    }

    @Override
    public void displayCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomer() {
        System.out.println("Add new name of customer: ");
        String newName = sc.nextLine();
        System.out.println("Add new DoB of customer: ");
        String newDateOfBirth = sc.nextLine();
        System.out.println("Add new gender of customer: ");
        String newGender = sc.nextLine();
        System.out.println("Add new ID number of customer: ");
        String newIdNumber = sc.nextLine();
        System.out.println("Add new phone number of customer: ");
        String newPhoneNumber = sc.nextLine();
        System.out.println("Add new email of customer: ");
        String newEmail = sc.nextLine();
        System.out.println("Add new rank of customer: ");
        String newCusRank = sc.nextLine();
        System.out.println("Add new address of customer: ");
        String newCusAddress = sc.nextLine();
        Customer newCustomer = new Customer(newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newCusRank, newCusAddress);
        customerList.add(newCustomer);
    }

    @Override
    public void editCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id of customer you wanna edit:");
        int editIdCusChoice = Integer.parseInt(sc.nextLine());
        for (Customer customer : customerList) {
            if (customer.getId() == editIdCusChoice) {
                boolean customerFlag = false;
                do {
                    System.out.println("List of customer property:\n" +
                            "1.Edit name\n" +
                            "2.Edit date of birth\n" +
                            "3.Edit gender\n" +
                            "4.Edit identification number\n" +
                            "5.Edit phone number\n" +
                            "6.Edit email\n" +
                            "7.Edit customer rank\n" +
                            "8.Edit customer address\n" +
                            "9.Return customer management menu\n");
                    System.out.print("Input property you wanna edit: ");
                    int editPropertyEmpChoice = Integer.parseInt(sc.nextLine());
                    switch (editPropertyEmpChoice) {
                        case 1:
                            System.out.println("Input your new name:");
                            customer.setName(sc.nextLine());
                            System.out.println("Edit customer name successfully!!!");
                            break;
                        case 2:
                            System.out.println("Input your new date of birth:");
                            customer.setDateOfBirth(sc.nextLine());
                            System.out.println("Edit customer DoB successfully!!!");
                            break;
                        case 3:
                            System.out.println("Input your new gender:");
                            customer.setGender(sc.nextLine());
                            System.out.println("Edit customer gender successfully!!!");
                            break;
                        case 4:
                            System.out.println("Input your new identification number:");
                            customer.setIDNumber(sc.nextLine());
                            System.out.println("Edit customer identification number successfully!!!");
                            break;
                        case 5:
                            System.out.println("Input your new phone number:");
                            customer.setPhoneNumber(sc.nextLine());
                            System.out.println("Edit customer phone number successfully!!!");
                            break;
                        case 6:
                            System.out.println("Input your new email:");
                            customer.setEmail(sc.nextLine());
                            System.out.println("Edit customer email successfully!!!");
                            break;
                        case 7:
                            System.out.println("Input your new customer rank:");
                            customer.setCustomerRank(sc.nextLine());
                            System.out.println("Edit customer rank successfully!!!");
                            break;
                        case 8:
                            System.out.println("Input your new customer address:");
                            customer.setCustomerAddress(sc.nextLine());
                            System.out.println("Edit customer address successfully!!!");
                            break;
                        case 9:
                            customerFlag = true;
                            returnMainMenu();
                            break;
                        default:
                            System.out.println("Choice again!!!");
                    }
                } while (!customerFlag);
            }
        }
    }

    @Override
    public void returnMainMenu() {
    }
}

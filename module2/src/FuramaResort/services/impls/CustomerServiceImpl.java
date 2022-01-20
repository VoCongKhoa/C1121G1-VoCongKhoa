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
        System.out.println("Input id of customer you wanna edit:");
        int editIdCusChoice = sc.nextInt();
        System.out.println(Customer.getNumberOfCustomer());
        for (Customer customer : customerList) {
            if (customer.getId() == editIdCusChoice) {
                System.out.println("Input property you wanna edit:\n" +
                                   "1.Edit customer id\n" +
                                   "2.Edit name\n" +
                                   "3.Edit date of birth\n" +
                                   "4.Edit gender\n" +
                                   "5.Edit identification number\n" +
                                   "6.Edit phone number\n" +
                                   "7.Edit email\n" +
                                   "8.Edit customer rank\n" +
                                   "9.Edit customer address\n");
                int editPropertyCusChoice = sc.nextInt();
                sc.nextLine();
                switch (editPropertyCusChoice) {
                    case 1:
                        System.out.println("Input your new customer id:");
                        Customer.setNumberOfCustomer(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Input your new name:");
                        customer.setName(sc.nextLine());
                        sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Input your new date of birth:");
                        customer.setDateOfBirth(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Input your new gender:");
                        customer.setGender(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Input your new identification number:");
                        customer.setIDNumber(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Input your new phone number:");
                        customer.setPhoneNumber(sc.nextLine());
                        break;
                    case 7:
                        System.out.println("Input your new email:");
                        customer.setEmail(sc.nextLine());
                        break;
                    case 8:
                        System.out.println("Input your new customer rank:");
                        customer.setCustomerRank(sc.nextLine());
                        break;
                    case 9:
                        System.out.println("Input your new customer address:");
                        customer.setCustomerAddress(sc.nextLine());
                        break;
                }
            }
        }

    }

    @Override
    public void returnMainMenu() {
    }
}

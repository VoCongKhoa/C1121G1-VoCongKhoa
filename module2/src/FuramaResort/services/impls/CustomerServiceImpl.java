package FuramaResort.services.impls;

import FuramaResort.models.Customer;
import FuramaResort.services.CustomerService;
import FuramaResort.utils.Validation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner sc = new Scanner(System.in);
    Validation validation = new Validation();
    static LinkedList<Customer> customerList = new LinkedList<>();
    private static List<String> rankList = new ArrayList<>();

    static {
        rankList.add("Diamond");
        rankList.add("Platinum");
        rankList.add("Gold");
        rankList.add("Silver");
        rankList.add("Member");
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
        System.out.print("Add new name of customer (Ex: Alex,khoa123,...): ");
        String newName;
        while (true) {
            if (validation.validateName(newName = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new DoB of customer: ");
        String newDateOfBirth = sc.nextLine();

        System.out.print("Add new gender of customer (Only Male or Female): ");
        String newGender;
        while (true) {
            if (validation.validateGender(newGender = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new ID number of customer (12 digits): ");
        String newIdNumber;
        while (true) {
            if (validation.validateIDNumber(newIdNumber = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new phone number of customer (Ex: (+86) 905472592,...): ");
        String newPhoneNumber;
        while (true) {
            if (validation.validatePhoneNumber(newPhoneNumber = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.print("Add new email of customer (Ex: youandme8668@gmail.com.vn): ");
        String newEmail;
        while (true) {
            if (validation.validateEmail(newEmail = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }

        System.out.println("Customer rank:");
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.print("Choice the customer rank: ");
        String newCustomerRank;
        int newCustomerRankChoice;
        while (true) {
            try {
                newCustomerRankChoice = Integer.parseInt(sc.nextLine());
                if (newCustomerRankChoice > 0 && newCustomerRankChoice < 6) {
                    newCustomerRank = rankList.get(newCustomerRankChoice - 1);
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

        System.out.print("Add new address of customer: ");
        String newCustomerAddress;
        while (true) {
            if (!(newCustomerAddress = sc.nextLine()).trim().equals("")) {
                break;
            } else {
                System.out.println("Address of customer can't be empty!!! Input again!");
            }
        }

        Customer newCustomer = new Customer(newName, newDateOfBirth, newGender, newIdNumber,
                newPhoneNumber, newEmail, newCustomerRank, newCustomerAddress);
        customerList.add(newCustomer);
    }

    @Override
    public void editCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input id of customer you wanna edit: ");
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
                            System.out.print("Input your new name: ");
                            while (true) {
                                String editName;
                                if (validation.validateName(editName = sc.nextLine())) {
                                    customer.setName(editName);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer name successfully!!!");
                            break;
                        case 2:
                            System.out.print("Input your new date of birth: ");
                            while (true) {
                                String editGender;
                                if (validation.validateGender(editGender = sc.nextLine())) {
                                    customer.setDateOfBirth(editGender);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer DoB successfully!!!");
                            break;
                        case 3:
                            System.out.print("Input your new gender: ");
                            while (true) {
                                String editIdNumber;
                                if (validation.validateIDNumber(editIdNumber = sc.nextLine())) {
                                    customer.setGender(editIdNumber);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer gender successfully!!!");
                            break;
                        case 4:
                            System.out.print("Input your new identification number: ");
                            while (true) {
                                String editIdNumber;
                                if (validation.validateIDNumber(editIdNumber = sc.nextLine())) {
                                    customer.setIDNumber(editIdNumber);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer identification number successfully!!!");
                            break;
                        case 5:
                            System.out.print("Input your new phone number: ");
                            while (true) {
                                String editPhoneNumber;
                                if (validation.validatePhoneNumber(editPhoneNumber = sc.nextLine())) {
                                    customer.setPhoneNumber(editPhoneNumber);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer phone number successfully!!!");
                            break;
                        case 6:
                            System.out.print("Input your new email: ");
                            while (true) {
                                String editEmail;
                                if (validation.validateEmail(editEmail = sc.nextLine())) {
                                    customer.setEmail(editEmail);
                                    break;
                                } else {
                                    System.out.println("Wrong format!!! Input again!");
                                }
                            }
                            System.out.println("Edit customer email successfully!!!");
                            break;
                        case 7:
                            System.out.println("Customer rank:");
                            System.out.println("1. Diamond");
                            System.out.println("2. Platinum");
                            System.out.println("3. Gold");
                            System.out.println("4. Silver");
                            System.out.println("5. Member");
                            System.out.print("Choice the edit customer rank: ");
                            String newCustomerRank;
                            int newCustomerRankChoice;
                            while (true) {
                                try {
                                    newCustomerRankChoice = Integer.parseInt(sc.nextLine());
                                    if (newCustomerRankChoice > 0 && newCustomerRankChoice < 6) {
                                        newCustomerRank = rankList.get(newCustomerRankChoice - 1);
                                        customer.setCustomerRank(newCustomerRank);
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
                            System.out.println("Edit customer rank successfully!!!");
                            break;
                        case 8:
                            System.out.print("Input your new customer address: ");
                            while (true) {
                                String editCustomerAddress;
                                if (!(editCustomerAddress = sc.nextLine()).trim().equals("")) {
                                    customer.setCustomerAddress(editCustomerAddress);
                                    break;
                                } else {
                                    System.out.println("Address of customer can't be empty!!! Input again!");
                                }
                            }
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

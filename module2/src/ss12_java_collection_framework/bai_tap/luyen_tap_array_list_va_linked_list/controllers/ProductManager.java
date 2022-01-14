package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.controllers;

import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.LaptopService;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.PhoneService;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.Service;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls.LaptopServiceImpl;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls.PhoneServiceImpl;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls.TabletServiceImpl;

import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LaptopServiceImpl laptopService = new LaptopServiceImpl();
        TabletServiceImpl tabletService = new TabletServiceImpl();
        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        int choice = -1;
        while (choice != 4) {
            displayMainMenu();
            System.out.print("Input your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayPropertyMenu("phone");
                    System.out.println("Input your choice:");
                    int phoneChoice = Integer.parseInt(sc.nextLine());
                    choiceMethod(phoneService, phoneChoice);
                    break;
                case 2:
                    displayPropertyMenu("laptop");
                    System.out.println("Input your choice:");
                    int laptopChoice = Integer.parseInt(sc.nextLine());
                    choiceMethod(laptopService, laptopChoice);
                    break;
                case 3:
                    displayPropertyMenu("tablet");
                    System.out.println("Input your choice:");
                    int tabletChoice = Integer.parseInt(sc.nextLine());
                    choiceMethod(tabletService, tabletChoice);
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    }

    static void displayMainMenu() {
        System.out.println("1.\tPhone Management\n" +
                "2.\tLaptop Management\n" +
                "3.\tTablet Management \n" +
                "4.\tExit\n");
    }

    static void displayPropertyMenu(String productName) {
        String propertyMenu = "1\tDisplay list " + productName + "s\n" +
                "2\tAdd new " + productName + "\n" +
                "3\tEdit " + productName + " by name\n" +
                "4\tDelete " + productName + "\n" +
                "5\tSort " + productName + " by price\n" +
                "6\tSort " + productName + " by name\n" +
                "7\tSearch " + productName + " by name\n";
        if (productName.equals("phone")) {
            propertyMenu = propertyMenu + "8\tSearch " + productName + " by type\n";
            System.out.println(propertyMenu);
        } else if (productName.equals("laptop")) {
            propertyMenu = propertyMenu + "8\tSearch " + productName + " by SSD\n";
            System.out.println(propertyMenu);
        } else {
            System.out.println(propertyMenu);
        }
    }

    static void choiceMethod(Service service, int choice) {
        switch (choice) {
            case 1:
                service.displayProduct();
                break;
            case 2:
                service.addProduct();
                break;
            case 3:
                service.editProductByName();
                break;
            case 4:
                service.deleteProductByName();
                break;
            case 5:
                service.sortProductByPrice();
                break;
            case 6:
                service.sortProductByName();
                break;
            case 7:
                service.searchProductByName();
                break;
            case 8:
                if (service instanceof PhoneService) {
                    ((PhoneService) service).seachProductByType();
                } else if (service instanceof LaptopService) {
                    ((LaptopService) service).seachProductBySSD();
                }
                break;
        }
    }
}

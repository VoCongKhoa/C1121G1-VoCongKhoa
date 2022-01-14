package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.controllers;

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
                    if (phoneChoice == 1) {
                        phoneService.displayProduct();
                    } else if (phoneChoice == 2) {
                        phoneService.addProduct();
                        System.out.println("Add Successfully!!!");
                    } else if (phoneChoice == 3) {
                        phoneService.editProductByName();
                        System.out.println("Edit Successfully!!!");
                    } else if (phoneChoice == 4) {
                        phoneService.deleteProductByName();
                    } else if (phoneChoice == 5) {
                        phoneService.sortProductByPrice();
                        System.out.println("Sort by Price Successfully!!!");
                    } else if (phoneChoice == 6) {
                        phoneService.sortProductByName();
                        System.out.println("Sort by Name Successfully!!!");
                    } else if (phoneChoice == 7) {
                        phoneService.searchProductByName();
                    } else if (phoneChoice == 8) {
                        phoneService.seachProductByType();
                    } else {
                        System.out.println("Choice again: ");
                    }
                    break;
                case 2:
                    displayPropertyMenu("laptop");
                    System.out.println("Input your choice:");
                    int laptopChoice = Integer.parseInt(sc.nextLine());
                    if (laptopChoice == 1) {
                        laptopService.displayProduct();
                    } else if (laptopChoice == 2) {
                        laptopService.addProduct();
                        System.out.println("Add Successfully!!!");
                    } else if (laptopChoice == 3) {
                        laptopService.editProductByName();
                        System.out.println("Edit Successfully!!!");
                    } else if (laptopChoice == 4) {
                        laptopService.deleteProductByName();
                    } else if (laptopChoice == 5) {
                        laptopService.sortProductByPrice();
                        System.out.println("Sort by Price Successfully!!!");
                    } else if (laptopChoice == 6) {
                        laptopService.sortProductByName();
                        System.out.println("Sort by Name Successfully!!!");
                    } else if (laptopChoice == 7) {
                        laptopService.searchProductByName();
                    } else if (laptopChoice == 8) {
                        laptopService.seachProductBySSD();
                    } else {
                        System.out.println("Choice again: ");
                    }
                    break;
                case 3:
                    displayPropertyMenu("tablet");
                    System.out.println("Input your choice:");
                    int tabletChoice = Integer.parseInt(sc.nextLine());
                    if (tabletChoice == 1) {
                        tabletService.displayProduct();
                    } else if (tabletChoice == 2) {
                        tabletService.addProduct();
                    } else if (tabletChoice == 3) {
                        tabletService.editProductByName();
                        System.out.println("Edit Successfully!!!");
                    } else if (tabletChoice == 4) {
                        tabletService.deleteProductByName();
                    } else if (tabletChoice == 5) {
                        tabletService.sortProductByPrice();
                        System.out.println("Sort by Price Successfully!!!");
                    } else if (tabletChoice == 6) {
                        tabletService.sortProductByName();
                        System.out.println("Sort by Name Successfully!!!");
                    } else if (tabletChoice == 7) {
                        tabletService.searchProductByName();
                    } else {
                        System.out.println("Choice again: ");
                    }
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
}

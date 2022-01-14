package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls;

import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models.Laptop;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.LaptopService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LaptopServiceImpl implements LaptopService {


    static List<Laptop> laptopArrayList = new ArrayList<>();
    static {
        Laptop laptop1 = new Laptop("MacBook Pro 14 M1 Max","Apple",87.9,"14.2 inch",
                "32GB","White","1TB");
        Laptop laptop2 = new Laptop("Apple Macbook Pro M1","Apple",38.5,"13.3 inch, Retina",
                "16GB","Black","256GB");
        Laptop laptop3 = new Laptop("Asus ROG Zephyrus","Asus",44.5,"14 inch, 2K, 120Hz",
                "16GB","White","1TB");
        Laptop laptop4 = new Laptop("Dell XPS 17 9710 i7 11800H","Dell",83,"17 inch, 4K",
                "16GB","Gray","1TB");
        laptopArrayList.add(laptop1);
        laptopArrayList.add(laptop3);
        laptopArrayList.add(laptop2);
        laptopArrayList.add(laptop4);
    }

    @Override
    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of new laptop");
        String nameLaptop = sc.nextLine();
        System.out.println("Input brand of new laptop");
        String brandLaptop = sc.nextLine();
        System.out.println("Input price of new laptop");
        double priceLaptop = Double.parseDouble(sc.nextLine());
        System.out.println("Input screen of new laptop");
        String screenLaptop = sc.nextLine();
        System.out.println("Input RAM of new laptop");
        String RAMLaptop = sc.nextLine();
        System.out.println("Input color of new laptop");
        String colorLaptop = sc.nextLine();
        System.out.println("Input SSD of new laptop");
        String cameraLaptop = sc.nextLine();
        laptopArrayList.add(new Laptop(nameLaptop,brandLaptop,priceLaptop,screenLaptop,RAMLaptop,colorLaptop,cameraLaptop));
        System.out.println("Add Successfully!!!");
    }

    @Override
    public void editProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of phone you wanna edit");
        String editNameLaptop = sc.nextLine();
        for (int i = 0; i < laptopArrayList.size(); i++) {
            if (laptopArrayList.get(i).getName().equals(editNameLaptop)){
                System.out.println("Input property you wanna edit:\n" +
                        "1.Edit name\n" +
                        "2.Edit brand\n" +
                        "3.Edit price\n" +
                        "4.Edit screen\n" +
                        "5.Edit RAM\n" +
                        "6.Edit color\n" +
                        "7.Edit SSD\n");
                int editPropertyPhoneChoice = Integer.parseInt(sc.nextLine());
                switch (editPropertyPhoneChoice) {
                    case 1:
                        System.out.println("Input your new name:");
                        laptopArrayList.get(i).setName(sc.nextLine());
                        System.out.println("Edit name successfully!!!");
                        break;
                    case 2:
                        System.out.println("Input your new brand:");
                        laptopArrayList.get(i).setBrand(sc.nextLine());
                        System.out.println("Edit brand successfully!!!");
                        break;
                    case 3:
                        System.out.println("Input your new price:");
                        laptopArrayList.get(i).setPrice(Integer.parseInt(sc.nextLine()));
                        System.out.println("Edit price successfully!!!");
                        break;
                    case 4:
                        System.out.println("Input your new screen:");
                        laptopArrayList.get(i).setScreen(sc.nextLine());
                        System.out.println("Edit screen successfully!!!");
                        break;
                    case 5:
                        System.out.println("Input your new RAM:");
                        laptopArrayList.get(i).setRAM(sc.nextLine());
                        System.out.println("Edit RAM successfully!!!");
                        break;
                    case 6:
                        System.out.println("Input your new color:");
                        laptopArrayList.get(i).setColor(sc.nextLine());
                        System.out.println("Edit color successfully!!!");
                        break;
                    case 7:
                        System.out.println("Input your SSD:");
                        laptopArrayList.get(i).setSSD(sc.nextLine());
                        System.out.println("Edit SSD successfully!!!");
                        break;
                }
            }
        }
    }

    @Override
    public void displayProduct() {
        for (Laptop laptop : laptopArrayList) {
            System.out.println(laptop);
        }
    }

    @Override
    public void deleteProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of laptop you wanna remove:");
        String deleteNameLaptop = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < laptopArrayList.size(); i++) {
            if (laptopArrayList.get(i).getName().equals(deleteNameLaptop)){
                System.out.println("Bạn đã xoá thành công laptop " + laptopArrayList.get(i).getName());
                laptopArrayList.remove(i);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Not Found!!!");
        }
    }

    @Override
    public void searchProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of laptop you wanna search:");
        String searchNameLaptop = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < laptopArrayList.size(); i++) {
            if (laptopArrayList.get(i).getName().toLowerCase().contains(searchNameLaptop.toLowerCase())){
                System.out.println(laptopArrayList.get(i).toString());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not Found!!!");
        }
    }

    @Override
    public void seachProductBySSD() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input SSD of laptop you wanna search:");
        String searchSSDLaptop = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < laptopArrayList.size(); i++) {
            if (laptopArrayList.get(i).getSSD().contains(searchSSDLaptop)){
                System.out.println(laptopArrayList.get(i).toString());
            }
        }
        if (!flag){
            System.out.println("Not Found!!!");
        }
    }

    @Override
    public void sortProductByPrice() {
        SortByPrice sortByPrice = new SortByPrice();
        Collections.sort(laptopArrayList,sortByPrice);
        System.out.println("Sort by Price Successfully!!!");
    }

    @Override
    public void sortProductByName() {
        SortByName sortByName = new SortByName();
        Collections.sort(laptopArrayList,sortByName);
        System.out.println("Sort by Name Successfully!!!");
    }
}

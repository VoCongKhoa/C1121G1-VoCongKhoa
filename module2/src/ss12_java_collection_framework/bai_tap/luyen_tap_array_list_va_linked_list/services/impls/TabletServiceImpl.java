package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls;

import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models.Tablet;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.TabletService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TabletServiceImpl implements TabletService {

    static List<Tablet> tabletArrayList = new ArrayList<>();
    static {
        Tablet tablet1 = new Tablet("iPad Pro M1","Apple",34.7,"12.9 inch",
                "8GB","Gold");
        Tablet tablet2 = new Tablet("Samsung Galaxy Tab S7 FE 4G","Samsung",14,"12.4 inch",
                "4GB","White");
        Tablet tablet3 = new Tablet("Samsung Galaxy Tab S7 FE WiFi","Samsung",13,"12.4 inch",
                "4GB","Black");
        Tablet tablet4 = new Tablet("iPad Air 4","Apple",21.7,"10.9 inch",
                "4GB","White");
        tabletArrayList.add(tablet1);
        tabletArrayList.add(tablet3);
        tabletArrayList.add(tablet2);
        tabletArrayList.add(tablet4);
    }
    @Override
    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of new tablet");
        String nameTablet = sc.nextLine();
        System.out.println("Input brand of new tablet");
        String brandTablet = sc.nextLine();
        System.out.println("Input price of new tablet");
        double priceTablet = Double.parseDouble(sc.nextLine());
        System.out.println("Input screen of new tablet");
        String screenTablet = sc.nextLine();
        System.out.println("Input RAM of new tablet");
        String RAMTablet = sc.nextLine();
        System.out.println("Input color of new tablet");
        String colorTablet = sc.nextLine();
        tabletArrayList.add(new Tablet(nameTablet,brandTablet,priceTablet,screenTablet,RAMTablet,colorTablet));
        System.out.println("Add successfully!!!");
    }

    @Override
    public void editProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of tablet you wanna edit");
        String editNameTablet = sc.nextLine();
        for (int i = 0; i < tabletArrayList.size(); i++) {
            if (tabletArrayList.get(i).getName().equals(editNameTablet)){
                System.out.println("Input property you wanna edit:\n" +
                        "1.Edit name\n" +
                        "2.Edit brand\n" +
                        "3.Edit price\n" +
                        "4.Edit screen\n" +
                        "5.Edit RAM\n" +
                        "6.Edit color\n");
                int editPropertyPhoneChoice = Integer.parseInt(sc.nextLine());
                switch (editPropertyPhoneChoice) {
                    case 1:
                        System.out.println("Input your new name:");
                        tabletArrayList.get(i).setName(sc.nextLine());
                        System.out.println("Edit name successfully!!!");
                        break;
                    case 2:
                        System.out.println("Input your new brand:");
                        tabletArrayList.get(i).setBrand(sc.nextLine());
                        System.out.println("Edit brand successfully!!!");
                        break;
                    case 3:
                        System.out.println("Input your new price:");
                        tabletArrayList.get(i).setPrice(Integer.parseInt(sc.nextLine()));
                        System.out.println("Edit price successfully!!!");
                        break;
                    case 4:
                        System.out.println("Input your new screen:");
                        tabletArrayList.get(i).setScreen(sc.nextLine());
                        System.out.println("Edit screen successfully!!!");
                        break;
                    case 5:
                        System.out.println("Input your new RAM:");
                        tabletArrayList.get(i).setRAM(sc.nextLine());
                        System.out.println("Edit RAM successfully!!!");
                        break;
                    case 6:
                        System.out.println("Input your new color:");
                        tabletArrayList.get(i).setColor(sc.nextLine());
                        System.out.println("Edit color successfully!!!");
                        break;
                }
            }
        }
    }

    @Override
    public void displayProduct() {
        for (Tablet tablet : tabletArrayList) {
            System.out.println(tablet);
        }
    }

    @Override
    public void deleteProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of tablet you wanna remove:");
        String deleteNameTablet = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < tabletArrayList.size(); i++) {
            if (tabletArrayList.get(i).getName().equals(deleteNameTablet)){
                System.out.println("Bạn đã xoá thành công tablet " + tabletArrayList.get(i).getName());
                tabletArrayList.remove(i);
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
        System.out.println("Input name of tablet you wanna search:");
        String searchNameTablet = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < tabletArrayList.size(); i++) {
            if (tabletArrayList.get(i).getName().toLowerCase().contains(searchNameTablet.toLowerCase())){
                System.out.println(tabletArrayList.get(i).toString());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not Found!!!");
        }
    }

    @Override
    public void sortProductByPrice() {
        SortByPrice sortByPrice = new SortByPrice();
        Collections.sort(tabletArrayList,sortByPrice);
        System.out.println("Sort by Price Successfully!!!");
    }

    @Override
    public void sortProductByName() {
        SortByPrice sortByName = new SortByPrice();
        Collections.sort(tabletArrayList,sortByName);
        System.out.println("Sort by Name Successfully!!!");
    }
}

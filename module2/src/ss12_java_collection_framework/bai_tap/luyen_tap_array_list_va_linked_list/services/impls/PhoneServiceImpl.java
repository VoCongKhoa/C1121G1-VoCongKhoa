package ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.impls;

import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.models.Phone;
import ss12_java_collection_framework.bai_tap.luyen_tap_array_list_va_linked_list.services.PhoneService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhoneServiceImpl implements PhoneService {

    static List<Phone> phoneArrayList = new ArrayList<>();
    static {
        Phone phone1 = new Phone("iPhone 13 Pro Max","Apple",32.5,"6.7\"",
                "6GB","Gold","12 MP","iPhone 13");
        Phone phone2 = new Phone("iPhone 12 Pro Max","Apple",32,"OLED 6.7\"",
                "6GB","Black","12 MP","iPhone 12");
        Phone phone3 = new Phone("Samsung Galaxy Z Fold3 5G","Samsung",42,"7.6\"",
                "12GB","White","10 MP","Galaxy Z");
        Phone phone4 = new Phone("Samsung Galaxy Z Fold2 5G","Samsung",30,"7.59\"\"",
                "12GB","Gray","10 MP","Galaxy Z");
        phoneArrayList.add(phone1);
        phoneArrayList.add(phone3);
        phoneArrayList.add(phone2);
        phoneArrayList.add(phone4);
    }

    @Override
    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of new phone");
        String namePhone = sc.nextLine();
        System.out.println("Input brand of new phone");
        String brandPhone = sc.nextLine();
        System.out.println("Input price of new phone");
        double pricePhone = Double.parseDouble(sc.nextLine());
        System.out.println("Input screen of new phone");
        String screenPhone = sc.nextLine();
        System.out.println("Input RAM of new phone");
        String RAMPhone = sc.nextLine();
        System.out.println("Input color of new phone");
        String colorPhone = sc.nextLine();
        System.out.println("Input camera of new phone");
        String cameraPhone = sc.nextLine();
        System.out.println("Input type of new phone");
        String typePhone = sc.nextLine();
        phoneArrayList.add(new Phone(namePhone,brandPhone,pricePhone,screenPhone,RAMPhone,colorPhone,cameraPhone,typePhone));
        System.out.println("Add Successfully!!!");
    }

    @Override
    public void editProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of phone you wanna edit");
        String editNamePhone = sc.nextLine();
        for (int i = 0; i < phoneArrayList.size(); i++) {
            if (phoneArrayList.get(i).getName().equals(editNamePhone)){
                System.out.println("Input property you wanna edit:\n" +
                        "1.Edit name\n" +
                        "2.Edit brand\n" +
                        "3.Edit price\n" +
                        "4.Edit screen\n" +
                        "5.Edit RAM\n" +
                        "6.Edit color\n" +
                        "7.Edit camera\n" +
                        "8.Edit type\n");
                int editPropertyPhoneChoice = Integer.parseInt(sc.nextLine());
                switch (editPropertyPhoneChoice) {
                    case 1:
                        System.out.println("Input your new name:");
                        phoneArrayList.get(i).setName(sc.nextLine());
                        System.out.println("Edit name successfully!!!");
                        break;
                    case 2:
                        System.out.println("Input your new brand:");
                        phoneArrayList.get(i).setBrand(sc.nextLine());
                        System.out.println("Edit brand successfully!!!");
                        break;
                    case 3:
                        System.out.println("Input your new price:");
                        phoneArrayList.get(i).setPrice(Integer.parseInt(sc.nextLine()));
                        System.out.println("Edit price successfully!!!");
                        break;
                    case 4:
                        System.out.println("Input your new screen:");
                        phoneArrayList.get(i).setScreen(sc.nextLine());
                        System.out.println("Edit screen successfully!!!");
                        break;
                    case 5:
                        System.out.println("Input your new RAM:");
                        phoneArrayList.get(i).setRAM(sc.nextLine());
                        System.out.println("Edit RAM successfully!!!");
                        break;
                    case 6:
                        System.out.println("Input your new color:");
                        phoneArrayList.get(i).setColor(sc.nextLine());
                        System.out.println("Edit color successfully!!!");
                        break;
                    case 7:
                        System.out.println("Input your camera:");
                        phoneArrayList.get(i).setCamera(sc.nextLine());
                        System.out.println("Edit camera successfully!!!");
                        break;
                    case 8:
                        System.out.println("Input your new type:");
                        phoneArrayList.get(i).setType(sc.nextLine());
                        System.out.println("Edit type successfully!!!");
                        break;
                }
            }
        }
    }

    @Override
    public void displayProduct() {
        for (Phone phone : phoneArrayList) {
            System.out.println(phone);
        }
    }

    @Override
    public void deleteProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name of phone you wanna remove:");
        String deleteNamePhone = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < phoneArrayList.size(); i++) {
            if (phoneArrayList.get(i).getName().equals(deleteNamePhone)){
                System.out.println("B???n ???? xo?? th??nh c??ng ??i???n tho???i " + phoneArrayList.get(i).getName());
                flag = true;
                phoneArrayList.remove(i);
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
        System.out.println("Input name of phone you wanna search:");
        String searchNamePhone = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < phoneArrayList.size(); i++) {
            if (phoneArrayList.get(i).getName().toLowerCase().contains(searchNamePhone.toLowerCase())){
                System.out.println(phoneArrayList.get(i).toString());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!!!");
        }
    }

    @Override
    public void seachProductByType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input type of phone you wanna search:");
        String searchTypePhone = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i < phoneArrayList.size(); i++) {
            if (phoneArrayList.get(i).getType().toLowerCase().contains(searchTypePhone.toLowerCase())){
                System.out.println(phoneArrayList.get(i).toString());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!!!");
        }
    }

    @Override
    public void sortProductByPrice() {
        Collections.sort(phoneArrayList,new SortByPrice()); //ArrayList v?? List => ?????u c?? th??? d??ng tr???c ti???p ph????ng th???c sort??
        System.out.println("Sort by Price Successfully!!!");
    }

    @Override
    public void sortProductByName() {
        Collections.sort(phoneArrayList,new SortByName());
        System.out.println("Sort by Name Successfully!!!");
    }
}

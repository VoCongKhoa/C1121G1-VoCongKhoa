package ss17_binary_file_and_serialization.bai_tap.quan_ly_san_pham_file_nhi_phan;

import ss17_binary_file_and_serialization.ReadAndWriteBinaryFile;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    final String PRODUCT_PATH_FILE = "src/ss17_binary_file_and_serialization/bai_tap/quan_ly_san_pham_file_nhi_phan/Product.dat";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product(1,"iPhone 13 Pro Max","iPhone",32.5,"Good"));
//        productList.add(new Product(2,"iPhone 12 Pro Max","iPhone",32,"Good"));
//        productList.add(new Product(3,"Samsung Galaxy Z Fold3 5G","Samsung",42,"Excellent"));
//        productList.add(new Product(4,"Samsung Galaxy Z Fold2 5G","Samsung",30,"Perfect"));

//        ReadAndWriteBinaryFile.writeToBinaryFile("src/ss17_binary_file_and_serialization/bai_tap/quan_ly_san_pham_file_nhi_phan/Product.txt",
//                productList);
//        productList = ReadAndWriteBinaryFile.readBinaryFile("src/ss17_binary_file_and_serialization/bai_tap/quan_ly_san_pham_file_nhi_phan/Product.txt");
//        for (Product product: productList) {
//            System.out.println(product);
//        }
        int flag = -1;
        while (flag != 4) {
            System.out.println("Product management:");
            System.out.println("1. Add new product:");
            System.out.println("2. Show product list:");
            System.out.println("3. Search product by name:");
            System.out.println("4. Exit");
            System.out.print("Choice a number: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.showAll();
                    break;
                case 3:
                    productManager.search();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number!");
            }
        }
    }

    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input product ID: ");
        int productID = Integer.parseInt(sc.nextLine());
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input brand: ");
        String brand = sc.nextLine();
        System.out.print("Input price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Input other information: ");
        String otherInfor = sc.nextLine();

        List<Product> productList = ReadAndWriteBinaryFile.readBinaryFile(PRODUCT_PATH_FILE);
        productList.add(new Product(productID,name,brand,price,otherInfor));
        ReadAndWriteBinaryFile.writeToBinaryFile(PRODUCT_PATH_FILE,productList);
        for (Product product:productList) {
            System.out.println(product);
        }
        System.out.println("Add product successfully!!");
    }

    public void showAll(){
        List<Product> showProductList = ReadAndWriteBinaryFile.readBinaryFile(PRODUCT_PATH_FILE);
        if (showProductList.isEmpty()){
            System.out.println("There're no product!!!");
        }else {
            for (Product product:showProductList) {
                System.out.println(product);
            }
        }
    }

    public void search(){
        Scanner sc = new Scanner(System.in);
        List<Product> editProductList = ReadAndWriteBinaryFile.readBinaryFile(PRODUCT_PATH_FILE);
        System.out.println("Input name of product you wanna search:");
        String editName = sc.nextLine();
        for (Product product:editProductList) {
            if (product.getName().toLowerCase().contains(editName.toLowerCase())){
                System.out.println(product);
            }
        }
    }



}

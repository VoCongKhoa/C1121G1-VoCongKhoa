package ss17_binary_file_and_serialization.bai_tap.quan_ly_san_pham_file_nhi_phan;

import java.io.*;
import java.util.List;

public class ReadAndWriteBinaryFile {
    public static void writeToBinaryFile(String pathFile, List<Product> productList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile,true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readBinaryFile(String pathFile){
        List<Product> productList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            for (Product product: productList) {
//                product = (Product) objectInputStream.readObject();
//            }
            productList = (List<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

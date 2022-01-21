package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFile(String pathFile){
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }

    public static void writeFile(String pathFile,String line){
        try {
            FileWriter fileWriter = new FileWriter(pathFile,true); // append = true: có thể sửa file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine(); // Để xuống hàng
            bufferedWriter.close(); // Phải close để lưu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ss16_text_file.thuc_hanh.find_max_value;

import common.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMax {
    public static void main(String[] args) {
        List<String> numberStringList = FileUtils.readFile(
                "E:\\codegym\\module2\\src\\ss16_text_file\\thuc_hanh\\find_max_value\\NumbersArray.txt");
        List<Integer> numberIntegerList = new ArrayList<>();
        for (String numberString : numberStringList) {
            numberIntegerList.add(Integer.parseInt(numberString));
        }
        int maxNumber = findMax(numberIntegerList);
        FileUtils.writeFile(
                "E:\\codegym\\module2\\src\\ss16_text_file\\thuc_hanh\\find_max_value\\NumbersArray.txt",
                "Max number is: " + maxNumber);

        //In ra kết quả trong console
        String resultString;
        try {
            FileReader fileReader = new FileReader(
                    "E:\\codegym\\module2\\src\\ss16_text_file\\thuc_hanh\\find_max_value\\NumbersArray.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((resultString = bufferedReader.readLine()) != null){
                System.out.println(resultString);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int findMax(List<Integer> integerList) {
        int maxNumber = 0;
        for (Integer number: integerList) {
            if (number>maxNumber){
                maxNumber = number;
            }
        }
        return maxNumber;
    }
}

package FuramaResort.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> readFile(String pathFile){
        List<String> stringList = new ArrayList<>();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringList;
    }

    public static void writeFile(String pathFile, List<String> stringList){
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
            try {
                fileWriter = new FileWriter(pathFile);
                bufferedWriter = new BufferedWriter(fileWriter);
                for (String string: stringList) {
                    bufferedWriter.write(string);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

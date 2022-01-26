package ss16_text_file.bai_tap.read_file;

import common.FileUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        final String PATH_FILE =  "E:\\codegym\\module2\\src\\ss16_text_file\\bai_tap\\read_file\\CSV.txt";
//        List<String> lineList = FileUtils.readFile(PATH_FILE);
//        System.out.println(lineList);
//        List<Country> countryList = new ArrayList<>();
//        String[] splitLineList;
//        for (String line: lineList) {
//            splitLineList = line.split(",");
//            countryList.add(new Country(Integer.parseInt(splitLineList[0]),splitLineList[1],splitLineList[2]));
//        }
//        for (Country country: countryList) {
//            System.out.println(country);
//        }

        try {
            FileReader fileReader = new FileReader(PATH_FILE); //Đường dẫn tương đối
            int character;
            String temp = "";
            while ((character = fileReader.read()) != -1) {
                temp += (char)character; //Ép kiểu tường minh
            }
            System.out.println(temp);
//       => temp = "haitt,19\ntrungdp,16
            List<Country> countryList = new ArrayList<>();
            String[] stringList = temp.split("\n");
            System.out.println(Arrays.toString(stringList));
            System.out.println(stringList.length);
//       => strings = {"haitt,19","trungdp,16"}
            for(int i =0; i<stringList.length; i++) {
                String[] strings1 = stringList[i].split(",");
                Country country = new Country();
                country.setId(Integer.parseInt(strings1[0]));
                country.setCode(strings1[1]);
                country.setName(strings1[2]);
                countryList.add(country);
            }
            for(Country country: countryList) {
                System.out.println(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }







//        Country country = new Country(9,"VN","VietNam");
//
//        FileUtils.writeFile(PATH_FILE,country.getStringToFileCSV());
//        lineList = FileUtils.readFile(PATH_FILE);
//        System.out.println(lineList);
    }
}

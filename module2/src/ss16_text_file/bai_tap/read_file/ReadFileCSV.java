package ss16_text_file.bai_tap.read_file;

import common.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        List<String> lineList = FileUtils.readFile(
                "E:\\codegym\\module2\\src\\ss16_text_file\\bai_tap\\read_file\\CSV.txt");
        List<Country> countryList = new ArrayList<>();
        String[] splitLineList;
        for (String line: lineList) {
            splitLineList = line.split(",");
            countryList.add(new Country(Integer.parseInt(splitLineList[0]),splitLineList[1],splitLineList[2]));
        }
        for (Country country: countryList) {
            System.out.println(country);
        }
    }
}

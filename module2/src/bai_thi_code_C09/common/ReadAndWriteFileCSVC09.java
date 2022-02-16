package bai_thi_code_C09.common;

import bai_thi_code_C09.models.DienThoai;
import bai_thi_code_C09.models.DienThoaiChinhHang;
import bai_thi_code_C09.models.DienThoaiXachTay;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWriteFileCSVC09 {
    public static List<String> readFileCSVToStringList(String pathFile) {
        List<String> stringList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringList;
    }

    public static void writeStringListIntoCSVFile(String pathFile, List<String> stringList, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<DienThoai> convertStringListToDienThoaiList(List<String> stringList) {
        List<DienThoai> dienThoaiList = new ArrayList<>();
        String[] stringSplitArray;
        DienThoai.setDemDienThoai(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray[6].equals("Toan Quoc") || stringSplitArray[6].equals("Quoc Te")) {
                DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(stringSplitArray[1],
                        Double.parseDouble(stringSplitArray[2]), Integer.parseInt(stringSplitArray[3]), stringSplitArray[4],
                        Integer.parseInt(stringSplitArray[5]), stringSplitArray[6]);
                dienThoaiChinhHang.setIdDienThoai(Integer.parseInt(stringSplitArray[0]));
                dienThoaiList.add(dienThoaiChinhHang);
            } else {
                DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(stringSplitArray[1],
                        Double.parseDouble(stringSplitArray[2]), Integer.parseInt(stringSplitArray[3]), stringSplitArray[4],
                        stringSplitArray[5], stringSplitArray[6]);
                dienThoaiXachTay.setIdDienThoai(Integer.parseInt(stringSplitArray[0]));
                dienThoaiList.add(dienThoaiXachTay);
            }
        }
        return dienThoaiList;
    }

    public static List<String> convertDienThoaiListToStringList(List<DienThoai> dienThoaiList) {
        List<String> stringList = new ArrayList<>();
        for (DienThoai dienThoai : dienThoaiList) {
            if (dienThoai instanceof DienThoaiChinhHang){
                stringList.add(((DienThoaiChinhHang)dienThoai).toStringToFileCSV());
            } else {
                stringList.add(((DienThoaiXachTay)dienThoai).toStringToFileCSV());
            }
        }
        return stringList;
    }
}


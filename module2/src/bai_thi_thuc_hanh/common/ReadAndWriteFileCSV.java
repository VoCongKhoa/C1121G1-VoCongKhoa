package bai_thi_thuc_hanh.common;

import bai_thi_thuc_hanh.models.BenhAn;
import bai_thi_thuc_hanh.models.BenhAnBenhNhanThuong;
import bai_thi_thuc_hanh.models.BenhAnBenhNhanVIP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSV {
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

    public static List<BenhAn> convertStringListToBenhAnList(List<String> stringList) {
        List<BenhAn> benhAnList = new ArrayList<>();
        String[] stringSplitArray;
        BenhAn.setSoLuongBenhAn(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray.length == 9) {
                BenhAnBenhNhanVIP benhAnBenhNhanVIP = new BenhAnBenhNhanVIP(stringSplitArray[1], stringSplitArray[2],
                        stringSplitArray[3], stringSplitArray[4], stringSplitArray[5],
                        stringSplitArray[6], stringSplitArray[7], stringSplitArray[8]);
                benhAnBenhNhanVIP.setSoThuTu(Integer.parseInt(stringSplitArray[0]));
                benhAnList.add(benhAnBenhNhanVIP);
            } else {
                BenhAnBenhNhanThuong benhAnBenhNhanThuong = new BenhAnBenhNhanThuong(stringSplitArray[1], stringSplitArray[2],
                        stringSplitArray[3], stringSplitArray[4], stringSplitArray[5],
                        stringSplitArray[6], Double.parseDouble(stringSplitArray[7]));
                benhAnBenhNhanThuong.setSoThuTu(Integer.parseInt(stringSplitArray[0]));
                benhAnList.add(benhAnBenhNhanThuong);
            }
        }
        return benhAnList;
    }

    public static List<String> convertBenhAnListToStringList(List<BenhAn> benhAnList) {
        List<String> stringList = new ArrayList<>();
        for (BenhAn benhAn : benhAnList) {
            stringList.add(benhAn.toStringToCSVFile());
        }
        return stringList;
    }
}

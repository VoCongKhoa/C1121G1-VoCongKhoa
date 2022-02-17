package bai_thi_code_C08.common;

import bai_thi_code_C08.models.TaiKhoan;
import bai_thi_code_C08.models.TaiKhoanThanhToan;
import bai_thi_code_C08.models.TaiKhoanTietKiem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCSVC08 {
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

    public static List<TaiKhoan> convertStringListToTaiKhoanList(List<String> stringList) {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();
        String[] stringSplitArray;
        TaiKhoan.setDemTaiKhoan(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray.length == 8) {
                TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(stringSplitArray[1], stringSplitArray[2], stringSplitArray[3],
                        Double.parseDouble(stringSplitArray[4]), stringSplitArray[5], Integer.parseInt(stringSplitArray[6]),
                        Integer.parseInt(stringSplitArray[7]));
                taiKhoanTietKiem.setIdTaiKhoan(Integer.parseInt(stringSplitArray[0]));
                taiKhoanList.add(taiKhoanTietKiem);
            } else {
                TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(stringSplitArray[1], stringSplitArray[2],
                        stringSplitArray[3], stringSplitArray[4], Double.parseDouble(stringSplitArray[5]));
                taiKhoanThanhToan.setIdTaiKhoan(Integer.parseInt(stringSplitArray[0]));
                taiKhoanList.add(taiKhoanThanhToan);
            }
        }
        return taiKhoanList;
    }

    public static List<String> convertTaiKhoanListToStringList(List<TaiKhoan> taiKhoanList) {
        List<String> stringList = new ArrayList<>();
        for (TaiKhoan taiKhoan : taiKhoanList) {
            if (taiKhoan instanceof TaiKhoanTietKiem) {
                stringList.add(((TaiKhoanTietKiem) taiKhoan).toStringToCSVFile());
            } else {
                stringList.add(((TaiKhoanThanhToan) taiKhoan).toStringToCSVFile());
            }
        }
        return stringList;
    }
}

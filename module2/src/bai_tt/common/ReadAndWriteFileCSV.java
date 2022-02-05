package bai_tt.common;

import bai_tt.models.SanPham;
import bai_tt.models.SanPhamNhapKhau;
import bai_tt.models.SanPhamXuatKhau;

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

    public static List<SanPham> convertStringListToSanPhamList(List<String> stringList) {
        List<SanPham> sanPhamList = new ArrayList<>();
        String[] stringSplitArray;
        SanPham.setSoSanPham(1);
        for (String string : stringList) {
            stringSplitArray = string.split(",");
            if (stringSplitArray.length == 9) {
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(stringSplitArray[1], stringSplitArray[2],
                        Double.parseDouble(stringSplitArray[3]), Integer.parseInt(stringSplitArray[4]), stringSplitArray[5],
                        Double.parseDouble(stringSplitArray[6]), stringSplitArray[7], Double.parseDouble(stringSplitArray[8]));
                sanPhamNhapKhau.setIdSanPham(Integer.parseInt(stringSplitArray[0]));
                sanPhamList.add(sanPhamNhapKhau);
            } else {
                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(stringSplitArray[1], stringSplitArray[2],
                        Double.parseDouble(stringSplitArray[3]), Integer.parseInt(stringSplitArray[4]), stringSplitArray[5],
                        Double.parseDouble(stringSplitArray[6]), stringSplitArray[7]);
                sanPhamXuatKhau.setIdSanPham(Integer.parseInt(stringSplitArray[0]));
                sanPhamList.add(sanPhamXuatKhau);
            }
        }
        return sanPhamList;
    }

    public static List<String> convertSanPhamListToStringList(List<SanPham> sanPhamList) {
        List<String> stringList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            stringList.add(sanPham.toStringToFileCSV());
        }
        return stringList;
    }
}

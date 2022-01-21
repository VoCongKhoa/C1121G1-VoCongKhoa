package bai_tap_cuoi_tuan.utils;

import bai_tap_cuoi_tuan.models.HangSanXuat;
import bai_tap_cuoi_tuan.models.Oto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile <E> {

    //Đọc file CSV thành 1 List chứa các đối tượng Oto
    public static  List<Oto> readOtoFileToCSV(String pathFileOto, String pathFileHangSanXuat) {
        List<Oto> otoList = null;
        List<HangSanXuat> hangSanXuatList = readHangSanXuatFileToCSV(pathFileHangSanXuat);
        HangSanXuat hangSanXuat = null;
        try {
            File file = new File(pathFileOto);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String[] splitLineList;
            FileReader fileReader = new FileReader(pathFileOto);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                splitLineList = line.split(",");
                for (HangSanXuat hangSX : hangSanXuatList) {
                    if (hangSX.getTenHangSanXuat().equals(splitLineList[1])) {
                        hangSanXuat = hangSX;
                        break;
                    }
                }
                otoList.add(new Oto(splitLineList[0],hangSanXuat, Integer.parseInt(splitLineList[2]),
                            splitLineList[3],Integer.parseInt(splitLineList[4]),splitLineList[5]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return otoList;
    }

    public static List<HangSanXuat> readHangSanXuatFileToCSV(String pathFile) {
        List<HangSanXuat> hangSanXuatList = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String[] splitLineList;
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                splitLineList = line.split(",");
                hangSanXuatList.add(new HangSanXuat(splitLineList[0],splitLineList[1], splitLineList[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hangSanXuatList;
    }

    public static void writeOtoFileToCSV(String pathFile, Oto oto,boolean append) {
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(pathFile,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(oto.getInforToCSVFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeHangSanXuatFileToCSV(String pathFile, HangSanXuat hangSanXuat,boolean append) {
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(pathFile,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(hangSanXuat.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package ss16_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        copyFileText("E:\\codegym\\module2\\src\\ss16_text_file\\bai_tap\\copy_file_text\\OriginalFile.txt",
                "E:\\codegym\\module2\\src\\ss16_text_file\\bai_tap\\copy_file_text\\CloneFile.txt");
    }
    public static void copyFileText(String pathOriginalFile, String pathCloneFile){
        FileReader fileReader;
        FileWriter fileWriter;
        String line;
        {
            try {
                fileReader = new FileReader(pathOriginalFile);
                fileWriter = new FileWriter(pathCloneFile,false);
                BufferedReader bufferedReader = new BufferedReader(fileReader); //bộ nhớ tạm
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                while ((line = bufferedReader.readLine())!= null){
                    bufferedWriter.write(line); //Cộng chuỗi không được trong vòng while???
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

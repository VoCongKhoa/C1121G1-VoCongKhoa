package ss16_text_file.thuc_hanh.sum_of_numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CalculateSumOfNumbersInFileText {
    public static void main(String[] args) {
        readFileText("E:\\codegym\\module2\\src\\ss16_text_file\\thuc_hanh\\sum_of_numbers\\Numbers.txt");
    }
    public static void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            if (!file.exists()) {
                //TH file không tồn tại
                throw new FileNotFoundException();
            }

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int sumNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sumNumber += Integer.parseInt(line);
            }
            bufferedReader.close();
            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sumNumber);
        } catch (NumberFormatException e) {
            //TH nhập chữ sai
            System.out.println("Lỗi định dạng số! Bạn phải nhập số");
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại hoặc nội dung có lỗi!");
        }
    }
}

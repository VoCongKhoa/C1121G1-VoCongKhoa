package ss17_binary_file_and_serialization.bai_tap.copy_file_nhi_phan;

import ss17_binary_file_and_serialization.ReadAndWriteBinaryFile;

import java.io.*;

public class CopyBinaryFile implements Serializable {
    static final String PATH_SOURCE_FILE = "src/ss17_binary_file_and_serialization/bai_tap/copy_file_nhi_phan/SourceFile.dat";
    static final String PATH_TARGET_FILE = "src/ss17_binary_file_and_serialization/bai_tap/copy_file_nhi_phan/TargetFile.dat";

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(PATH_SOURCE_FILE);
            outputStream = new FileOutputStream(PATH_TARGET_FILE);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            File sourceFile = new File(PATH_SOURCE_FILE);
            System.out.println(sourceFile.length());
            File targetFile = new File(PATH_TARGET_FILE);
            System.out.println(targetFile.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

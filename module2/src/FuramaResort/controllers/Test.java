package FuramaResort.controllers;

import FuramaResort.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//public class Test {
//    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[-/ ]((0[1-9]|1[012])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))[-/ ](\\d{4})$";
//    public static boolean validateDate(String date) {
//        boolean resultValid = false;
//        if (date.matches(DATE_REGEX)) {
//            try {
//                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//
//                //Nếu nó set là true (Mặc định nếu bạn dùng parse là SimpleDateFormat thì nó là true) thì
//                //bạn input date string là 31/2/2019
//                // -> nó sẽ tự động hiểu là 3 ngày sau ngày 28/2/2019 -> thành ra 3/3/2019
//                //Trong trường hợp này bạn sẽ muốn nó bắn về lỗi => setLenient là false
//                formatter1.setLenient(false);
//                //throws ParseException in case of invalid date
//                formatter1.parse(date);
//                resultValid = true;
//            } catch (ParseException ignored) {
//            } finally {
//                if (!resultValid){
//                    try {
//                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
//                        formatter2.setLenient(false);
//                        formatter2.parse(date);
//                        resultValid = true;
//                    } catch (ParseException ignored) {
//                    } finally {
//                        if (!resultValid){
//                            try {
//                                SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MMM-yyyy");
//                                formatter3.setLenient(false);
//                                formatter3.parse(date);
//                                resultValid = true;
//                            } catch (ParseException ignored) {
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//        if (!resultValid){
//            System.out.println("Invalid format!!! Input again!");
//        }
//        return resultValid;
//    }
//    public static void main(String[] args) {
//        Validation validation = new Validation();
//        Scanner sc = new Scanner(System.in);
//        boolean check = false;
//        while (!check){
//            System.out.println("Input date:");
//            String date = sc.nextLine();
//            check = validateDate(date);
//        }
//        System.out.println("ok!");
//    }
//}

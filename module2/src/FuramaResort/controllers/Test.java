package FuramaResort.controllers;

import FuramaResort.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[-/ ]((0[1-9]|1[012])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))[-/ ](\\d{4})$";

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Validation validation = new Validation();
//        System.out.print("Input start date:");//Dùng regrex DoB
//        String startDate;
//        LocalDate startDateParse = null;
//        boolean checkStartDate = false;
//        while (true) {
//            System.out.println("0");
//            if (validateDate(startDate = sc.nextLine())) {
//                System.out.println("1");
//                try {
//                    startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                    checkStartDate = true;
//                } catch (DateTimeParseException ignored) {
//                } finally {
//                    if (!checkStartDate) {
//                        try {
//                            startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//                            checkStartDate = true;
//                        } catch (DateTimeParseException ignored) {
//                        } finally {
//                            if (!checkStartDate) {
//                                try {
//                                    startDateParse = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
//                                    checkStartDate = true;
//                                } catch (DateTimeParseException ignored) {
//                                }
//                            }
//                        }
//                    }
//                }
//                break;
//            } else {
//                System.out.println("Wrong format!!! Input again!");
//            }
//        }
//
//        System.out.print("Input end date:");
//        String endDate = null;
//        LocalDate endDateParse;
//        boolean checkEndDate = false;
//        while (!checkEndDate) {
//            if (validateDate(endDate = sc.nextLine())) {
//                try {
//                    endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                    if (endDateParse.isAfter(startDateParse)){
//                        checkEndDate = true;
//                    }
//                } catch (DateTimeParseException ignored) {
//                } finally {
//                    if (!checkEndDate) {
//                        try {
//                            endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//                            if (endDateParse.isAfter(startDateParse)){
//                                checkEndDate = true;
//                            }
//                        } catch (DateTimeParseException ignored) {
//                        } finally {
//                            if (!checkEndDate) {
//                                try {
//                                    endDateParse = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
//                                    if (endDateParse.isAfter(startDateParse)){
//                                        checkEndDate = true;
//                                    }
//                                } catch (DateTimeParseException ignored) {
//                                }
//                            }
//                        }
//                    }
//                }
//                if (!checkEndDate){
//                    System.out.println("End date of booking have to be after start date booking! Input again!");
//                }
//            }
//        }
//    }
//    public static boolean validateDate(String bookingDate) {
//        bookingDate = bookingDate.trim();
//        LocalDate today = LocalDate.now();
//        boolean resultValid = false;
//        boolean checkFebruary = false;
//        boolean checkAfterToday = false;
//        if (bookingDate.matches(DATE_REGEX)) {
//            try {
//                LocalDate bookingDateParse = LocalDate.parse(bookingDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0,2));
//                int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
//                if (dayOfBookingDate == dayOfBookingDateParse){
//                    if (bookingDateParse.isAfter(today)) {
//                        resultValid = true;
//                    } else {
//                        checkAfterToday = true;
//                    }
//
//                } else {
//                    checkFebruary = true;
//                }
//            } catch (DateTimeParseException ignored) {
//            } finally {
//                if (!resultValid){
//                    try {
//                        LocalDate bookingDateParse = LocalDate.parse(bookingDate,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//                        int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0,2));
//                        int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
//                        if (dayOfBookingDate == dayOfBookingDateParse){
//                            if (bookingDateParse.isAfter(today)) {
//                                resultValid = true;
//                            } else {
//                                checkAfterToday = true;
//                            }
//
//                        } else {
//                            checkFebruary = true;
//                        }
//                    } catch (DateTimeParseException ignored) {
//                    } finally {
//                        if (!resultValid){
//                            try {
//                                LocalDate bookingDateParse = LocalDate.parse(bookingDate,DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
//                                int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0,2));
//                                int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
//                                if (dayOfBookingDate == dayOfBookingDateParse){
//                                    if (bookingDateParse.isAfter(today)) {
//                                        resultValid = true;
//                                    } else {
//                                        checkAfterToday = true;
//                                    }
//                                } else {
//                                    checkFebruary = true;
//                                }
//                            } catch (DateTimeParseException ignored) {
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        if (checkAfterToday){
//            System.out.println("Booking date have to after today! Input again!");
//        }
//        if (checkFebruary){
//            System.out.println("You input wrong days of February! Input again!");
//        }
//        return resultValid;
//    }

    public static void main(String[] args) {
        Stack<Integer> abc = new Stack<>();
        abc.push(0);
        abc.push(5);
        abc.push(4);
        abc.push(0);
        abc.push(2);
        abc.push(1);
        abc.push(3);
        abc.push(-9);

        System.out.println(abc);
    }
}

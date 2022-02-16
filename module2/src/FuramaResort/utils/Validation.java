package FuramaResort.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private Pattern pattern;
    private Matcher matcher;

    private static final String VILLA_ID_SERVICE_REGEX = "^SVVL-\\d{4}$";
    private static final String HOUSE_ID_SERVICE_REGEX = "^SVHO-\\d{4}$";
    private static final String ROOM_ID_SERVICE_REGEX = "^SVRO-\\d{4}$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String RENT_TYPE_REGEX = "^Day|Month|Year|day|month|year$";
    //    private static final String RENT_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String VILLA_TYPE_REGEX = "^Luxury|Unique|luxury|unique$";
    //    private static final String VILLA_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String HOUSE_TYPE_REGEX = "^Superior|Standard|superior|standard$";
    //    private static final String HOUSE_TYPE_REGEX = "^[A-Z](\\w\\s?)+$";
    private static final String NAME_REGEX = "^[A-Za-z](\\w\\s?)+$";
    private static final String GENDER_REGEX = "^Male|Female$";
    private static final String ID_NUMBER_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^\\(\\+\\d{2}\\)(\\s?\\d){9,12}$";
    private static final String EMAIL_REGEX = "^[\\w]+@\\w+(\\.\\w+)+$";
    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[-/ ]((0[1-9]|1[012])|(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))[-/ ](\\d{4})$";
    //    private static final String DATE_REGEX = "^((([012][0-9]|30)[\\-\\|\\/](01|03|05|07|08|10|12))|(([012][0-9]|31)[\\-\\|\\/](04|06|09|11))|(([012][0-9][\\-\\|\\/]02)))[\\-\\|\\/](\\d{4})$";

    //Cách 1:
//    public boolean validateVillaIDService(String villaIDService){
//        matcher = Pattern.compile(VILLA_ID_SERVICE_REGEX).matcher(villaIDService);
//        return matcher.matches();
//    }

    //Cách 2:
//    public boolean validateVillaIDService(String villaIDService){
//        return villaIDService.matches(VILLA_ID_SERVICE_REGEX);
//    }

    //Cách 3:
    public boolean validateVillaIDService(String villaIDService) {
        return Pattern.matches(VILLA_ID_SERVICE_REGEX, villaIDService.trim());
    }

    public boolean validateHouseIDService(String houseIDService) {
        return Pattern.matches(HOUSE_ID_SERVICE_REGEX, houseIDService.trim());
    }

    public boolean validateRoomIDService(String roomIDService) {
        return Pattern.matches(ROOM_ID_SERVICE_REGEX, roomIDService.trim());
    }

    public boolean validateServiceName(String serviceName) {
        return Pattern.matches(SERVICE_NAME_REGEX, serviceName.trim());
    }

    public boolean validateRentType(String rentType) {
        return Pattern.matches(RENT_TYPE_REGEX, rentType.trim());
    }

    public boolean validateVillaType(String villaType) {
        return Pattern.matches(VILLA_TYPE_REGEX, villaType.trim());
    }

    public boolean validateHouseType(String houseType) {
        return Pattern.matches(HOUSE_TYPE_REGEX, houseType.trim());
    }

    public boolean validateName(String name) {
        return Pattern.matches(NAME_REGEX, name.trim());
    }

    public boolean validateGender(String gender) {
        return Pattern.matches(GENDER_REGEX, gender.trim());
    }

    public boolean validateIDNumber(String IDNumber) {
        return Pattern.matches(ID_NUMBER_REGEX, IDNumber.trim());
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber.trim());
    }

    public boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email.trim());
    }

    public boolean validateDate(String date) {
        date = date.trim();
        boolean resultValid = false;
        if (date.matches(DATE_REGEX)) {
            try {
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

                //Nếu set formatter1.setLenient là true (Mặc định nếu bạn dùng parse là SimpleDateFormat thì nó là true) thì
                //bạn input date string là 31/2/2019
                // -> nó sẽ tự động hiểu là 3 ngày sau ngày 28/2/2019 -> thành ra 3/3/2019
                //Trong trường hợp này bạn sẽ muốn nó bắn về lỗi => setLenient là false
                formatter1.setLenient(false);
                //throws ParseException in case of invalid date
                formatter1.parse(date);
                resultValid = true;
            } catch (ParseException ignored) {
            } finally {
                if (!resultValid) {
                    try {
                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
                        formatter2.setLenient(false);
                        formatter2.parse(date);
                        resultValid = true;
                    } catch (ParseException ignored) {
                    } finally {
                        if (!resultValid) {
                            try {
                                SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MMM-yyyy");
                                formatter3.setLenient(false);
                                formatter3.parse(date);
                                resultValid = true;
                            } catch (ParseException ignored) {
                            }
                        }
                    }
                }
            }
        }
        return resultValid;
    }

    public boolean validateDateOfBooking(String bookingDate) {
        bookingDate = bookingDate.trim();
        LocalDate today = LocalDate.now();
        boolean resultValid = false;
        boolean checkFebruary = false;
        boolean checkAfterToday = false;
        if (bookingDate.matches(DATE_REGEX)) {
            try {
                LocalDate bookingDateParse = LocalDate.parse(bookingDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0, 2));
                int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
                if (dayOfBookingDate == dayOfBookingDateParse) {
                    if (bookingDateParse.equals(today) || bookingDateParse.isAfter(today)) {
                        resultValid = true;
                    } else {
                        checkAfterToday = true;
                    }

                } else {
                    checkFebruary = true;
                }
            } catch (DateTimeParseException ignored) {
            } finally {
                if (!resultValid) {
                    try {
                        LocalDate bookingDateParse = LocalDate.parse(bookingDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0, 2));
                        int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
                        if (dayOfBookingDate == dayOfBookingDateParse) {
                            if (bookingDateParse.equals(today) || bookingDateParse.isAfter(today)) {
                                resultValid = true;
                            } else {
                                checkAfterToday = true;
                            }

                        } else {
                            checkFebruary = true;
                        }
                    } catch (DateTimeParseException ignored) {
                    } finally {
                        if (!resultValid) {
                            try {
                                LocalDate bookingDateParse = LocalDate.parse(bookingDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
                                int dayOfBookingDate = Integer.parseInt(bookingDate.substring(0, 2));
                                int dayOfBookingDateParse = bookingDateParse.getDayOfMonth();
                                if (dayOfBookingDate == dayOfBookingDateParse) {
                                    if (bookingDateParse.equals(today) || bookingDateParse.isAfter(today)) {
                                        resultValid = true;
                                    } else {
                                        checkAfterToday = true;
                                    }
                                } else {
                                    checkFebruary = true;
                                }
                            } catch (DateTimeParseException ignored) {
                            }
                        }
                    }
                }
            }
        }
        if (checkAfterToday) {
            System.out.println("Booking date have to be equal or after today!");
        }
        if (checkFebruary) {
            System.out.println("You input wrong days of February!");
        }
        return resultValid;
    }

    public String resultNameAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);//Bắt buộc bắt đầu bằng chữ
            if (validateName(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

    public String resultDateOfBirthAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            if (validateDate(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

    public String resultGenderAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            if (validateGender(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

    public String resultIDNumberAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            if (validateIDNumber(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

    public String resultPhoneNumberAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            if (validatePhoneNumber(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

    public String resultEmailAfterValidate(String text){
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            System.out.print(text);
            if (validateEmail(result = sc.nextLine())) {
                break;
            } else {
                System.out.println("Wrong format!!! Input again!");
            }
        }
        return result;
    }

}

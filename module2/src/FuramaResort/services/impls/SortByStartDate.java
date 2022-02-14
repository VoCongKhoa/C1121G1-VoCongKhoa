package FuramaResort.services.impls;

import FuramaResort.models.Booking;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.*;

public class SortByStartDate implements Comparator<Booking> {

//    String stringDate1 = "22/01/2016";
//    String stringDate2 = "22-Jan-2016";
//    String stringDate3 = "01 22, 2016";
//    String stringDate4 = "Fri, Jan 22 2016";
//    String stringDate5 = "Fri, Jan 22 2016 23:37:50";
//    String stringDate6 = "22-Jan-2016 23:37:50";
//    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//    SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
//    SimpleDateFormat formatter3 = new SimpleDateFormat("MM dd, yyyy");
//    SimpleDateFormat formatter4 = new SimpleDateFormat("E, MMM dd yyyy");
//    SimpleDateFormat formatter5 = new SimpleDateFormat(
//            "E, MMM dd yyyy HH:mm:ss");
//    SimpleDateFormat formatter6 = new SimpleDateFormat(
//            "dd-MMM-yyyy HH:mm:ss");
//    Date date1 = formatter1.parse(stringDate1);
//    Date date2 = formatter2.parse(stringDate2);
//    Date date3 = formatter3.parse(stringDate3);
//    Date date4 = formatter4.parse(stringDate4);
//    Date date5 = formatter5.parse(stringDate5);
//    Date date6 = formatter6.parse(stringDate6);
//		System.out.println(stringDate1 + "\t" + date1);
//		System.out.println(stringDate2 + "\t" + date2);
//		System.out.println(stringDate3 + "\t" + date3);
//		System.out.println(stringDate4 + "\t" + date4);
//		System.out.println(stringDate5 + "\t" + date5);
//		System.out.println(stringDate6 + "\t" + date6);
    @Override
    public int compare(Booking o1, Booking o2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate1;
        Date endDate1;
        Date startDate2;
        Date endDate2;
        int returnNumber = 0;
        try {
            startDate1 = formatter.parse(o1.getStartDate());
            endDate1 = formatter.parse(o1.getEndDate());
            startDate2 = formatter.parse(o2.getStartDate());
            endDate2 = formatter.parse(o2.getEndDate());
            if (startDate1.getTime() == startDate2.getTime()) {
                if (endDate1.before(endDate2)) {
                    returnNumber =  -1;
                } else if (endDate2.before(endDate1)) {
                    returnNumber =  1;
                } else {
                    returnNumber = o1.getBookingNumber() - o2.getBookingNumber();
                    // Dùng TreeSet cẩn thận thêm phương thức compare() của Comparator, vì nếu dùng Set không thôi, thì
                    // Set chỉ override lại equals và hashcode để xoá phần tử trùng lặp,
                    // Còn dùng TreeSet thì sau khi override lại equals và hashcode để xoá phần tử trùng lặp, nó sẽ dùng
                    // phương thức compare() để sort lại, vì vậy ta phải code lại phương thức compare sao cho phù hợp
                }
            } else if (startDate1.before(startDate2)) {
                returnNumber =  -1;
            } else {
                returnNumber =  1;
            }
        } catch (ParseException e) {
        }
        return returnNumber;
    }
}

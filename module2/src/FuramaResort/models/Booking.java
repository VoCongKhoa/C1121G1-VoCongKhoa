package FuramaResort.models;

import java.util.Date;

import static FuramaResort.models.Customer.*;
import static FuramaResort.models.Facility.*;

public class Booking {
    private static int bookingNumber;
    private String startDate;
    private String endDate;

    public Booking() {
    }

    public Booking(int bookingNumber, String startDate, String endDate,int cusId, String serviceName, String rentType) {
        this.bookingNumber = bookingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        setCusId(cusId);
        setServiceName(serviceName);
        setRentType(rentType);
    }

    public static int getBookingNumber() {
        return bookingNumber;
    }

    public static void setBookingNumber(int bookingNumber) {
        Booking.bookingNumber = bookingNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber = '" + bookingNumber + '\'' +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", cusId = " + getCusId() +
                ", serviceName = " + getServiceName() +
                ", rentType = " + getRentType() +
                '}';
    }
}
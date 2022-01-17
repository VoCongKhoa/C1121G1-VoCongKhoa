package FuramaResort.models;

import java.util.Objects;

import static FuramaResort.models.Customer.*;
import static FuramaResort.models.Facility.*;

public class Booking {
    private int bookingNumber;
    private String startDate;
    private String endDate;

    public Booking() {
    }

    public Booking(int bookingNumber, String startDate, String endDate,int id, String serviceName, String rentType) {
        this.bookingNumber = bookingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        setNumberOfCustomer(id);
//        setServiceName(serviceName);
//        setRentType(rentType);
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        bookingNumber = bookingNumber;
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
                ", cusId = " + getNumberOfCustomer() +
                ", serviceName = " + "FAILED" +
                ", rentType = " + "FAILED" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingNumber, booking.bookingNumber) && Objects.equals(startDate, booking.startDate)
                && Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}

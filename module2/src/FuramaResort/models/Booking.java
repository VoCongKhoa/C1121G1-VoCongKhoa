package FuramaResort.models;

import java.util.Objects;

public class Booking {
    private static int numberOfBooking; //Tự động tăng booking number
    private int bookingNumber;
    private String startDate;
    private String endDate;
    private Facility facility; //Để lấy serviceName
    private Customer customer;

    public Booking() {
    }

    public Booking(String startDate, String endDate) {
        this.bookingNumber = numberOfBooking++ + 10;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(String startDate, String endDate, Customer customer, Facility facility) {
        this.bookingNumber = numberOfBooking++ + 10;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facility;
    }

    public static int getNumberOfBooking() {
        return numberOfBooking;
    }

    public static void setNumberOfBooking(int numberOfBooking) {
        Booking.numberOfBooking = numberOfBooking;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
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

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber = '" + getBookingNumber() + '\'' +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", customerId = " + customer.getCustomerId() +
                ", serviceName = " + facility.getServiceName() +
                ", rentType = " + facility.getRentType() +
                '}';
    }


    //Bug ghi đè mặc dù khác Id, hay khác serviceName hay khác rentType
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate)
                && (this.getCustomer().getCustomerId() == booking.getCustomer().getCustomerId())
                && Objects.equals(this.getFacility().getServiceName(), booking.getFacility().getServiceName())
                && Objects.equals(this.getFacility().getRentType(), booking.getFacility().getRentType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    public String toStringToCSVFile() {
        return getBookingNumber() + "," + startDate + "," + endDate + "," + customer.getCustomerId()
                + "," + facility.getServiceName() + "," + facility.getRentType();
    }
}

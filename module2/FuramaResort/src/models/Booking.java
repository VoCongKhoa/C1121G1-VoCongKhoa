package models;

import java.util.Date;

public class Booking {
    private int bookingNumber;
    private Date startDate;
    private Date endDate;

    public Booking() {
    }

    public Booking(int bookingNumber, Date startDate, Date endDate) {
        this.bookingNumber = bookingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}

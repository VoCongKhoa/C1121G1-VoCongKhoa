package FuramaResort.services.impls;

import FuramaResort.models.Booking;
import FuramaResort.services.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static private Set<Booking> bookingQueue = new TreeSet<>(new SortByStartDate());

    static {
        Booking booking1 = new Booking(123, "01/01/2022", "7/1/2022",
                3, "bookingVilla", "day");
        Booking booking2 = new Booking(124, "04/01/2022", "7/1/2022",
                3, "bookingHouse", "day");
        Booking booking3 = new Booking(125, "01/01/2022", "6/1/2022",
                3, "bookingRoom", "day");
        Booking booking4 = new Booking(126, "03/01/2022", "7/1/2022",
                3, "bookingRoom", "day");
        Booking booking5 = new Booking(127, "01/01/2022", "8/1/2022",
                3, "bookingRoom", "day");
        Booking booking6 = new Booking(127, "01/01/2022", "7/1/2022",
                3, "bookingRoom", "day");
        Booking booking7 = new Booking(127, "01/01/2022", "8/1/2022",
                3, "bookingRoom", "day");

        bookingQueue.add(booking1);
        bookingQueue.add(booking2);
        bookingQueue.add(booking3);
        bookingQueue.add(booking4);
        bookingQueue.add(booking5);
        bookingQueue.add(booking6);
        bookingQueue.add(booking7);
    }

    @Override
    public void addBooking() {
        System.out.println("addBooking");

    }

    //Booking number bị sai
    @Override
    public void displayBooking() {
        for (Booking booking: bookingQueue ) {
            System.out.println(booking);
        }
    }

    @Override
    public void createNewContract() {
        System.out.println("createNewContract");

    }

    @Override
    public void displayContract() {
        System.out.println("displayContract");

    }

    @Override
    public void editContract() {
        System.out.println("editContract");

    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

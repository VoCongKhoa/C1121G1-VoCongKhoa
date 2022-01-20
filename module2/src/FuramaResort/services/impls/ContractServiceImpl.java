package FuramaResort.services.impls;

import FuramaResort.models.Booking;
import FuramaResort.services.ContractService;

import java.util.Scanner;

public class ContractServiceImpl implements ContractService {

    @Override
    public void displayCustomerUseService() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number of year:");
        String yearBooking = sc.nextLine();
        boolean flag = false;
        for (Booking booking : BookingServiceImpl.bookingQueue) {
            if (booking.getStartDate().contains(yearBooking) || booking.getEndDate().contains(yearBooking)) {
                System.out.println(booking);
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Not found!!!");
        }
    }

    @Override
    public void displayCustomerGetVoucher() {
        System.out.println("displayCusGetVoucher");

    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

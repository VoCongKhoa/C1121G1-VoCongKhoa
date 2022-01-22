package FuramaResort.services.impls;

import FuramaResort.models.Booking;
import FuramaResort.services.ContractService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
        if (!flag) {
            System.out.println("Not found!!!");
        }
    }

    @Override
    public void displayCustomerGetVoucher() {
        Scanner sc = new Scanner(System.in);
        Stack<Booking> bookingStack = new Stack<>();
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String year = String.valueOf(localDate.getYear());
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        for (Booking booking : BookingServiceImpl.bookingTreeSet) {
            if (booking.getStartDate().contains(year) || booking.getEndDate().contains(year)) {
                if (Integer.parseInt(booking.getStartDate().substring(3, 5)) == month
                        || Integer.parseInt(booking.getEndDate().substring(3, 5)) == month) {
                    bookingStack.push(booking);
                }
            }
        }
        System.out.println(bookingStack);
        System.out.println("Number of booking of this month(" + month + ") is: " + bookingStack.size());
        System.out.print("Input number of 10% voucher: ");
        int voucher10 = Integer.parseInt(sc.nextLine());
        System.out.print("Input number of 20% voucher: ");
        int voucher20 = Integer.parseInt(sc.nextLine());
        System.out.print("Input number of 50% voucher: ");
        int voucher50 = Integer.parseInt(sc.nextLine());

        Map<String, Integer> voucherTreeMap = new TreeMap<>();
        voucherTreeMap.put("voucher10", voucher10);
        voucherTreeMap.put("voucher20", voucher20);
        voucherTreeMap.put("voucher50", voucher50);
        System.out.println(voucherTreeMap);

        for (Booking bookingGetVoucher : bookingStack) {
            if (voucherTreeMap.get("voucher10") > 0) {
                System.out.println(bookingGetVoucher + " get voucher 10%!!!");
                voucherTreeMap.put("voucher10", voucherTreeMap.get("voucher10") - 1);
            } else if (voucherTreeMap.get("voucher20") > 0) {
                System.out.println(bookingGetVoucher + " get voucher 20%!!!");
                voucherTreeMap.put("voucher20", voucherTreeMap.get("voucher20") - 1);
            } else if (voucherTreeMap.get("voucher50") > 0) {
                System.out.println(bookingGetVoucher + " get voucher 50%!!!");
                voucherTreeMap.put("voucher50", voucherTreeMap.get("voucher50") - 1);
            } else {
                System.out.println("Run out of voucher!!!");
                break;
            }
        }

    }

    @Override
    public void returnMainMenu() {
        System.out.println("returnMainMenu");

    }
}

package FuramaResort.models;

import static FuramaResort.models.Booking.*;
import static FuramaResort.models.Customer.*;

public class Contract {
    private static int numberOfContract; //Tự động tăng contract Number
    private int contractNumber;
    private double contractDeposit;
    private double contractSum;
    private Booking booking;

    public Contract() {
    }

    public Contract(double contractDeposit, double contractSum, Booking booking) {
        this.contractNumber = numberOfContract++ +100;
        this.contractDeposit = contractDeposit;
        this.contractSum = contractSum;
        this.booking = booking;

    }

    public static int getNumberOfContract() {
        return numberOfContract;
    }

    public static void setNumberOfContract(int numberOfContract) {
        Contract.numberOfContract = numberOfContract;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractSum() {
        return contractSum;
    }

    public void setContractSum(double contractSum) {
        this.contractSum = contractSum;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber = '" + getContractNumber() + '\'' +
                ", bookingNumber = " + getBooking().getBookingNumber() +
                ", contractDeposit = " + contractDeposit +
                ", contractSum = " + contractSum +
                ", customerId = " + getBooking().getCustomer().getId() +
                '}';
    }
}

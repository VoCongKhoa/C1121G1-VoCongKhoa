package FuramaResort.models;

import static FuramaResort.models.Booking.*;
import static FuramaResort.models.Customer.*;

public class Contract {
    private int contractNumber;
    private double contractDeposit;
    private double contractSum;

    public Contract() {
    }

    public Contract(int contractNumber, double contractDeposit, double contractSum, int bookingNumber, int cusId) {
        this.contractNumber = contractNumber;
        this.contractDeposit = contractDeposit;
        this.contractSum = contractSum;
        setBookingNumber(bookingNumber);
        setNumberOfCustomer(cusId);
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

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber = '" + contractNumber + '\'' +
                ", bookingNumber = " + getBookingNumber() +
                ", contractDeposit = " + contractDeposit +
                ", contractSum = " + contractSum +
                ", cusId = " + getNumberOfCustomer() +
                '}';
    }
}

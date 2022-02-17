package FuramaResort.models;


import java.util.Objects;

public class Customer extends Person {
    private static int numberOfCustomer; // Tự động tăng Customer id
    private String customerRank;
    private String customerAddress;
    private int customerId;

    public Customer() {
        this.customerId = this.numberOfCustomer++ + 1; //Bắt đầu từ 1
    }

    public Customer(String customerRank, String customerAddress) {
        this.customerId = this.numberOfCustomer++ + 1; //Bắt đầu từ 1
        this.customerRank = customerRank;
        this.customerAddress = customerAddress;
    }

    public Customer(String name, String dateOfBirth, String gender, String IDNumber, String phoneNumber,
                    String email, String customerRank, String customerAddress) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.customerId = this.numberOfCustomer++ +1;
        this.customerRank = customerRank;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public static int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public static void setNumberOfCustomer(int numberOfCustomer) {
        Customer.numberOfCustomer = numberOfCustomer;
    }

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId = '" + getCustomerId() + '\'' +
                ", name = " + getName()+
                ", dateOfBirth = " + getDateOfBirth()+
                ", gender = " + getGender()+
                ", idNumber = " + getIDNumber()+
                ", phoneNumber = " + getPhoneNumber()+
                ", email = " + getEmail()+
                ", customerRank = " + customerRank +
                ", customerAdress = " + customerAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return this.customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerRank, customerAddress, customerId);
    }

    public String toStringToCSVFile() {
        return getCustomerId() + "," + getName() + "," + getDateOfBirth() + "," + getGender() + "," + getIDNumber() + "," +
                getPhoneNumber() + "," + getEmail() + "," + customerRank + "," + customerAddress;
    }
}

package FuramaResort.models;


public class Customer extends Person {
    private static int numberOfCustomer; // Tự động tăng Customer id
    private String customerRank;
    private String customerAddress;
    private int id;

    public Customer() {
    }

    public Customer(String customerRank, String customerAddress) {
        this.id = this.numberOfCustomer++ + 1; //Bắt đầu từ 1
        this.customerRank = customerRank;
        this.customerAddress = customerAddress;
    }

    public Customer(String name, String dateOfBirth, String gender, String IDNumber, String phoneNumber,
                    String email, String customerRank, String customerAddress) {
        super(name, dateOfBirth, gender, IDNumber, phoneNumber, email);
        this.id = this.numberOfCustomer++ +1;
        this.customerRank = customerRank;
        this.customerAddress = customerAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "customerId = '" + getId() + '\'' +
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
}

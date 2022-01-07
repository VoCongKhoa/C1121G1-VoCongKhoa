package FuramaResort.models;


public class Customer extends Person {
    private static int numberOfCustomer;
    private String cusRank;
    private String cusAddress;
    private int id;

    public Customer() {
    }

    public Customer(String cusRank, String cusAddress) {
        this.id = this.numberOfCustomer++ + 1;
        this.cusRank = cusRank;
        this.cusAddress = cusAddress;
    }

    public Customer(String name, String dateOfBirth, String gender, String idNumber, String phoneNumber,
                    String email, String cusRank, String cusAddress) {
        super(name, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.id = this.numberOfCustomer++ + 1;
        this.cusRank = cusRank;
        this.cusAddress = cusAddress;
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

    public String getCusRank() {
        return cusRank;
    }

    public void setCusRank(String cusRank) {
        this.cusRank = cusRank;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId = '" + numberOfCustomer + '\'' +
                ", name = " + getName()+
                ", dateOfBirth = " + getDateOfBirth()+
                ", gender = " + getGender()+
                ", idNumber = " + getIdNumber()+
                ", phoneNumber = " + getPhoneNumber()+
                ", email = " + getEmail()+
                ", cusRank = " + cusRank+
                ", cusAdress = " + cusAddress+
                '}';
    }
}

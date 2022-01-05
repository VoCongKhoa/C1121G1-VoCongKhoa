package FuramaResort.models;


public class Customer extends Person {
    private static int cusId;
    private String cusRank;
    private String cusAddress;

    public Customer() {
    }

    public Customer(int cusId, String cusRank, String cusAddress) {
        this.cusId = cusId;
        this.cusRank = cusRank;
        this.cusAddress = cusAddress;
    }

    public Customer(String name, int age, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, int cusId, String cusRank, String cusAddress) {
        super(name, age, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.cusId = cusId;
        this.cusRank = cusRank;
        this.cusAddress = cusAddress;
    }

    public static int getCusId() {
        return cusId;
    }

    public static void setCusId(int cusId) {
        Customer.cusId = cusId;
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
                "cusId = '" + cusId + '\'' +
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

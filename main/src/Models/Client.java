package Models;



import java.util.Date;

public class Client{
    protected int id ;
    protected String userName;
    protected String password;
    protected String dob ;
    protected String address;
    protected long phone;
    protected long citizenIdentification; //cccd

    public Client() {
    }

    public Client(int id, String userName, String password, String dob, String address, long phone, long citizenIdentification) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.citizenIdentification = citizenIdentification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(long citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }
}

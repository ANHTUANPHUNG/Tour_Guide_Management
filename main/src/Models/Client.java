package Models;



import eNum.EGender;
import eNum.ELevel;

import java.util.Date;

public class Client{
    private int id ;
    private String userName;
    private String password;
    private String name;
    private String dob ;
    private String address;
    private long phone;
    private EGender gender;
    private String level;
    private long citizenIdentification; //cccd
    private ELevel typeAccount;

    public Client() {
    }

    public Client(int id, String name, String dob, String address, long phone, EGender gender, String level, long citizenIdentification, ELevel typeAccount) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.level = level;
        this.citizenIdentification = citizenIdentification;
        this.typeAccount = typeAccount;
    }

    public Client(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(long citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    public ELevel getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(ELevel typeAccount) {
        this.typeAccount = typeAccount;
    }
}

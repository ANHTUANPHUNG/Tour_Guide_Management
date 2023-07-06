package Body;

import eNum.eRole;

import javax.management.relation.Role;

import java.util.Date;

public abstract class User {
    protected int id;
    protected String userName;
    protected String passWord;
    protected Date dob;
    protected String address;
    protected  long phone;
    protected String gender;
    protected String level;
    protected long citizenIdentification;

    public User() {
    }

    public User(int id, String userName, String passWord, Date dob, String address, long phone, String gender, String level, long citizenIdentification) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.level = level;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
}

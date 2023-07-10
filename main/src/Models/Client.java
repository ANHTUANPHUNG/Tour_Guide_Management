package Models;



import eNum.EGender;
import eNum.ELevel;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String dob;
    private String address;
    private String phone;
    private EGender gender;


    public Client() {
    }

    public Client(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Client(int id, String userName, String password, String name, String dob, String address, String phone, EGender gender) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

}

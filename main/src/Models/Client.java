package Models;


import eNum.EGender;
import eNum.ELevel;
import utils.SerializationUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import static service.ClientSV.clientList;
import static service.FeedBackSV.feedBackList;

public class Client implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String name;
    private LocalDate dob;
    private String address;
    private String phone;
    private EGender gender;


    public Client() {
    }

    public Client(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Client(int id, String userName, String password, String name, LocalDate dob, String address, String phone, EGender gender) {
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
        saveClient();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        saveClient();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        saveClient();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        saveClient();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
        saveClient();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        saveClient();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        saveClient();
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
        saveClient();
    }

    private void saveClient() {
        SerializationUtil.serialize(clientList, "Client.txt");
    }

}

package Models;

import Body.User;

import java.util.Date;

public class Admin extends User {
    private String manager;
    public Admin() {
    }

    public Admin(int id, String userName, String passWord, Date dob, String address, long phone, String gender, String level, long citizenIdentification, String manager) {
        super(id, userName, passWord, dob, address, phone, gender, level, citizenIdentification);
        this.manager= manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}

package Models;

import Body.User;

import java.util.Date;

public class Client extends User {
    private String typeOfAccount;
    public Client() {
    }

    public Client(int id, String userName, String passWord, Date dob, String address, long phone, String gender, String level, long citizenIdentification,String typeOfAccount) {
        super(id, userName, passWord, dob, address, phone, gender, level, citizenIdentification);
        this.typeOfAccount= typeOfAccount;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }
}

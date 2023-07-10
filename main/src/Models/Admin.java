package Models;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Admin implements Serializable {
    private String userName;
    private String passWord;


    public Admin() {

    }

    public Admin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public  String getUserName() {
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
}

package Models;

import eNum.EGender;
import eNum.EStatusGuide;
import utils.SerializationUtil;

import java.io.Serializable;
import java.util.List;

import static service.GuideSV.guideList;


public class Guide implements Serializable {
    private int idGuide;
    private String userName;
    private String passWord;
    private String name;
    private String age;
    private String address;
    private String phone;
    private List<String> skill;
    private EGender eGender;
    private EStatusGuide eStatusGuide;
    private List<String> feedBack;
    private double rate;
    private List<String> hastag;
    private double price;


    public Guide() {
    }

    public Guide(int idGuide, String userName, String passWord, String name, String age, String address, String phone, List<String> skill, EGender eGender, EStatusGuide eStatusGuide, List<String> feedBack, double rate, List<String> hastag, double price) {
        this.idGuide = idGuide;
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.skill = skill;
        this.eGender = eGender;
        this.eStatusGuide = eStatusGuide;
        this.feedBack = feedBack;
        this.rate = rate;
        this.hastag = hastag;
        this.price = price;
    }

    public Guide(int idGuide, String name, String age, String address, String phone, List<String> skill, EGender eGender, EStatusGuide eStatusGuide, List<String> feedBack, double rate, List<String> hastag, double price) {
        this.idGuide = idGuide;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.skill = skill;
        this.eGender = eGender;
        this.eStatusGuide = eStatusGuide;
        this.feedBack = feedBack;
        this.rate = rate;
        this.hastag = hastag;
        this.price = price;
    }

    public Guide(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
        saveGuide();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        saveGuide();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        saveGuide();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        saveGuide();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        saveGuide();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        saveGuide();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        saveGuide();
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
        saveGuide();
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
        saveGuide();
    }

    public EStatusGuide geteStatusGuide() {
        return eStatusGuide;
    }

    public void seteStatusGuide(EStatusGuide eStatusGuide) {
        this.eStatusGuide = eStatusGuide;
        saveGuide();
    }

    public List<String> getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(List<String> feedBack) {
        this.feedBack = feedBack;
        saveGuide();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        saveGuide();
    }

    public List<String> getHastag() {
        return hastag;
    }

    public void setHastag(List<String> hastag) {
        this.hastag = hastag;
        saveGuide();
    }

    public double getPrice() {
        return price;

    }

    public void setPrice(double price) {
        this.price = price;
        saveGuide();
    }

    private void saveGuide() {
        SerializationUtil.serialize(guideList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }
}

package Models;

import eNum.EGender;
import utils.SerializationUtil;

import java.io.Serializable;
import java.util.List;

import static service.GuideService.guideList;

public class Guide implements Serializable {
    private int idGuide;
    private String userName;
    private String passWord;
    private String name;
    private String age;
    private String address;
    private long phone;
    private List<String> skill;
    private EGender eGender;
    private String status;
    private List<String> feedBack;
    private double rate;
    private List<String> hastag;


    public Guide() {
    }

    public Guide(int idGuide, String name, String age, String address, long phone, List<String> skill, EGender eGender, String status, List<String> feedBack, double rate, List<String> hastag) {
        this.idGuide = idGuide;

        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.skill = skill;
        this.eGender = eGender;
        this.status = status;
        this.feedBack = feedBack;
        this.rate = rate;
        this.hastag = hastag;
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
        save();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        save();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        save();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        save();
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
        save();
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
        save();
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
        save();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        save();
    }

    public List<String> getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(List<String> feedBack) {
        this.feedBack = feedBack;
        save();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        save();
    }

    public List<String> getHastag() {
        return hastag;
    }

    public void setHastag(List<String> hastag) {
        this.hastag = hastag;
        save();
    }

    private void save() {
        SerializationUtil.serialize(guideList, "guide.txt");
    }

    @Override
    public String toString() {
        return "Guide{" +
                "idGuide=" + idGuide +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", skill=" + skill +
                ", eGender=" + eGender +
                ", status='" + status + '\'' +
                ", feedBack=" + feedBack +
                ", rate=" + rate +
                ", hastag=" + hastag +
                '}';
    }
}

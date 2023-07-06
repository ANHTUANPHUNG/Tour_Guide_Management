package Models;

import eNum.EGender;

import java.io.Serializable;

public class Guide implements Serializable {
    private int idGuide;
    private String name;
    private String description;
    private EGender eGender;

    public Guide() {
    }

    public Guide(int idGuide, String name, String description, EGender eGender) {
        this.idGuide = idGuide;
        this.name = name;
        this.description = description;
        this.eGender=eGender;

    }

    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
    }
}

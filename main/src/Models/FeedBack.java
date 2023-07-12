package Models;

import utils.SerializationUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.PrimitiveIterator;

import static service.FeedBackSV.feedBackList;
import static service.GuideSV.guideList;

public class FeedBack implements Serializable {
    private int id;
    private String idClient;
    private LocalDate invoiceDate;
    private int idGuide;
    private String nameGuide;
    private String feedback;
    private double rate;

    public FeedBack() {
    }

    public FeedBack(int id, String idClient, LocalDate invoiceDate, int idGuide, String nameGuide, String feedback, double rate) {
        this.id = id;
        this.idClient = idClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.nameGuide = nameGuide;
        this.feedback = feedback;
        this.rate = rate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        saveFeedBack();

    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
        saveFeedBack();

    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
        saveFeedBack();

    }

    public int getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(int idGuide) {
        this.idGuide = idGuide;
        saveFeedBack();

    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
        saveFeedBack();

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        saveFeedBack();

    }

    public String getNameGuide() {
        return nameGuide;
    }

    public void setNameGuide(String nameGuide) {
        this.nameGuide = nameGuide;
        saveFeedBack();
    }

    private void saveFeedBack() {
        SerializationUtil.serialize(feedBackList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\FeedBack.txt");
    }

}

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
    private String nameClient;
    private LocalDate invoiceDate;
    private int idGuide;
    private String nameGuide;
    private String feedback;
    private int rate;

    public FeedBack() {
    }

    public FeedBack(int id, String nameClient, LocalDate invoiceDate, int idGuide, String nameGuide, String feedback, int rate) {
        this.id = id;
        this.nameClient = nameClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.nameGuide = nameGuide;
        this.feedback = feedback;
        this.rate = rate;
    }

    public FeedBack(int id, String idClient, String nameClient, LocalDate invoiceDate, int idGuide, String nameGuide, String feedback, int rate) {
        this.id = id;
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.nameGuide = nameGuide;
        this.feedback = feedback;
        this.rate = rate;
    }

    public FeedBack(int id, String idClient, LocalDate invoiceDate, int idGuide, String feedback, int rate) {
        this.id = id;
        this.idClient = idClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.feedback = feedback;
        this.rate = rate;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
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
        SerializationUtil.serialize(feedBackList, "FeedBack.txt");
    }

}

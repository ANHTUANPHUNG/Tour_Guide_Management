package Models;

import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private int id;
    private String idClient;
    private Date invoiceDate;
    private String idGuide;
    private LocalDate starDate;
    private LocalDate  endDate;
    private double price;
    private String note;
    private double total;

    public Bill() {
    }

    public Bill(int id, String idClient, Date invoiceDate, String idGuide, LocalDate starDate, LocalDate endDate, double price, String note, double total) {
        this.id = id;
        this.idClient = idClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.starDate = starDate;
        this.endDate = endDate;
        this.price = price;
        this.note = note;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getIdGuide() {
        return idGuide;
    }

    public void setIdGuide(String idGuide) {
        this.idGuide = idGuide;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

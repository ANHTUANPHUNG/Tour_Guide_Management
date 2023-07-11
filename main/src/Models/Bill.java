package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Bill implements Serializable {
    private int idBill;
    private String idClient;
    private LocalDate invoiceDate;
    private String idGuide;
    private LocalDate starDate;
    private LocalDate  endDate;
    private double price;
    private String note;
    private double total;
    private String status;

    public Bill() {
    }

    public Bill(int idBill, String idClient, LocalDate invoiceDate, String idGuide, LocalDate starDate, LocalDate endDate, String note, String status, double price, double total) {
        this.idBill = idBill;
        this.idClient = idClient;
        this.invoiceDate = invoiceDate;
        this.idGuide = idGuide;
        this.starDate = starDate;
        this.endDate = endDate;
        this.price = price;
        this.note = note;
        this.total = total;
        this.status = status;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int id) {
        this.idBill = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

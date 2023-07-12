package Models;

import eNum.EStatusBill;
import utils.SerializationUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import static service.BillSV.billList;
import static service.ClientSV.clientList;

public class Bill implements Serializable {
    private int idBill;
    private String NameClient;
    private LocalDate invoiceDate;
    private String NameGuide;
    private LocalDate starDate;
    private LocalDate endDate;
    private double price;
    private String note;
    private double total;
    private EStatusBill eStatusBill;

    public Bill() {
    }

    public Bill(int idBill, String NameClient, LocalDate invoiceDate, String NameGuide, LocalDate starDate, LocalDate endDate, String note, EStatusBill eStatusBill, double price, double total) {
        this.idBill = idBill;
        this.NameClient = NameClient;
        this.invoiceDate = invoiceDate;
        this.NameGuide = NameGuide;
        this.starDate = starDate;
        this.endDate = endDate;
        this.price = price;
        this.note = note;
        this.total = total;
        this.eStatusBill = eStatusBill;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int id) {
        this.idBill = id;
        saveBill();
    }

    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String NameClient) {
        this.NameClient = NameClient;
        saveBill();
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
        saveBill();
    }

    public String getNameGuide() {
        return NameGuide;
    }

    public void setNameGuide(String NameGuide) {
        this.NameGuide = NameGuide;
        saveBill();
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
        saveBill();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        saveBill();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        saveBill();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
        saveBill();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
        saveBill();
    }

    public EStatusBill getStatus() {
        return eStatusBill;
    }

    public void setStatus(EStatusBill eStatusBill) {
        this.eStatusBill = eStatusBill;
        saveBill();
    }

    private void saveBill() {
        SerializationUtil.serialize(billList, "Bill.txt");
    }
}

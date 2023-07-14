package Models;

import eNum.EStatusBill;
import service.BillSV;
import utils.SerializationUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static service.BillSV.billList;
import static service.ClientSV.clientList;

public class Bill implements Serializable {
    private int idBill;
    private String nameClient;
    private LocalDate invoiceDate;
    private String userGuide;
    private String nameGuide;
    private LocalDate starDate;
    private LocalDate endDate;
    private double price;
    private String note;
    private double total;
    private EStatusBill eStatusBill;
    private double salary;

    public Bill() {
    }

//    public Bill(int idBill, String nameClient, LocalDate invoiceDate, String userGuide, String nameGuide, LocalDate starDate, LocalDate endDate, double price) {
//        this.idBill = idBill;
//        this.nameClient = nameClient;
//        this.invoiceDate = invoiceDate;
//        this.userGuide = userGuide;
//        this.nameGuide = nameGuide;
//        this.starDate = starDate;
//        this.endDate = endDate;
//        this.price = price;
//        this.note = note;
//        this.total = total;
//        this.salary = salary;
//    }

    public Bill(int idBill, String NameClient, LocalDate invoiceDate, String userGuide, String NameGuide, LocalDate starDate, LocalDate endDate, String note, EStatusBill eStatusBill, double price) {
        this.idBill = idBill;
        this.nameClient = NameClient;
        this.invoiceDate = invoiceDate;
        this.userGuide = userGuide;
        this.nameGuide = NameGuide;
        this.starDate = starDate;
        this.endDate = endDate;
        this.price = price;
        this.note = note;
        this.total = price * (ChronoUnit.DAYS.between(starDate, endDate) + 1);
        this.eStatusBill = eStatusBill;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUserGuide() {
        return userGuide;
    }

    public void setUserGuide(String userGuide) {
        this.userGuide = userGuide;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int id) {
        this.idBill = id;
        saveBill();
    }

    public String getNameClient() {
        return nameClient;
    }

    public EStatusBill geteStatusBill() {
        return eStatusBill;
    }

    public void seteStatusBill(EStatusBill eStatusBill) {
        this.eStatusBill = eStatusBill;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
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
        return nameGuide;
    }

    public void setNameGuide(String nameGuide) {
        this.nameGuide = nameGuide;
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

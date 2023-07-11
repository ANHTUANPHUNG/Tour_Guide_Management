package service;

import Models.Bill;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import utils.AppUltis;
import utils.InitBill;
import utils.InitGuide;
import utils.SerializationUtil;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.time.Period;
>>>>>>> 3d342bd0a88d133efd8d0e6542c7e6569d377a76
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import static service.ClientSV.clientList;
import static utils.AppUltis.getString;

import static utils.getValue.getString;

public class BillSV implements CRUD<Bill> {
    public static List<Bill> billList = (List<Bill>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Bill.txt");

    public static void displayBill() {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n", "ID", "Client", "Invoice Date", "Guide", "Star Date", "End Date", "Note", "Status", "Price", "Total");
        for (Bill bill : billList) {
            System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n",
                    bill.getIdBill(), bill.getIdClient(), bill.getInvoiceDate(), bill.getIdGuide(),
                    bill.getStarDate(), bill.getEndDate(), bill.getNote(), bill.getStatus(), bill.getPrice(), bill.getTotal());
        }
        System.out.println("===========================================================================================================================================================\n\n");
    }

    @Override
    public Bill getById(int id) {
        return billList.stream()
                .filter(bill -> bill.getIdBill() == id)
                .findFirst()
                .orElse(null);
    }

    public static int nextIdBill() {
        int maxId = 0;
        for (Bill bill : billList) {
            if (bill.getIdBill() > maxId) {
                maxId = bill.getIdBill();
            }
        }
        return maxId + 1;
    }

    @Override
    public void create() {

    }
    public static void createa(int id) {
        GuideSV guideSV = new GuideSV();
        Guide idGuide = guideSV.getById(id);
        int IdBill = nextIdBill();
        ClientSV clientSV = ClientSV.getInstance();
        List<Client> clientSV1 = clientSV.getClientList();
        String IdClient = null;
        for (Client user : clientSV1) {
            if (user.getUserName().equals(LoginSv.login())) {
                IdClient = user.getName();
            }
        }
        LocalDate InvoiceDate1 = LocalDate.now();
        String IdGuide =idGuide.getName();
        LocalDate StarDate = AppUltis.getDate();
        LocalDate EndDate = AppUltis.getDate();
        String Note = getString("Vui lòng nhập yêu cầu bạn muốn nhắn nhủ đến hướng dẫn viên");
        String Status ="đẹp trai";
        double Price = idGuide.getPrice();
        long daysBetween = ChronoUnit.DAYS.between(StarDate, EndDate);
        double Total = daysBetween * Price;
        Bill newBill = new Bill(IdBill, IdClient, InvoiceDate1, IdGuide, StarDate, EndDate, Note, Status,Price,Total);
        ///
        billList.add(newBill);
        SerializationUtil.serialize(billList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Bill.txt");
        System.out.println("Tạo đơn thành công!");
    }


    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void display() {

    }

    public static void main(String[] args) {
        InitBill.initBill();;

    }
}

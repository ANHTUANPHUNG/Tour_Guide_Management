package service;

import Models.Bill;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EStatusBill;
import utils.*;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import static View.ClientView.setTourClient;
import static service.ClientSV.clientList;
import static service.GuideSV.guideList;
import static service.LoginSv.checkUserName1;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;
import static utils.AppUltis.getString;

import static utils.getValue.getString;

public class BillSV implements CRUD<Bill> {
    public static List<Bill> billList ;
    static {
       billList = (List<Bill>) SerializationUtil.deserialize("Bill.txt");
    }

    public static void displayBill() {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n", "ID", "Client", "Invoice Date", "Guide", "Star Date", "End Date", "Note", "Status", "Price", "Total");
        for (Bill bill : billList) {
            System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n",
                    bill.getIdBill(), bill.getNameClient(), bill.getInvoiceDate(), bill.getNameGuide(),
                    bill.getStarDate(), bill.getEndDate(), bill.getNote(), bill.getStatus(), covertPriceToString(bill.getPrice()), covertPriceToString(bill.getTotal()));
        }
        System.out.println("===========================================================================================================================================================\n\n");
    }

    public static void displayBill(String id) {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-7s| %-12s| %-15s| %-12s| %-12s| %-20s| %-15s| %-15s| %-15s|\n", "ID", "Client", "Invoice Date", "Guide", "Star Date", "End Date", "Note", "Status", "Price", "Total");
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(id)) {
                System.out.printf("|%-4s| %-7s| %-12s| %-15s| %-12s| %-12s| %-20s| %-15s| %-15s| %-15s|\n",
                        bill.getIdBill(), bill.getNameClient(), bill.getInvoiceDate(), bill.getNameGuide(),
                        bill.getStarDate(), bill.getEndDate(), bill.getNote(), bill.getStatus(),
                        covertPriceToString(bill.getPrice()), covertPriceToString(bill.getTotal()));
            }
        }
        System.out.println("===========================================================================================================================================================");
    }
    public static void displayBillGuide(String id) {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-12s| %-15s| %-12s| %-12s| %-15s| %-15s| %-15s| %-15s|\n", "ID", "Client", "Invoice Date", "Guide", "Star Date", "End Date", "Note", "Status", "Price", "Total");
        for (Bill bill : billList) {
            if (bill.getNameGuide().equals(id)) {
                System.out.printf("|%-4s| %-15s| %-12s| %-15s| %-12s| %-12s| %-15s| %-15s| %-15s| %-15s|\n",
                        bill.getIdBill(), bill.getNameClient(), bill.getInvoiceDate(), bill.getNameGuide(),
                        bill.getStarDate(), bill.getEndDate(), bill.getNote(), bill.getStatus(),
                        covertPriceToString(bill.getPrice()), covertPriceToString(bill.getTotal()));
            }
        }
        System.out.println("===========================================================================================================================================================");
    }
    public static void displayGuideCheck(LocalDate startDate, LocalDate endDate) {
        System.out.println("                                                              Thông tin hướng dẫn viên:");
        System.out.println("============================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n", "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag", "Price");
        for (Guide guide : guideList) {
            boolean isAvailable = true;
            for (Bill bill : billList) {
                if (bill.getStarDate().isEqual(startDate) && bill.getEndDate().isEqual(endDate)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n",
                        guide.getIdGuide(), guide.getName(), guide.getAge(), guide.getAddress(), guide.geteGender(),
                        guide.getPhone(), guide.getSkill(), guide.geteStatusGuide(), guide.getFeedBack(), guide.getRate(), guide.getHastag(), covertPriceToString(guide.getPrice()));
            }
        }
        System.out.println("============================================================================================================================================================================\n\n");
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

    public static String getTheCurrentlyLoginID() {
        return checkUserName1();
    }

    public static void createBillSV(Guide guide, LocalDate startDate, LocalDate endDate) {
        int IdBill = nextIdBill();
        String NameClient = getTheCurrentlyLoginID();
        LocalDate InvoiceDate1 = LocalDate.now();
        String NameGuide = guide.getName();
        String Note = getValue.getString("Vui lòng nhập yêu cầu bạn muốn nhắn nhủ đến hướng dẫn viên");
        EStatusBill Status = EStatusBill.getStatusBillFromInt(1);
        double Price = guide.getPrice();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        double Total = (daysBetween+1) * Price;
        covertPriceToString(Total);
        Bill newBill = new Bill(IdBill, NameClient, InvoiceDate1, NameGuide, startDate, endDate, Note, Status, Price, Total);
        billList.add(newBill);
        SerializationUtil.serialize(billList, "Bill.txt");
        System.out.println("Tạo đơn thành công!");
    }
    public static void Total(){

    }
    public static void setTour(LocalDate StarDate, LocalDate EndDate){
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getStarDate().isEqual(StarDate) && bill.getEndDate().isEqual(EndDate) ) {
                hasPendingApproval = true;
                break;
            }
        }
        if (!hasPendingApproval) {
            displayGuideCheck(StarDate,StarDate);
        } else {
            System.err.println("Không có hướng dẫn viên trong khoảng ngày đã chọn");
        }
    }
    @Override
    public  void update(int id) {
    }
    public static void updated(String id) {
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(id)) {
                System.out.println("Ngày bắt đầu");
                LocalDate StarDate = AppUltis.getDateBook(id);
                System.out.println("Ngày kết thúc");
                LocalDate EndDate = AppUltis.getDateBook(id);
                long daysBetween = ChronoUnit.DAYS.between(StarDate, EndDate);
                double Total = (daysBetween+1) * bill.getPrice();
                covertPriceToString(Total);
                bill.setStarDate(StarDate);
                bill.setEndDate(EndDate);
                bill.setTotal(Total);
                System.out.println("Sửa đơn thành công");
            }
        }
    }
    public static void extended(String id){
        for (Bill bill : billList) {
            if (bill.getNameClient().equals(id)) {
                System.out.println("Thay đổi ngày kết thúc");
                LocalDate EndDate = AppUltis.getDate();
                long daysBetween = ChronoUnit.DAYS.between(bill.getStarDate(), EndDate);
                double Total = (daysBetween+1) * bill.getPrice();
                covertPriceToString(Total);
                bill.setEndDate(EndDate);
                bill.setTotal(Total);
                System.out.println("Sửa đơn thành công");
            }
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void display() {

    }
}

package service;

import Models.Bill;
import Models.Client;
import Models.Guide;
import Repository.CRUD;
import utils.AppUltis;
import utils.SerializationUtil;

import java.util.List;

public class BillSV implements CRUD<Bill> {
    public static List<Bill> billList= (List<Bill>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Bill.txt");
    public static void displayBill() {
        System.out.println("                                                              Thông tin hóa đơn:");
        System.out.println("===========================================================================================================================================================");
        System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n", "ID", "Client", "Invoice Date", "Guide", "Star Date", "End Date", "Note", "Status", "Price", "Total");
        for (Bill bill : billList) {
            System.out.printf("|%-4s| %-20s| %-12s| %-20s| %-12s| %-12s| %-15s| %-15s| %-10s| %-15s|\n",
                    bill.getIdBill(),bill.getIdClient(),bill.getInvoiceDate(),bill.getIdGuide(),
                    bill.getStarDate(),bill.getEndDate(),bill.getNote(),bill.getStatus(),bill.getPrice(),bill.getTotal());
        }
        System.out.println("===========================================================================================================================================================\n\n");
    }
    @Override
    public Bill getById() {
        int choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí bill):", 1, nextIdBill()-1);
        return billList.stream()
                .filter(guide -> guide.getIdBill() == choice)
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

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void display() {

    }
}

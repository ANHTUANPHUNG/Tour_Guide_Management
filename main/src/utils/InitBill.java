package utils;

import Models.Bill;
import Models.Client;
import service.BillSV;
import service.ClientSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static service.BillSV.displayBill;

public class InitBill {
    public static void main(String[] args) {
        InitBill.initBill();
        displayBill();
    }
    public static void initBill()  {
        List<Bill> billLists = new ArrayList<>();
        Bill bill1 = new Bill(1, "Client 1", LocalDate.of(2021,07,10), "Guide 1", LocalDate.of(2023,7,1), LocalDate.of(2023,7,5), "Note 1", "Paid", 1500000, 110.0);
        Bill bill2 = new Bill(2, "Client 2",  LocalDate.of(2021,07,01), "Guide 2", LocalDate.of(2023,7,1), LocalDate.of(2023,7,5), "Note 2", "Pending", 1200000, 160.0);
        billLists.add(bill1);
        billLists.add(bill2);
        BillSV.billList = billLists;
        SerializationUtil.serialize(billLists, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\Bill.txt");

    }
}

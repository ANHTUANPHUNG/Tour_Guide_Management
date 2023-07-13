package utils;

import Models.Bill;
import Models.Client;
import eNum.EStatusBill;
import eNum.EStatusGuide;
import service.BillSV;
import service.ClientSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static service.BillSV.Total;
import static service.BillSV.displayBill;

public  class InitBill {

    public static void initBill()  {
        List<Bill> billLists = new ArrayList<>();
        Bill bill1 = new Bill(1, "minhan", LocalDate.of(2023,3,21), "Trường An", LocalDate.of(2023,4,1),
                LocalDate.of(2023,4,6), "Mang đẹp", EStatusBill.FINISH, 1500000, Total("Trường An"));
        Bill bill2 = new Bill(2, "trungdung",  LocalDate.of(2023,4,30), "Ái Phương", LocalDate.of(2023,5,15),
                LocalDate.of(2023,5,20), "Vui vẻ", EStatusBill.FINISH, 1200000, Total("Ái Phương"));
        Bill bill3 = new Bill(3, "thaochi",  LocalDate.of(2023,6,15), "Anh Dũng", LocalDate.of(2023,6,21),
                LocalDate.of(2023,6,30), "Có con nít", EStatusBill.FINISH, 1000000, Total("Anh Dũng"));
        Bill bill4 = new Bill(4, "trungkien",  LocalDate.of(2023,2,15), "Gia Bách", LocalDate.of(2023,3,23),
                LocalDate.of(2023,3,30), "hòa đồng", EStatusBill.FINISH, 1300000, Total("Gia Bách"));
        Bill bill5 = new Bill(5, "ngocbang",  LocalDate.of(2023,2,22), "Thùy Anh", LocalDate.of(2023,2,26),
                LocalDate.of(2023,2,28), "Mang đẹp", EStatusBill.FINISH, 1100000, Total("Thùy Anh"));
        Bill bill6 = new Bill(6, "gialong",  LocalDate.of(2023,1,15), "Thiên Bảo", LocalDate.of(2023,1,25),
                LocalDate.of(2023,2,10), "Vui vẻ", EStatusBill.FINISH, 1800000, Total("Thiên Bảo"));
        Bill bill7 = new Bill(7, "taiduc",  LocalDate.of(2023,4,30), "Tố Như", LocalDate.of(2023,5,26),
                LocalDate.of(2023,6,5), "Mang đẹp", EStatusBill.FINISH, 2500000, Total("Tố Như"));
        Bill bill8 = new Bill(8, "hongnhung",  LocalDate.of(2023,5,26), "Anh Thư", LocalDate.of(2023,6,23),
                LocalDate.of(2023,6,25), "Mang đẹp", EStatusBill.FINISH, 3000000, Total("Anh Thư"));
        Bill bill9 = new Bill(9, "gialong",  LocalDate.of(2023,2,19), "Hương Tràm", LocalDate.of(2023,3,12),
                LocalDate.of(2023,3,17), "Mang đẹp", EStatusBill.FINISH, 2100000, Total("Hương Tràm"));
        Bill bill10 = new Bill(10, "trucduong",  LocalDate.of(2023,1,1), "Ái Phương", LocalDate.of(2023,1,3),
                LocalDate.of(2023,1,14), "Mang đẹp", EStatusBill.FINISH, 1200000, Total("Ái Phương"));
        Bill bill11 = new Bill(11, "minhan",  LocalDate.of(2023,1,11), "Thành Công", LocalDate.of(2023,1,21),
                LocalDate.of(2023,1,27), "hòa đồng", EStatusBill.FINISH, 2700000, Total("Thành Công"));
        Bill bill12 = new Bill(12, "trungkien",  LocalDate.of(2023,3,21), "Anh Dũng", LocalDate.of(2023,4,15),
                LocalDate.of(2023,4,25), "Mang đẹp", EStatusBill.FINISH, 1000000, Total("Anh Dũng"));
        Bill bill13 = new Bill(13, "taiduc",  LocalDate.of(2023,4,24), "Gia Bách", LocalDate.of(2023,5,13),
                LocalDate.of(2023,5,17), "Vui vẻ", EStatusBill.FINISH, 1300000, Total("Gia Bách"));
        Bill bill14 = new Bill(14, "duyluan",  LocalDate.of(2023,1,25), "Trường An", LocalDate.of(2023,2,21),
                LocalDate.of(2023,2,20), "Có con nít", EStatusBill.FINISH, 1500000, Total("Trường An"));
        Bill bill15 = new Bill(15, "hongnhung",  LocalDate.of(2023,2,20), "Hương Tràm", LocalDate.of(2023,3,11),
                LocalDate.of(2023,3,17), "Mang đẹp", EStatusBill.FINISH, 2100000, Total("Hương Tràm"));
        Bill bill16 = new Bill(16, "thaochi",  LocalDate.of(2023,3,1), "Tố Như", LocalDate.of(2023,3,3),
                LocalDate.of(2023,3,21), "hòa đồng", EStatusBill.FINISH, 2500000, Total("Tố Như"));
        Bill bill17 = new Bill(17, "minhan",  LocalDate.of(2023,4,25), "Anh Thư", LocalDate.of(2023,5,4),
                LocalDate.of(2023,5,9), "Mang đẹp", EStatusBill.FINISH, 3000000, Total("Anh Thư"));
        Bill bill18 = new Bill(18, "trucduong",  LocalDate.of(2023,1,24), "Hương Tràm", LocalDate.of(2023,2,1),
                LocalDate.of(2023,2,12), "Mang đẹp", EStatusBill.FINISH, 2100000, Total("Hương Tràm"));
        Bill bill19 = new Bill(19, "ngocbang",  LocalDate.of(2023,1,12), "Thành Công", LocalDate.of(2023,1,14),
                LocalDate.of(2023,2,1), "Có con nít", EStatusBill.FINISH, 2700000, Total("Thành Công"));
        Bill bill20 = new Bill(20, "duyluan",  LocalDate.of(2023,5,5), "Thùy Anh", LocalDate.of(2023,5,12),
                LocalDate.of(2023,6,18), "hòa đồng", EStatusBill.FINISH, 1100000, Total("Thùy Anh"));
        Bill bill21 = new Bill(21, "trungdung",  LocalDate.of(2023,2,1), "Thiên Bảo", LocalDate.of(2023,2,11),
                LocalDate.of(2023,2,20), "Có con nít", EStatusBill.FINISH, 1800000, Total("Thiên Bảo"));
        billLists.add(bill1);
        billLists.add(bill2);
        billLists.add(bill3);
        billLists.add(bill4);
        billLists.add(bill5);
        billLists.add(bill6);
        billLists.add(bill7);
        billLists.add(bill8);
        billLists.add(bill9);
        billLists.add(bill10);
        billLists.add(bill11);
        billLists.add(bill12);
        billLists.add(bill13);
        billLists.add(bill14);
        billLists.add(bill15);
        billLists.add(bill16);
        billLists.add(bill17);
        billLists.add(bill18);
        billLists.add(bill19);
        billLists.add(bill20);
        billLists.add(bill21);
        SerializationUtil.serialize(billLists, "Bill.txt");

    }
}

package utils;

import Models.Bill;
import Models.Client;
import eNum.EStatusBill;
import eNum.EStatusGuide;
import service.BillSV;
import service.ClientSV;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static service.BillSV.*;

public  class InitBill {

    public static void initBill()  {
        List<Bill> billLists = new ArrayList<>();
        BillSV.billList = billLists;
        Bill bill1 = new Bill(1, "minhan","Minh An", LocalDate.of(2023,3,21),"truongan", "Trường An", LocalDate.of(2023,4,1),
                LocalDate.of(2023,4,6), "Mang đẹp", EStatusBill.FINISH, 1500000);
        Bill bill2 = new Bill(2, "trungdung", "Trung Dũng", LocalDate.of(2023,4,30),"aiphuong", "Ái Phương", LocalDate.of(2023,5,15),
                LocalDate.of(2023,5,20), "Vui vẻ", EStatusBill.FINISH, 1200000);
        Bill bill3 = new Bill(3, "thaochi","Thảo Chi",  LocalDate.of(2023,6,15),"anhdung", "Anh Dũng", LocalDate.of(2023,6,21),
                LocalDate.of(2023,6,30), "Có con nít", EStatusBill.FINISH, 1000000);
        Bill bill4 = new Bill(4, "trungkien","Trung Kiên",  LocalDate.of(2023,2,15),"giabach", "Gia Bách", LocalDate.of(2023,3,23),
                LocalDate.of(2023,3,30), "hòa đồng", EStatusBill.FINISH, 1300000);
        Bill bill5 = new Bill(5, "ngocbang","Ngọc Băng",  LocalDate.of(2023,2,22),"thuyanh", "Thùy Anh", LocalDate.of(2023,2,26),
                LocalDate.of(2023,2,28), "Mang đẹp", EStatusBill.FINISH, 1100000);
        Bill bill6 = new Bill(6, "gialong","Gia Long",  LocalDate.of(2023,1,15),"thienbao", "Thiên Bảo", LocalDate.of(2023,1,25),
                LocalDate.of(2023,2,10), "Vui vẻ", EStatusBill.FINISH, 1800000);
        Bill bill7 = new Bill(7, "taiduc","Tài Đức",  LocalDate.of(2023,4,30),"tonhu", "Tố Như", LocalDate.of(2023,5,26),
                LocalDate.of(2023,6,5), "Mang đẹp", EStatusBill.FINISH, 2500000);
        Bill bill8 = new Bill(8, "hongnhung","Hồng Nhung",  LocalDate.of(2023,5,26),"anhthu", "Anh Thư", LocalDate.of(2023,6,23),
                LocalDate.of(2023,6,25), "Mang đẹp", EStatusBill.FINISH, 3000000);
        Bill bill9 = new Bill(9, "gialong","Gia Long",  LocalDate.of(2023,2,19),"huongtram", "Hương Tràm", LocalDate.of(2023,3,20),
                LocalDate.of(2023,3,30), "Mang đẹp", EStatusBill.FINISH, 2100000);
        Bill bill10 = new Bill(10, "trucduong","Trúc Dương",  LocalDate.of(2023,1,1),"aiphuong", "Ái Phương", LocalDate.of(2023,1,3),
                LocalDate.of(2023,1,14), "Mang đẹp", EStatusBill.FINISH, 1200000);
        Bill bill11 = new Bill(11, "minhan","Minh An",  LocalDate.of(2023,1,11),"thanhcong", "Thành Công", LocalDate.of(2023,1,21),
                LocalDate.of(2023,1,27), "hòa đồng", EStatusBill.FINISH, 2700000);
        Bill bill12 = new Bill(12, "trungkien", "Trung Kiên", LocalDate.of(2023,3,21),"anhdung", "Anh Dũng", LocalDate.of(2023,4,15),
                LocalDate.of(2023,4,25), "Mang đẹp", EStatusBill.FINISH, 1000000);
        Bill bill13 = new Bill(13, "taiduc","Tài Đức",  LocalDate.of(2023,4,24),"giabach", "Gia Bách", LocalDate.of(2023,5,13),
                LocalDate.of(2023,5,17), "Vui vẻ", EStatusBill.FINISH, 1300000);
        Bill bill14 = new Bill(14, "duyluan","Duy Luận",  LocalDate.of(2023,1,25),"truongan", "Trường An", LocalDate.of(2023,2,21),
                LocalDate.of(2023,2,20), "Có con nít", EStatusBill.FINISH, 1500000);
        Bill bill15 = new Bill(15, "hongnhung","Hồng Nhung",  LocalDate.of(2023,2,20),"huongtram", "Hương Tràm", LocalDate.of(2023,3,11),
                LocalDate.of(2023,3,17), "Mang đẹp", EStatusBill.FINISH, 2100000);
        Bill bill16 = new Bill(16, "thaochi","Thảo Chi",  LocalDate.of(2023,3,1),"tonhu", "Tố Như", LocalDate.of(2023,3,3),
                LocalDate.of(2023,3,21), "hòa đồng", EStatusBill.FINISH, 2500000);
        Bill bill17 = new Bill(17, "minhan","Minh An",  LocalDate.of(2023,4,25),"anhthu", "Anh Thư", LocalDate.of(2023,5,4),
                LocalDate.of(2023,5,9), "Mang đẹp", EStatusBill.FINISH, 3000000);
        Bill bill18 = new Bill(18, "trucduong","Trúc Dương",  LocalDate.of(2023,1,24),"huongtram", "Hương Tràm", LocalDate.of(2023,2,1),
                LocalDate.of(2023,2,12), "Mang đẹp", EStatusBill.FINISH, 2100000);
        Bill bill19 = new Bill(19, "ngocbang","Ngọc Băng",  LocalDate.of(2023,1,12),"thanhcong", "Thành Công", LocalDate.of(2023,1,14),
                LocalDate.of(2023,2,1), "Có con nít", EStatusBill.FINISH, 2700000);
        Bill bill20 = new Bill(20, "duyluan", "Duy Luận", LocalDate.of(2023,5,5),"thuyanh", "Thùy Anh", LocalDate.of(2023,5,12),
                LocalDate.of(2023,6,18), "hòa đồng", EStatusBill.FINISH, 1100000);
        Bill bill21 = new Bill(21, "trungdung","Trung Dũng",  LocalDate.of(2023,2,1),"thienbao", "Thiên Bảo", LocalDate.of(2023,2,11),
                LocalDate.of(2023,2,20), "Có con nít", EStatusBill.FINISH, 1800000);
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

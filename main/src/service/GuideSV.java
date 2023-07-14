package service;

import Models.Bill;
import Models.Client;
import Models.FeedBack;
import Models.Guide;
import Repository.CRUD;
import eNum.EDescription;
import eNum.EGender;
import eNum.EStatusBill;
import eNum.EStatusGuide;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static View.GuideView.*;
import static service.BillSV.*;
import static service.BillSV.billList;
import static service.ClientSV.clientList;

import static service.FeedBackSV.*;
import static service.LoginSv.checkUserName1;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;
import static utils.AppUltis.getInt;
import static utils.AppUltis.getString;
import static utils.AppUltis.getStringWithPattern;


public class GuideSV implements CRUD<Guide> {
    static int choice;


    public static List<Guide> guideList;

    static {
        guideList = (List<Guide>) SerializationUtil.deserialize("guide.txt");
    }

    private static GuideSV instance;

    public static GuideSV getInstance() {
        if (instance == null) {
            instance = new GuideSV();
        }
        return instance;
    }

    public List<Guide> getGuideList() {
        return guideList;
    }



    // hàm in ra list guide
    public static void displayGuide() {
        System.out.println("                                                Thông tin hướng dẫn viên:");
        System.out.println("====================================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-12s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n",
                "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag", "Price");
        for (Guide guide : guideList) {
            System.out.printf("|%-4s| %-15s| %-12s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n",
                    guide.getIdGuide(), guide.getName(), guide.getAge(), guide.getAddress(), guide.geteGender(),
                    guide.getPhone(), guide.getSkill(), guide.geteStatusGuide(), guide.getFeedBack(), guide.getRate(), guide.getHastag(), covertPriceToString(guide.getPrice()));
        }
        System.out.println("====================================================================================================================================================================================\n\n");}

    //hàm in
    @Override
    public Guide getById(int id) {
        return guideList.stream()
                .filter(guide -> guide.getIdGuide() == id)
                .findFirst()
                .orElse(null);
    }

    //    hàm lấy id tiếp theo
    public static int nextIdGuide() {
        int maxId = 0;
        for (Guide guide : guideList) {
            if (guide.getIdGuide() > maxId) {
                maxId = guide.getIdGuide();
            }
        }
        return maxId + 1;
    }

    //hàm tạo guide
    @Override
    public void create() {
//        int IdGuide = nextIdGuide();
//        String Name = getString("Nhập họ tên");
//        LocalDate Age = AppUltis.getUserDateOfBirth();
//        String Address = getString("Nhập địa chỉ");
//        EGender Gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Enter your choice''(Nhập giới tính):", 1, 3));
//        String Phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
//        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
//        EStatusGuide Status = EStatusGuide.getStatusGuideFromInt(AppUltis.getIntWithBound("Enter your choice(Mời chọn trạng thái):", 1, 2));
//        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
//        double Rate = 0;
//        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
//        double Price = Double.parseDouble(getString("Nhập tiền"));
//        covertPriceToString(Price);
//        Guide newGuide = new Guide(IdGuide, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag, Price);
//        guideList.add(newGuide);
//        System.out.println("Thêm nhân viên thành công");
//        SerializationUtil.serialize(guideList, "guide.txt");
    }

    //    sửa thông tin guide
    public void update(int id) {
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == id) {
                int choice = AppUltis.getIntWithBound("Mời chọn ví trí 1->10'Không sửa được rate':", 1, 10);
                switch (choice) {
                    case 1 -> {
                        String Name = getString("Nhập họ tên");
                        System.out.println("Sửa thành công");
                        guide.setName(Name);
                    }
                    case 2 -> {
                        LocalDate Age = AppUltis.getUserDateOfBirth();                        System.out.println("Sửa thành công");

                        guide.setAge(Age);
                    }
                    case 3 -> {
                        String Address = getString("Nhập địa chỉ");                        System.out.println("Sửa thành công");

                        guide.setAddress(Address);
                    }
                    case 4 -> {
                        EGender Gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Mời chọn'1:male,2:female,3:other' :", 1, 3));
                        System.out.println("Sửa thành công");
                        guide.seteGender(Gender);
                    }
                    case 5 -> {
                        String Phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
                        System.out.println("Sửa thành công");
                        guide.setPhone(Phone);
                    }
                    case 6 -> {
                        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
                        System.out.println("Sửa thành công");
                        guide.setSkill(Language);
                    }
                    case 7 -> {
                        EStatusGuide Status = EStatusGuide.getStatusGuideFromInt(AppUltis.getIntWithBound("Mời chọn trạng thái:", 1, 2));
                        System.out.println("Sửa thành công");
                        guide.seteStatusGuide(Status);
                    }
                    case 8 -> {
                        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
                        System.out.println("Sửa thành công");
                        guide.setFeedBack(FeedBack);
                    }
                    case 9 -> {
                        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
                        System.out.println("Sửa thành công");
                        guide.setHastag(Hashtag);
                    }
                    case 10 -> {
                        double Price = Double.parseDouble(getString("Nhập tiền"));
                        System.out.println("Sửa thành công");
                        covertPriceToString(Price);
                        guide.setPrice(Price);
                    }
                }
            }
        }
    }
//xóa guide
    @Override
    public void delete(int id) {
        guideList = guideList.stream()
                .filter(guide -> guide.getIdGuide() != id)
                .collect(Collectors.toList());
        SerializationUtil.serialize(guideList, "guide.txt");
        System.err.println("Hướng dẫn viên với ID " + id + " đã được xóa thành công.");
    }
    @Override
    public void display() {

    }
    // đơn dangd yêu câu
    public static void orderRequestedGuide() {
        final String NameGuide = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Chưa có đơn hàng");
            return;
        }else {
            boolean hasPendingApproval = false;
            for (Bill bill : billList) {
                if (bill.getNameGuide().equals(NameGuide) && bill.getStatus().equals(EStatusBill.WAITING)) {
                    hasPendingApproval = true;
                    break;
                }
            }
            if (hasPendingApproval) {
                displayBillGuide(NameGuide);
            } else {
                System.err.println("Không có đơn hàng đang được yêu cầu");
                menuTourGuide();
            }
        }
        acceptTheOrder();
        choice = AppUltis.getIntWithBound("EMời chọn chức năng:", 0, 2);
        switch (choice) {
            case 1 -> {
                billList.stream()
                        .filter(e -> e.getNameGuide().equals(NameGuide))
                        .filter(e -> e.getStatus().equals(EStatusBill.WAITING))
                        .forEach(e -> e.setStatus(EStatusBill.CONFIRMED));
                System.err.println("Duyệt đơn thành công");
            }
            case 2 -> {
                billList.stream()
                        .filter(e -> e.getNameGuide().equals(NameGuide))
                        .filter(e -> e.getStatus().equals(EStatusBill.WAITING))
                        .forEach(e -> e.setStatus(EStatusBill.Refuse));
                System.err.println("Từ chối thành công");
            }
            case 0 -> menuTourGuide();
        }

    }
    public static void acceptTheOrder() {
        System.out.println("1. Chấp thuận đơn hàng.");
        System.out.println("2. Từ chối đơn hàng.");
        System.out.println("0. Quay lại .");
    }
    //    đơn đã hoàn thành
    public static void orderCompletedGuide() {
        final String NameGuide = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Chưa có đơn hàng");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameGuide().equals(NameGuide) && bill.getStatus().equals(EStatusBill.FINISH)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBillGuide(NameGuide);
        } else {
            System.err.println("Không có đơn hàng đang đã hoàn thành.");
            menuTourGuide();
        }
        System.out.println("0. Quay lại.");
        choice = AppUltis.getIntWithBound("Mời chọn chức năng:", 0,0 );
        if(choice==0){
            menuTourGuide();
        }
    }
    //    đơn đang chạy
    public static void orderInProgressGuide() {
        final String NameGuide = getTheCurrentlyLoginID();
        if (billList.isEmpty()) {
            System.err.println("Chưa có đơn hàng");
            return;
        }
        boolean hasPendingApproval = false;
        for (Bill bill : billList) {
            if (bill.getNameGuide().equals(NameGuide) && bill.getStatus().equals(EStatusBill.INPROGRESS)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayBillGuide(NameGuide);
        } else {
            System.err.println("Không có đơn hàng đang hoạt động.");
            menuTourGuide();
        }
        orderInProgress();
        choice = AppUltis.getIntWithBound("Mời chọn chức năng:", 0, 1);
        switch (choice) {
            case 1 -> {
                billList.stream()
                        .filter(e -> e.getNameGuide().equals(NameGuide))
                        .filter(e -> e.getStatus().equals(EStatusBill.INPROGRESS))
                        .forEach(e -> e.setStatus(EStatusBill.DELETE));
                System.err.println("Duyệt đơn thành công");
            }
            case 0 -> menuTourGuide();
        }
    }
    public static void orderInProgress() {
        System.out.println("Đơn hàng đang chạy.");
        System.out.println("1. Hủy đơn.");
        System.out.println("0 Quay lại.");
    }
    public static void FeedBackClient() {
        final String NameGuide = checkUserName1();
        if (feedBackList.isEmpty()) {
            System.err.println("Chưa có đánh giá");
            return;
        }
        boolean hasPendingApproval = false;
        for (FeedBack feedBack : feedBackList) {
            if (feedBack.getNameGuide().equals(NameGuide)) {
                hasPendingApproval = true;
                break;
            }
        }
        if (hasPendingApproval) {
            displayFeedBackGuide(NameGuide);
        } else {
            System.err.println("Không có đánh giá");
            menuTourGuide();
        }
        System.out.println("0. Quay lại.");
        choice = AppUltis.getIntWithBound("Mời chọn chức năng:", 0,0 );
        if(choice==0){
            menuTourGuide();
        }
    }

}

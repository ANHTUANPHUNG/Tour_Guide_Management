package service;

import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EDescription;
import eNum.EGender;
import eNum.EStatusGuide;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static service.ClientSV.clientList;

import static service.FeedBackSV.totalRate;
import static utils.AppUltis.CurrencyFormat.covertPriceToString;
import static utils.AppUltis.getInt;
import static utils.AppUltis.getString;
import static utils.AppUltis.getStringWithPattern;


public class GuideSV implements CRUD<Guide> {

    public static List<Guide> guideList = (List<Guide>) SerializationUtil.deserialize("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
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

    public static void displayGuide() {
        System.out.println("                                                              Thông tin hướng dẫn viên:");
        System.out.println("============================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n", "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag","Price");
        for (Guide guide : guideList) {
            System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-12s|\n",
                    guide.getIdGuide(), guide.getName(), guide.getAge(), guide.getAddress(), guide.geteGender(),
                    guide.getPhone(), guide.getSkill(), guide.geteStatusGuide(), guide.getFeedBack(), guide.getRate(), guide.getHastag(),covertPriceToString(guide.getPrice()));
        }
        System.out.println("============================================================================================================================================================================\n\n");
    }


    @Override
    public Guide getById(int id) {
//        int choice =AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí nhân viên):", 1, nextIdGuide()-1);
        return guideList.stream()
                .filter(guide -> guide.getIdGuide() == id)
                .findFirst()
                .orElse(null);
    }
    public static int nextIdGuide() {
        int maxId = 0;
        for (Guide guide : guideList) {
            if (guide.getIdGuide() > maxId) {
                maxId = guide.getIdGuide();
            }
        }
        return maxId + 1;
    }

    @Override
    public void create() {
        int IdGuide = nextIdGuide();
        String Name = getString("Nhập họ tên");
        String Age = getString("Nhập tuổi");
        String Address = getString("Nhập địa chỉ");
        EGender Gender = EGender.getGenderFromInt(AppUltis.getIntWithBound("Enter your choice(Nhập giới tính):", 1, 3));
        String Phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
        EStatusGuide Status = EStatusGuide.getStatusGuideFromInt(AppUltis.getIntWithBound("Enter your choice(Mời chọn trạng thái):", 1, 2));
        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
        double Rate = totalRate(IdGuide);
        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
        double Price =Double.parseDouble(getString("Nhập tiền"));
        covertPriceToString(Price);
        Guide newGuide = new Guide(IdGuide, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag,Price);
        guideList.add(newGuide);
        System.out.println("Thêm nhân viên thành công");
        SerializationUtil.serialize(guideList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }

    public void update(int id){
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == id) {
                int choice  = AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí bạn muốn sửa):", 1, 11);
                switch (choice) {
                    case 1 -> {
                        String Name = getString("Nhập họ tên");
                        guide.setName(Name);
                    }
                    case 2 -> {
                        String Age = getString("Nhập tuổi");
                        guide.setAge(Age);
                    }
                    case 3 -> {
                        String Address = getString("Nhập địa chỉ");
                        guide.setAddress(Address);
                    }
                    case 4 -> {
                        EGender Gender = EGender.getGenderFromInt( AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí bạn muốn sửa):", 1, 3));
                        guide.seteGender(Gender);
                    }
                    case 5 -> {
                        String Phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
                        guide.setPhone(Phone);
                    }
                    case 6 -> {
                        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
                        guide.setSkill(Language);
                    }
                    case 7 -> {
                        EStatusGuide Status = EStatusGuide.getStatusGuideFromInt(AppUltis.getIntWithBound("Enter your choice(Mời chọn trạng thái):", 1, 2));
                        guide.seteStatusGuide(Status);
                    }
                    case 8 -> {
                        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
                        guide.setFeedBack(FeedBack);
                    }
                    case 9 -> {
                        double Rate = Double.parseDouble(getString("Nhập sao"));
                        guide.setRate(Rate);
                    }
                    case 10 -> {
                        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
                        guide.setHastag(Hashtag);
                    }
                    case 11 -> {
                        double Price = Double.parseDouble(getString("Nhập tiền"));
                        covertPriceToString(Price);
                        guide.setPrice(Price);
                    }
                }
            }
        }
    }

    @Override
    public void delete(int id){

        guideList = guideList.stream()
                .filter(guide -> guide.getIdGuide() != id)
                .collect(Collectors.toList());
        SerializationUtil.serialize(guideList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
        System.out.println("Hướng dẫn viên với ID " + id + " đã được xóa thành công.");
    }

    @Override
    public void display() {

    }


}

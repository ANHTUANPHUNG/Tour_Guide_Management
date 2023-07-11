package service;

import Models.Client;
import Models.Guide;
import Repository.CRUD;
import eNum.EDescription;
import eNum.EGender;
import utils.AppConstant;
import utils.AppUltis;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static service.ClientSV.clientList;

import static utils.AppUltis.getInt;
import static utils.AppUltis.getStringWithPattern;
import static utils.getValue.getString;


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
        System.out.println("===========================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-10s|\n", "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag","Price");
        for (Guide guide : guideList) {
            System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-5s| %-25s| %-10s|\n",
                    guide.getIdGuide(), guide.getName(), guide.getAge(), guide.getAddress(), guide.geteGender(),
                    guide.getPhone(), guide.getSkill(), guide.getStatus(), guide.getFeedBack(), guide.getRate(), guide.getHastag(),guide.getPrice());
        }
        System.out.println("===========================================================================================================================================================================\n\n");
    }


    @Override
    public Guide getById() {
        int choice =AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí nhân viên):", 1, nextId()-1);
        return guideList.stream()
                .filter(guide -> guide.getIdGuide() == choice)
                .findFirst()
                .orElse(null);
    }
    public static int nextId() {
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
        int IdGuide = nextId();
        String Name = getString("Nhập họ tên");
        String Age = getString("Nhập tuổi");
        String Address = getString("Nhập địa chỉ");
        EGender Gender = EGender.getGenderFromInt(getInt("nhập giơi tính"));
        String Phone = getStringWithPattern("Nhập số điện thoại(Bắt đầu bằng số 0)", AppConstant.REGEX_PHONE);
        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
        String Status = getString("Nhập trạng thái");
        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
        double Rate = Double.parseDouble(getString("Nhập sao"));
        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
        long Price =Long.parseLong(getString("Nhập tiền"));
        Guide newGuide = new Guide(IdGuide, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag,Price);
        guideList.add(newGuide);
        SerializationUtil.serialize(guideList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }

    public void update(){
        int choice = AppUltis.getIntWithBound("Enter your choice(Mời chọn ví trí nhân viên):", 1, nextId()-1);
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == choice) {
                EDescription description1 = EDescription.getDescriptionFromInt(getInt("Nhập vị trí bạn muốn thay đổi"));
                switch (Objects.requireNonNull(description1).getId()) {
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
                        EGender Gender = EGender.getGenderFromInt(getInt("nhập giơi tính"));
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
                        String Status = getString("Nhập trạng thái");
                        guide.setStatus(Status);
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
                        long Price =Long.parseLong(getString("Nhập tiền"));
                        guide.setPrice(Price);
                    }
                }
            }
        }
    }

    @Override
    public void delete(){
        int id = getInt("Nhập vị trí nhân viên bạn muốn xóa bạn");
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

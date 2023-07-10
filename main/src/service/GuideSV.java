package service;

import Models.Guide;
import Repository.CRUD;
import eNum.EDescription;
import eNum.EGender;
import utils.AppConstant;
import utils.SerializationUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import static eNum.EDescription.Phone;
import static service.MainSv.nextId;
import static utils.AppUltis.getInt;
import static utils.getValue.getString;
import static utils.getValue.getStringWithPattern;

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
        System.out.println("===================================================================================================================================================================");
        System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-10s| %-25s |\n", "ID", "Name", "Age", "Address", "Gender", "Phone", "Language", "Status", "FeedBack", "Rate", "Hashtag");
        for (Guide guide : guideList) {
            System.out.printf("|%-4s| %-15s| %-5s| %-10s| %-8s| %-10s| %-20s| %-10s| %-25s| %-10s| %-25s |\n",
                    guide.getIdGuide(), guide.getName(), guide.getAge(), guide.getAddress(), guide.geteGender(),
                    guide.getPhone(), guide.getSkill(), guide.getStatus(), guide.getFeedBack(), guide.getRate(), guide.getHastag());
        }
        System.out.println("====================================================================================================================================================================\n\n");
    }


    @Override
    public Guide getById(int id) {
        return guideList.stream()
                .filter(guide -> guide.getIdGuide() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void create() throws IOException {
        int IdGuide = nextId();
        String Name = getString("Nhập họ tên");
        String Age = getString("Nhập tuổi");
        String Address = getString("Nhập địa chỉ");
        EGender Gender = EGender.getGenderFromInt(getInt("nhập giơi tính"));
        String Phone = getStringWithPattern("Nhập số điện thoại", AppConstant.REGEX_PHONE);
        List<String> Language = Collections.singletonList(getString("Nhập ngoại ngữa"));
        String Status = getString("Nhập trạng thái");
        List<String> FeedBack = Collections.singletonList(getString("Nhập phản hồi"));
        double Rate = Double.parseDouble(getString("Nhập sao"));
        List<String> Hashtag = Collections.singletonList(getString("Nhập Hashtag"));
        Guide newGuide = new Guide(IdGuide, Name, Age, Address, Phone, Language, Gender, Status, FeedBack, Rate, Hashtag);
        guideList.add(newGuide);
        SerializationUtil.serialize(guideList, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }

    public void update() throws IOException {
        int id = getInt("Nhập vị trí nhân viên bạn muốn xóa bạn");
        for (Guide guide : guideList) {
            if (guide.getIdGuide() == id) {
                EDescription description1 = EDescription.getDescriptionFromInt(getInt("nhập"));
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
                }
            }
        }
    }

    @Override
    public void delete(int id) throws IOException {
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

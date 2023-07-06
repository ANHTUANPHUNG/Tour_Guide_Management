package utils;

import Models.Admin;
import Models.Client;
import Models.Guide;
import eNum.EGender;
import service.GuideService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Init {
    public static void intGuide(){
        List<Guide> initGuide1 = new ArrayList<>();

//        public Client(int id, String userName, String passWord, Date dob, String address, long phone, String gender, String level, long citizenIdentification,String typeOfAccount) {
//        super(id, userName, passWord, dob, address, phone, gender, level, citizenIdentification);
//        this.typeOfAccount= typeOfAccount;
//    }
        Guide guide1= new Guide(1,"Tuấn","đẹptrai", EGender.male);
        Guide guide2= new Guide(2,"Đạt","xấutrai",EGender.other);
        Guide guide3= new Guide(3,"Duy","bìnhthuowngf",EGender.male);
        initGuide1.add(guide1);
        initGuide1.add(guide2);
        initGuide1.add(guide3);
        GuideService.guideList = initGuide1;
        SerializationUtil.serialize(initGuide1,"D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }
}

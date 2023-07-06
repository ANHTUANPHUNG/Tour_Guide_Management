package service;

import Models.Guide;
import utils.SerializationUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideService {

    public static List<Guide> guideList;

    public static void displayGuide(){
        List<Guide> initGuide1 = (List<Guide>) SerializationUtil.deserialize
                ("D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
        System.out.println("Thông tin hướng dẫn viên:");
        System.out.println("\t\t\t\t===========================================================================================================");
        System.out.printf("\t\t\t\t%-10s %-25s %-20s %-15s  \n", "ID", "Tên", "Thông tin","Giới tính");
        for (Guide guide : initGuide1) {
            System.out.printf("\t\t\t\t%-10d %-25s %-20s %-15s  \n", guide.getIdGuide(), guide.getName(), guide.getDescription(),guide.geteGender());
        }
        System.out.println("\t\t\t\t===========================================================================================================\n\n");

    }
}

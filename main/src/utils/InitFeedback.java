package utils;

import Models.Client;
import Models.FeedBack;
import service.FeedBackSV;
import service.GuideSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitFeedback {
    public static void initFeedBacks() {
        List<FeedBack> feedBacks = new ArrayList<>();
        FeedBack feedBack1 = new FeedBack(1,"dsd", LocalDate.now(),1,"tuan","yeah",4);
        FeedBack feedBack2 = new FeedBack(2,"dsd", LocalDate.now(),2,"nam","yeah",2);
        FeedBack feedBack3 = new FeedBack(3,"dsd", LocalDate.now(),1,"tuan","yeah",3);
        FeedBack feedBack4 = new FeedBack(4,"dsd", LocalDate.now(),2,"nam","yeah",5);
        FeedBack feedBack5 = new FeedBack(5,"dsd", LocalDate.now(),1,"tuan","yeah",2);
        FeedBack feedBack6 = new FeedBack(6,"dsd", LocalDate.now(),2,"nam","yeah",1);
        FeedBack feedBack7 = new FeedBack(7,"dsd", LocalDate.now(),1,"tuan","yeah",1);
        FeedBack feedBack8 = new FeedBack(8,"dsd", LocalDate.now(),2,"nam","yeah",4);
        feedBacks.add(feedBack1);
        feedBacks.add(feedBack2);
        feedBacks.add(feedBack3);
        feedBacks.add(feedBack4);
        feedBacks.add(feedBack5);
        feedBacks.add(feedBack6);
        feedBacks.add(feedBack7);
        feedBacks.add(feedBack8);
        SerializationUtil.serialize(feedBacks, "D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\FeedBack.txt");
    }

}

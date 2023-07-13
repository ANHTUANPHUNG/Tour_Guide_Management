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
        FeedBack feedBack1 = new FeedBack(1,"minhan", LocalDate.now(),1,"Trường An","yeah",4);
        FeedBack feedBack2 = new FeedBack(2,"taiduc", LocalDate.now(),6,"Thiên Bảo","yeah",5);
        FeedBack feedBack3 = new FeedBack(3,"trungdung", LocalDate.now(),7,"Tố Như","yeah",3);
        FeedBack feedBack4 = new FeedBack(4,"trungkien", LocalDate.now(),8,"Anh Thư","yeah",5);
        FeedBack feedBack5 = new FeedBack(5,"ngocbang", LocalDate.now(),5,"Thùy Anh","yeah",4);
        FeedBack feedBack6 = new FeedBack(6,"trungkien", LocalDate.now(),9,"Thành Công","yeah",2);
        FeedBack feedBack7 = new FeedBack(7,"minhan", LocalDate.now(),6,"Thiên Bảo","yeah",4);
        FeedBack feedBack8 = new FeedBack(8,"hongnhung", LocalDate.now(),3,"Anh Dũng","yeah",4);
        FeedBack feedBack9 = new FeedBack(9,"thaochi", LocalDate.now(),10,"Hương Tràm","yeah",3);
        FeedBack feedBack10 = new FeedBack(10,"trucduong", LocalDate.now(),2,"Ái Phương","yeah",2);
        FeedBack feedBack11 = new FeedBack(11,"gialong", LocalDate.now(),7,"Tố Như","yeah",3);
        FeedBack feedBack12 = new FeedBack(12,"trucduong", LocalDate.now(),8,"Anh Thư","yeah",5);
        FeedBack feedBack13 = new FeedBack(13,"duyluan", LocalDate.now(),3,"Anh Dũng","yeah",2);
        FeedBack feedBack14 = new FeedBack(14,"ngocbang", LocalDate.now(),2,"Ái Phương","yeah",1);
        FeedBack feedBack15 = new FeedBack(15,"hongnhung", LocalDate.now(),1,"Trường An","yeah",5);
        FeedBack feedBack16 = new FeedBack(16,"minhan", LocalDate.now(),2,"Ái Phương","yeah",3);
        FeedBack feedBack17 = new FeedBack(17,"trungdung", LocalDate.now(),9,"Thành Công","yeah",2);
        FeedBack feedBack18 = new FeedBack(18,"duyluan", LocalDate.now(),10,"Hương Tràm","yeah",3);
        FeedBack feedBack19 = new FeedBack(19,"gialong", LocalDate.now(),4,"Gia Bách","yeah",5);
        FeedBack feedBack20 = new FeedBack(20,"taiduc", LocalDate.now(),5,"Thùy Anh","yeah",4);
        FeedBack feedBack21 = new FeedBack(21,"thaochi", LocalDate.now(),4,"Gia Bách","yeah",2);
        feedBacks.add(feedBack1);
        feedBacks.add(feedBack2);
        feedBacks.add(feedBack3);
        feedBacks.add(feedBack4);
        feedBacks.add(feedBack5);
        feedBacks.add(feedBack6);
        feedBacks.add(feedBack7);
        feedBacks.add(feedBack8);
        feedBacks.add(feedBack9);
        feedBacks.add(feedBack10);
        feedBacks.add(feedBack11);
        feedBacks.add(feedBack14);
        feedBacks.add(feedBack12);
        feedBacks.add(feedBack13);
        feedBacks.add(feedBack15);
        feedBacks.add(feedBack16);
        feedBacks.add(feedBack18);
        feedBacks.add(feedBack17);
        feedBacks.add(feedBack10);
        feedBacks.add(feedBack19);
        feedBacks.add(feedBack21);
        feedBacks.add(feedBack20);
        SerializationUtil.serialize(feedBacks, "FeedBack.txt");
    }

}

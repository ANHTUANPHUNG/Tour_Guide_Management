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
        FeedBack feedBack1 = new FeedBack(1,"minhan","Minh An", LocalDate.now(),1,"Trường An","yeah",4);
        FeedBack feedBack2 = new FeedBack(2,"taiduc","Tài Đức",LocalDate.now(),6,"Thiên Bảo","yeah",5);
        FeedBack feedBack3 = new FeedBack(3,"trungdung","Trung Dũng", LocalDate.now(),7,"Tố Như","yeah",3);
        FeedBack feedBack4 = new FeedBack(4,"trungkien", "Trung Kiên",LocalDate.now(),8,"Anh Thư","yeah",5);
        FeedBack feedBack5 = new FeedBack(5,"ngocbang","Ngọc Băng", LocalDate.now(),5,"Thùy Anh","yeah",4);
        FeedBack feedBack6 = new FeedBack(6,"trungkien","Trung Kiên", LocalDate.now(),9,"Thành Công","yeah",2);
        FeedBack feedBack7 = new FeedBack(7,"minhan","Minh An", LocalDate.now(),6,"Thiên Bảo","yeah",4);
        FeedBack feedBack8 = new FeedBack(8,"hongnhung","Hồng Nhung", LocalDate.now(),3,"Anh Dũng","yeah",4);
        FeedBack feedBack9 = new FeedBack(9,"thaochi","Thảo Chi", LocalDate.now(),10,"Hương Tràm","yeah",3);
        FeedBack feedBack10 = new FeedBack(10,"trucduong","Trúc Dương", LocalDate.now(),2,"Ái Phương","yeah",2);
        FeedBack feedBack11 = new FeedBack(11,"gialong","Gia Long", LocalDate.now(),7,"Tố Như","yeah",3);
        FeedBack feedBack12 = new FeedBack(12,"trucduong","Trúc Dương", LocalDate.now(),8,"Anh Thư","yeah",5);
        FeedBack feedBack13 = new FeedBack(13,"duyluan","Duy Luận", LocalDate.now(),3,"Anh Dũng","yeah",2);
        FeedBack feedBack14 = new FeedBack(14,"ngocbang","Ngọc Băng", LocalDate.now(),2,"Ái Phương","yeah",1);
        FeedBack feedBack15 = new FeedBack(15,"hongnhung","Hồng Nhung", LocalDate.now(),1,"Trường An","yeah",5);
        FeedBack feedBack16 = new FeedBack(16,"minhan","Minh An", LocalDate.now(),2,"Ái Phương","yeah",3);
        FeedBack feedBack17 = new FeedBack(17,"trungdung","Trung Dũng", LocalDate.now(),9,"Thành Công","yeah",2);
        FeedBack feedBack18 = new FeedBack(18,"duyluan","Duy Luận", LocalDate.now(),10,"Hương Tràm","yeah",3);
        FeedBack feedBack19 = new FeedBack(19,"gialong","Gia Long", LocalDate.now(),4,"Gia Bách","yeah",5);
        FeedBack feedBack20 = new FeedBack(20,"taiduc","Tài Đức", LocalDate.now(),5,"Thùy Anh","yeah",4);
        FeedBack feedBack21 = new FeedBack(21,"thaochi","Thảo Chi", LocalDate.now(),4,"Gia Bách","yeah",2);
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

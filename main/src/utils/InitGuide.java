package utils;

import Models.FeedBack;
import Models.Guide;
import eNum.EGender;
import eNum.EStatusGuide;
import service.AdminSV;
import service.FeedBackSV;
import service.GuideSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static service.FeedBackSV.createFeedBackSV;
import static service.FeedBackSV.totalRate;
import static service.GuideSV.displayGuide;

public class InitGuide {
    public static void intGuide() {
        List<Guide> initGuide1 = new ArrayList<>();

        Guide guide1 = new Guide(1, "truongan", "123456", "Trường An", "25", "T.THuế", "0338943168", Arrays.asList("English", "Japanese"), EGender.male, EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"), createFeedBackSV(), Arrays.asList("#culinary", "#Mausoleum"),1500000);
        Guide guide2 = new Guide(2, "aiphuong", "123456", "Ái Phương", "27", "Đà Nẵng", "0703239292", Arrays.asList("Korean", "Chinese"), EGender.female, EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"), totalRate(2), Arrays.asList("#Mausoleum", "#nature"),1200000);
        Guide guide3 = new Guide(3, "anhdung", "123456", "Anh Dũng", "22", "T.THuế", "0985700741", Arrays.asList("English", "Japanese"), EGender.male, EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"), totalRate(3), Arrays.asList("#Mausoleum", "#culinary"),1000000);
        Guide guide4 = new Guide(4, "giabach", "123456", "Gia Bách", "24", "Quảng Ninh", "0867053286", Arrays.asList("Russian", "Japanese"), EGender.male, EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"), totalRate(4), Arrays.asList("#culinary", "#Mausoleum"),1300000);
        Guide guide5= new Guide(5,"thuyanh","123456","Thùy Anh","22","Quảng Nam","0869520637", Arrays.asList("English", "Korean"),EGender.female,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(5), Arrays.asList("#culinary", "#nature"),1500000);
        Guide guide6= new Guide(6,"thienbao","123456","Thiên Bảo","26","Quảng Nam","0980753794", Arrays.asList("Russian", "Japanese"),EGender.male,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(6), Arrays.asList("#nature", "#culinary"),1500000);
        Guide guide7= new Guide(7,"tonhu","123456","Tố Như","28","T.THuế","0975839673", Arrays.asList("English", "Japanese"),EGender.female,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(7), Arrays.asList("#culinary", "#Mausoleum"),1500000);
        Guide guide8= new Guide(8,"anhthu","123456","Anh Thư","25","Đà Nẵng","0827483659", Arrays.asList("Korean", "Japanese"),EGender.female,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(8), Arrays.asList("#culinary", "#nature"),1500000);
        Guide guide9= new Guide(9,"thanhcong","123456","Thành Công","19","Đà Nẵng","0886903756", Arrays.asList("English", "Chinese"),EGender.male,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(9), Arrays.asList("#nature", "#Mausoleum"),1500000);
        Guide guide10= new Guide(10,"huongtram","123456","Hương Tràm","20","Quảng Ninh","0913425267", Arrays.asList("English", "Korean"),EGender.female,EStatusGuide.AVAILABLE, Arrays.asList("enthusiastic", "humorous"),totalRate(10), Arrays.asList("#Mausoleum", "#culinary"),1500000);
        initGuide1.add(guide1);
        initGuide1.add(guide2);
        initGuide1.add(guide3);
        initGuide1.add(guide4);
        initGuide1.add(guide5);
        initGuide1.add(guide6);
        initGuide1.add(guide7);
        initGuide1.add(guide8);
        initGuide1.add(guide9);
        initGuide1.add(guide10);
        SerializationUtil.serialize(initGuide1, "guide.txt");

    }
    public static void main(String[] args) {
        InitGuide.intGuide();

        displayGuide();
   }
}

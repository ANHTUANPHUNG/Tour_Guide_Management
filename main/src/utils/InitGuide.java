package utils;

import Models.Guide;
import eNum.EGender;
import service.GuideService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitGuide {
    public static void intGuide(){
        List<Guide> initGuide1 = new ArrayList<>();
        Guide guide1= new Guide(1,"Phùng Anh Tuấn","25","T.THuế",334943000, Arrays.asList("English", "Japanese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.5, Arrays.asList("#culinary", "#Mausoleum"));
        Guide guide2= new Guide(2,"Bùi Quang Tuấn","27","Đà Nẵng",142485637, Arrays.asList("Korean", "Chinese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.0, Arrays.asList("#Mausoleum", "#nature"));
        Guide guide3= new Guide(3,"Phạm Văn Đạt","22","T.THuế",142496431, Arrays.asList("English", "Japanese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),3.9, Arrays.asList("#Mausoleum", "#culinary"));
        Guide guide4= new Guide(4,"Nguyễn Thắng","24","Quảng Ninh",963585384, Arrays.asList("Russian", "Japanese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.2, Arrays.asList("#culinary", "#Mausoleum"));
        Guide guide5= new Guide(5,"Đồng Sĩ Phúc","22","Quảng Nam",869520637, Arrays.asList("English", "Korean"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.5, Arrays.asList("#culinary", "#nature"));
        Guide guide6= new Guide(6,"Nguyễn Duy","26","Quảng Nam",980753794, Arrays.asList("Russian", "Japanese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.4, Arrays.asList("#nature", "#culinary"));
        Guide guide7= new Guide(7,"Trần Văn Vinh","28","T.THuế",975839673, Arrays.asList("English", "Japanese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.1, Arrays.asList("#culinary", "#Mausoleum"));
        Guide guide8= new Guide(8,"Lê Anh Thư","25","Đà Nẵng",827483659, Arrays.asList("Korean", "Japanese"),EGender.female,"Available", Arrays.asList("enthusiastic", "humorous"),4.7, Arrays.asList("#culinary", "#nature"));
        Guide guide9= new Guide(9,"Phan Trung","19","Đà Nẵng",886903756, Arrays.asList("English", "Chinese"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.0, Arrays.asList("#nature", "#Mausoleum"));
        Guide guide10= new Guide(10,"Nguyễn Khánh","20","Quảng Ninh",913425267, Arrays.asList("English", "Korean"),EGender.male,"Available", Arrays.asList("enthusiastic", "humorous"),4.1, Arrays.asList("#Mausoleum", "#culinary"));
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
        GuideService.guideList = initGuide1;
        SerializationUtil.serialize(initGuide1,"D:\\code gym\\Tour_Guide_Management\\main\\src\\data\\guide.txt");
    }
}

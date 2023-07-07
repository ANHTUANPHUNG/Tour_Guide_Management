package Main;

import service.AuthService;
import service.GuideService;

import java.io.IOException;

import static utils.InitGuide.intGuide;

public class main1 {
    public static void main(String[] args) throws IOException {
        if( GuideService.guideList ==null){
            intGuide();
        }
        GuideService.displayGuide();
    }

//    public static void main(String[] args) {
//        if(AuthService.)
//    }
}
